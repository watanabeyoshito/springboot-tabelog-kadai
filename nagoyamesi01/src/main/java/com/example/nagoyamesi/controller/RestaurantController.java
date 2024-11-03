package com.example.nagoyamesi.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.nagoyamesi.entity.Category;
import com.example.nagoyamesi.entity.Favorite;
import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.entity.Review;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.ReservationInputForm;
import com.example.nagoyamesi.repository.CategoryRepository;
import com.example.nagoyamesi.repository.FavoriteRepository;
import com.example.nagoyamesi.repository.RestaurantRepository;
import com.example.nagoyamesi.repository.ReviewRepository;
import com.example.nagoyamesi.security.UserDetailsImpl;
import com.example.nagoyamesi.service.FavoriteService;
import com.example.nagoyamesi.service.ReviewService;

@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final ReviewService reviewService;
    private final FavoriteRepository favoriteRepository;
    private final FavoriteService favoriteService;
    
    public RestaurantController(RestaurantRepository restaurantRepository, CategoryRepository categoryRepository, ReviewRepository reviewRepository, ReviewService reviewService, FavoriteService favoriteService, FavoriteRepository favoriteRepository) {
        this.restaurantRepository = restaurantRepository;
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
        this.reviewService = reviewService;
        this.favoriteRepository = favoriteRepository;
        this.favoriteService = favoriteService;
    }     
  
    @GetMapping
	public String index(@RequestParam(name = "keyword", required = false) String keyword,
			@RequestParam(name = "aria", required = false) String area,
			@RequestParam(name = "lowestPrice", required = false) Integer lowestPrice,
			@RequestParam(name = "order", required = false) String order,
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
			Model model) {
		Page<Restaurant> restaurantPage;
		List<Category> category = categoryRepository.findAll();

		if (keyword != null && !keyword.isEmpty()) {
			if (order != null && order.equals("lowestPriceAsc")) {
				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByLowestPriceAsc(
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			} else {
				restaurantPage = restaurantRepository.findByNameLikeOrAddressLikeOrderByCreatedAtDesc(
						"%" + keyword + "%", "%" + keyword + "%", pageable);
			}

		} else if (lowestPrice != null) {
			if (order != null && order.equals("lowestPriceDesc")) {
				restaurantPage = restaurantRepository.findByHighestPriceLessThanEqualOrderByCreatedAtDesc(lowestPrice,
						pageable);
			} else {
				restaurantPage = restaurantRepository.findByHighestPriceLessThanEqualOrderByLowestPriceAsc(lowestPrice,
						pageable);
			}
		} else {
			if (order != null && order.equals("lowestPriceAsc")) {
				restaurantPage = restaurantRepository.findAllByOrderByHighestPriceAsc(pageable);
			} else {
				restaurantPage = restaurantRepository.findAllByOrderByCreatedAtDesc(pageable);
			}
		}

		model.addAttribute("restaurantPage", restaurantPage);
		model.addAttribute("category", category);
		model.addAttribute("keyword", keyword);
		model.addAttribute("lowestPrice", lowestPrice);
		model.addAttribute("order", order);

		return "restaurants/index";
	}
    
    @GetMapping("{id}")
	public String show(@PathVariable(name = "id") Integer id, Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
    	Restaurant restaurant = restaurantRepository.getReferenceById(id);
    	Category category = categoryRepository.getReferenceById(id);
    	boolean hasUserAlreadyReviewed = false;
    	Favorite favorite = null;
    	boolean hasFavorite = false;
    	
    	if(userDetailsImpl != null) {
    		User user =userDetailsImpl.getUser();
    		hasUserAlreadyReviewed = reviewService.hasUserAlreadyReviewed(restaurant, user);
    		hasFavorite = favoriteService.hasFavorite(restaurant, user);
    		if(hasFavorite) {
    			favorite = favoriteRepository.findByRestaurantAndUser(restaurant, user);
    		}
    	}
    	
    	List<Review> newRewviews = reviewRepository.findTop6ByRestaurantOrderByCreatedAtDesc(restaurant);
    	long totalReviewCount = reviewRepository.countByRestaurant(restaurant);
    	
		model.addAttribute("restaurant", restaurant);
		model.addAttribute("category", category);
		model.addAttribute("reservationInputForm", new ReservationInputForm());
		model.addAttribute("hasUserAlreadyReviewed", hasUserAlreadyReviewed);
		model.addAttribute("newReviews", newRewviews);
		model.addAttribute("totalReviewCount", totalReviewCount);
		model.addAttribute("favorite", favorite);
		model.addAttribute("hasFavorite", hasFavorite);
		
		return "restaurants/show";
	}

}

package com.example.nagoyamesi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyamesi.entity.Restaurant;
import com.example.nagoyamesi.entity.Role;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.repository.RestaurantRepository;
import com.example.nagoyamesi.repository.UserRepository;
import com.example.nagoyamesi.security.UserDetailsImpl;

@Controller
public class HomeController {
	private final RestaurantRepository restaurantRepository; 
    private final UserRepository userRepository;
    public HomeController(RestaurantRepository restaurantRepository, UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.userRepository = userRepository;
    }
	
    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
                        RedirectAttributes redirectAttributes) {
        List<Restaurant> newRestaurants = restaurantRepository.findTop10ByOrderByCreatedAtDesc();
        model.addAttribute("newrestaurants", newRestaurants);

        // 認証情報が存在する場合にのみ、ユーザー情報と権限を更新
        if (userDetailsImpl != null) {
            User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
            Role role = user.getRole();
            
            // 現在の認証情報を取得
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            
            // 新しい認証情報を作成
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            Authentication Auth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
            
            // 認証情報を更新
            SecurityContextHolder.getContext().setAuthentication(Auth);
            
        }

        return "index";
    }
}
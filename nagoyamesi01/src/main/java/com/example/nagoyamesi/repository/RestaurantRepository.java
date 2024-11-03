package com.example.nagoyamesi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	public Page<Restaurant> findByNameLike(String keyword, Pageable pageable);
	public Page<Restaurant> findByNameLikeOrAddressLikeOrderByCreatedAtDesc(String nameKeyword, String addressKeyword,Pageable pageable);
	public Page<Restaurant> findByNameLikeOrAddressLikeOrderByLowestPriceAsc(String nameKeyword, String addressKeyword,Pageable pageable);
	public Page<Restaurant> findByHighestPriceLessThanEqualOrderByCreatedAtDesc(Integer lowestPrice, Pageable pageable);
	public Page<Restaurant> findByHighestPriceLessThanEqualOrderByLowestPriceAsc(Integer lowestPrice, Pageable pageable);
	public Page<Restaurant> findAllByOrderByCreatedAtDesc(Pageable pageable);
	public Page<Restaurant> findAllByOrderByHighestPriceAsc(Pageable pageable);

	public List<Restaurant> findTop10ByOrderByCreatedAtDesc();

	public Page<Restaurant> findByCategoryId(Integer categoryId, Pageable pageable);
}
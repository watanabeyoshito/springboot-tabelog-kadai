package com.example.nagoyamesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyamesi.entity.Subscription;


public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
    
	public Subscription findByStripeCustomerId(String stripeCustomerId);

	public Subscription findByUserId(Integer userId);
}
package com.example.nagoyamesi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.nagoyamesi.entity.Subscription;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.form.PaymentEditForm;
import com.example.nagoyamesi.repository.SubscriptionRepository;
import com.example.nagoyamesi.repository.UserRepository;
import com.example.nagoyamesi.security.UserDetailsImpl;
import com.example.nagoyamesi.service.StripeService;
import com.example.nagoyamesi.service.UserService;
import com.stripe.exception.StripeException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
	private final UserRepository userRepository;
	private final UserService userService;
	private final StripeService stripeService;
	private final SubscriptionRepository subscriptionRepository;
	
	public SubscriptionController(UserRepository userRepository,
			UserService userService, StripeService stripeService,
			SubscriptionRepository subscriptionRepository
			) {
		this.userRepository = userRepository;
		this.userService = userService;
		this.stripeService = stripeService;
		this.subscriptionRepository = subscriptionRepository;
	}

	@GetMapping("/register")
	public String index() {
		return "subscription/register";
	}

	@PostMapping("/create")
	public String create(Model model, HttpServletRequest httpServletRequest,
			@AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
		User user = userDetailsImpl.getUser();
		 String sessionUrl = stripeService.createStripeSession(httpServletRequest, user);
		
		return "redirect:" + sessionUrl;
	}
	
	
	@GetMapping("/delete")
	public String deleteModel(Model model) {
	    return "subscription/delete";
	}
	
	
	@PostMapping("/delete")
	public String delete(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,
			RedirectAttributes redirectAttributes, Model model) {
		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
		userService.downgradeRole(user.getId());

		redirectAttributes.addFlashAttribute("successMessage", "サブスクリプションを解約しました。");

		return "redirect:/";
	}
	
	@GetMapping("/payment")
	public String PaymentPage(Model model) {
		model.addAttribute("paymentEditForm", new PaymentEditForm( null, null));
	    return "subscription/payment"; 
	}
	
	@PostMapping("/payment")
	public String payment(@Valid @ModelAttribute PaymentEditForm paymentEditForm, 
	                      RedirectAttributes redirectAttributes,
	                      Model model,
	                      @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
	    try {

	        // ユーザーIDを使ってサブスクリプションを取得し、顧客IDを取得
	        Subscription subscription = subscriptionRepository.findByUserId(userDetailsImpl.getUser().getId());
	        if (subscription == null) {
	            throw new IllegalArgumentException("指定されたユーザーに関連するサブスクリプションが見つかりません。");
	        }
	        
	        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
	        
		    
	        String stripeCustomerId = subscription.getStripeCustomerId();
	        
	        if (stripeCustomerId == null) {
	            throw new IllegalArgumentException("顧客IDがありません。");
	        }
	        
	        
	        // 受け取ったトークンを利用して支払い方法を更新
	        String newPaymentMethodId = stripeService.updatePaymentMethod(
	            stripeCustomerId, 
	            paymentEditForm.getStripeToken() // トークンを渡す
	        );

	        redirectAttributes.addFlashAttribute("successMessage", "支払い情報を変更しました。");
	    } catch (StripeException e) {
	        System.out.println(e);
	        
	        redirectAttributes.addFlashAttribute("errorMessage", "カード情報の更新に失敗しました。");
	        model.addAttribute("paymentEditForm", paymentEditForm);
	        return "redirect:/subscription/payment";
	    }
	    return "redirect:/";
	}
}
	
//	@PostMapping("/payment")
//	public String payment(@Valid @ModelAttribute PaymentEditForm paymentEditForm, 
//	                      RedirectAttributes redirectAttributes,
//	                      Model model,
//	                      @AuthenticationPrincipal UserDetailsImpl userDetailsImpl) {
//		System.out.println("カード更新2");
//		
//		model.addAttribute("paymentEditForm", new PaymentEditForm( null, null, null, null, null));
//	    
//	    try {
//	    	System.out.println("カード更新3");
////	    	System.out.println(paymentEditForm.getCardNumber());
//	    	
//	    	
//	        User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
//	        String stripeCustomerId = userDetailsImpl.getStripeCustomerId();
//	        String newPaymentMethodId = stripeService.updatePaymentMethod(
////	            stripeCustomerId,
//	        		"cus_R3JXL05UplXf30",
//	            paymentEditForm.getCardNumber(),
//	            paymentEditForm.getCardHolderName(),
//	            paymentEditForm.getExpMonth(),
//	            paymentEditForm.getExpYear(),
//	            paymentEditForm.getSecurityCode()
//	        );
//	        
////	        System.out.println(paymentEditForm.getCardNumber());
//	        
////	        userService.updateDefaultPaymentMethod(user.getId(), newPaymentMethodId);
//	        redirectAttributes.addFlashAttribute("successMessage", "支払い情報を変更しました。");
//	    } catch (StripeException e) {
//	    	System.out.println("エラー");
//	    	System.out.println(e);
////	    	System.out.println(model.addAttribute("paymentEditForm", paymentEditForm));
//	    	
//	        redirectAttributes.addFlashAttribute("errorMessage", "カード情報の更新に失敗しました: " );
//
//	        model.addAttribute("paymentEditForm", paymentEditForm);
//	        return "redirect:/subscription/payment";
//	    }
//	    
//	    return "redirect:/";
//	}
//}

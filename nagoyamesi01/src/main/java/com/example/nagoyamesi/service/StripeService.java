package com.example.nagoyamesi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.nagoyamesi.entity.Subscription;
import com.example.nagoyamesi.entity.User;
import com.example.nagoyamesi.repository.SubscriptionRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.Event;
import com.stripe.model.PaymentMethod;
import com.stripe.model.StripeObject;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerUpdateParams;
import com.stripe.param.PaymentMethodAttachParams;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StripeService {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private SubscriptionRepository subscriptionRepository;
	
	@Value("${stripe.api-key}")
	private String stripeApiKey;
	
	
	// Stripeの支払いセッションを作成
	public String createStripeSession(HttpServletRequest httpServletRequest, User user) {
		Stripe.apiKey = stripeApiKey;
	    String baseUrl = httpServletRequest.getRequestURL().toString().replace(httpServletRequest.getRequestURI(), "");

	    SessionCreateParams params = SessionCreateParams.builder()
	            .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
	            .addLineItem(
	                    SessionCreateParams.LineItem.builder()
	                            .setPriceData(
	                                    SessionCreateParams.LineItem.PriceData.builder()
	                                            .setProductData(
	                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
	                                                            .setName("有料プラン (月額)")
	                                                            .build())
	                                            .setUnitAmount(300L)
	                                            .setCurrency("jpy")
	                                            .setRecurring(
	                                                    SessionCreateParams.LineItem.PriceData.Recurring.builder()
	                                                            .setInterval(SessionCreateParams.LineItem.PriceData.Recurring.Interval.MONTH)
	                                                            .build())
	                                            .build())
	                            .setQuantity(1L)
	                            .build())
	            
	            .setMode(SessionCreateParams.Mode.SUBSCRIPTION)
	            .setSuccessUrl(baseUrl + "")
	            .setCancelUrl(baseUrl + "/subscription")
	            .putMetadata("userId", String.valueOf(user.getId()))
	            .build();
	    
	    try {
	        Session session = Session.create(params);
	        return session.getUrl();  
	    } catch (StripeException e) {
	        System.err.println("Stripeセッション作成エラー: " + e.getMessage());
	        e.printStackTrace();
	        return "";
	    }
	}
	
	// セッション完了時の処理
		public void processSessionCompleted(Event event) {
	    Optional<StripeObject> optionalStripeObject = event.getDataObjectDeserializer().getObject();
		optionalStripeObject.ifPresent(stripeObject -> {
			Session session = (Session) stripeObject;
			Integer userId = Integer.valueOf(session.getMetadata().get("userId"));
			userService.upgradeRole(userId);
		});   
	}
		
		// サブスクリプションを顧客IDで取得
	    public Subscription findSubscriptionByStripeCustomerId(String stripeCustomerId) {
	        return subscriptionRepository.findByStripeCustomerId(stripeCustomerId);
	    }

	    // 支払い方法を更新
	    public String updatePaymentMethod(String stripeCustomerId, String token) throws StripeException {
	        Stripe.apiKey = stripeApiKey;


	        // 顧客のサブスクリプションを取得
	        Subscription subscription = findSubscriptionByStripeCustomerId(stripeCustomerId);
	        

	        // サブスクリプションが存在しない場合はエラー処理を行う
	        if (subscription == null) {
	            throw new IllegalArgumentException("指定された顧客IDに関連するサブスクリプションが見つかりません。");
	        }

	        // 顧客IDを取得
	        String customerId = subscription.getStripeCustomerId(); // サブスクリプションから顧客IDを取得


	        // トークンから新しいPaymentMethodを取得
	        PaymentMethod paymentMethod = PaymentMethod.retrieve(token);

	        // 新しいPaymentMethodを顧客にアタッチ
	        paymentMethod.attach(PaymentMethodAttachParams.builder()
	                .setCustomer(customerId)
	                .build());

	        // 顧客のデフォルト支払い方法を更新
	        CustomerUpdateParams updateParams = CustomerUpdateParams.builder()
	                .setInvoiceSettings(
	                        CustomerUpdateParams.InvoiceSettings.builder()
	                                .setDefaultPaymentMethod(paymentMethod.getId())
	                                .build()
	                ).build();


	        Customer customer = Customer.retrieve(customerId);
	        customer.update(updateParams);


	        return paymentMethod.getId();
	    }
	}
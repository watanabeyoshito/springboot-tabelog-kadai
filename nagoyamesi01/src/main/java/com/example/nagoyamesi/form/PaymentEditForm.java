package com.example.nagoyamesi.form;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentEditForm {
	@NotBlank(message = "カード名義を入力してください。")
    private String cardHolderName; // カード名義
    
    private String stripeToken; // Stripeから生成されるトークン

}


package com.tck.stripe_poc.controller;

import com.tck.stripe_poc.entity.ChargeRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {

//    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey = "pk_test_Ohn8RBymdJkTHfjTIB2GcGap";
//    private String stripePublicKey = "pk_test_bWa36rUPUpNchiAr0LLQmVo5";

    @RequestMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 5000); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }
}

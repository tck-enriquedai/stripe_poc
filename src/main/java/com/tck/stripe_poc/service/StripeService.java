package com.tck.stripe_poc.service;

import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

//    @Value("${STRIPE_SECRET_KEY}")
    private String secretKey = "sk_test_0vFdM6a8Kd0KMVevuNs81SY4";
//    private String secretKey = "sk_test_rQj85IlGr8UvfdDhAhWBRN7V";

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Charge charge(com.tck.stripe_poc.entity.ChargeRequest chargeRequest) throws AuthenticationException, InvalidRequestException,
            APIConnectionException, CardException, APIException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
}

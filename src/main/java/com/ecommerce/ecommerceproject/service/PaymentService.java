package com.ecommerce.ecommerceproject.service;

import org.json.JSONObject;

public interface PaymentService {

	JSONObject createOrder(
			Integer amount
			) throws Exception;
}

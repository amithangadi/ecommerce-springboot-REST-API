package com.ecommerce.ecommerceproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceproject.entity.Review;
import com.ecommerce.ecommerceproject.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

	private final ReviewService service;
	
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	@PostMapping
	public Review add(@RequestBody Review review) {
		return service.add(review);
	}
	
	@GetMapping("/{productId}")
	public List<Review> get(@PathVariable Long productId) {
		return service.getByProduct(productId);
	}
	
	@GetMapping("/average/{productId}")
	public Double average(@PathVariable Long productId) {
		return service.average(productId);
	}
}


//while adding the reviews use the below json format in the postman

//{
//    "rating": 0,
//    "comment": "good product",
//    "user":
//    {
//        "id":1
//    },
//    "product":
//    {
//        "id": 1
//    }
//}
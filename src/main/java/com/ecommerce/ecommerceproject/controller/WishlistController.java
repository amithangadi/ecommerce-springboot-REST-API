package com.ecommerce.ecommerceproject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerceproject.entity.WishList;
import com.ecommerce.ecommerceproject.service.WishListService;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

	private final WishListService service;
	
	public WishlistController(WishListService service) {
		this.service = service;
	}
	
	@PostMapping
	public WishList add(@RequestBody WishList wishList) {
		return service.add(wishList);
	}
	
	@GetMapping("/{userId}")
	public List<WishList> get(@PathVariable Long userId) {
		return service.getByUser(userId);
	}
	
	   @DeleteMapping("/{id}")
	    public String remove(@PathVariable Long id) {
	        service.remove(id);
	        return "Removed from wishlist";
	    }
}


//To adding the wishlist use below json format in postman or swagger

//{
//    "user" : {
//        "id" : 1
//    },
//    "product" : {
//        "id" : 1
//    }
//}

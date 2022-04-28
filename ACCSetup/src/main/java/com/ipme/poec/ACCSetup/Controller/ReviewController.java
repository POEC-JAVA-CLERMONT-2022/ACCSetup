package com.ipme.poec.ACCSetup.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Service.ReviewService;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public List<Review> listReview() {
		return reviewService.findAllReview();
	}

}

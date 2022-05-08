package com.ipme.poec.ACCSetup.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Service.ReviewService;
import com.ipme.poec.ACCSetup.Service.dto.review.ReviewDTO;

@RestController
@RequestMapping(value = "/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public List<Review> listReview() {
		
		return reviewService.findAllReview();
	}
	
	@PostMapping("/add")
    public ReviewDTO createReview(String title, String comment, int userId, int setupId) {

		ReviewDTO createdReview = reviewService.createReview(title, comment, userId, setupId);
        
        return createdReview;
    }

    @PutMapping("/edit")
    public ReviewDTO updateReview(String title, String comment, int userId, int setupId) {
        
		ReviewDTO updatedReview = reviewService.updateReview(title, comment, userId, setupId);
        
        return updatedReview;
    }
	
    @DeleteMapping("/delete")
    public ReviewDTO deleteReview(Long reviewId) {
    	
    	ReviewDTO deletedReview = reviewService.deleteReview(reviewId);
        
        return deletedReview;
    }

}

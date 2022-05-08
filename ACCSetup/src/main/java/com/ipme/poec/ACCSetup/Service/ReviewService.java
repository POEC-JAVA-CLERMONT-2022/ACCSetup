package com.ipme.poec.ACCSetup.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Repository.ReviewRepository;
import com.ipme.poec.ACCSetup.Repository.SetupRepository;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import com.ipme.poec.ACCSetup.Service.converter.ReviewConverter;
import com.ipme.poec.ACCSetup.Service.dto.review.ReviewDTO;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SetupRepository setupRepository;
	
	@Autowired
	private ReviewConverter reviewConverter;
	
	@Transactional
	public List<Review> findAllReview() {
		return reviewRepository.findAll();
	}
	
	@Transactional
	public List<Review> findByUser(Long userId) {
		return reviewRepository.findByUser_UserId(userId);
	}
	
	@Transactional
	public List<Review> findBySetup(Long setupId) {
		return reviewRepository.findBySetup_SetupId(setupId);
	}
	
	@Transactional
	public ReviewDTO createReview(String title, String comment, int userId, int setupId) {
		Review review = new Review(title, comment, userRepository.getById(userId), setupRepository.getById(setupId));
		
		review = this.reviewRepository.save(review);
		
		return reviewConverter.convertTo(review);
	}
	
	@Transactional
	public ReviewDTO deleteReview(Long reviewId) {
		Review deletedReview = reviewRepository.getById(reviewId);
		reviewRepository.deleteById(reviewId);
		return reviewConverter.convertTo(deletedReview);
	}
	
	@Transactional
	public ReviewDTO updateReview(String title, String comment, int userId, int setupId) {
		Review updatedReview = new Review(
				title,
				comment, 
				userRepository.getById(userId), 
				setupRepository.getById(setupId)
				);
		
		reviewRepository.save(updatedReview);
		
		return reviewConverter.convertTo(updatedReview);
	}
	
	public ReviewDTO findById(Long id) {
		return reviewConverter. convertTo(this.reviewRepository.getById(id));
	}
	
}

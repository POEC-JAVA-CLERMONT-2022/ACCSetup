package com.ipme.poec.ACCSetup.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Model.Setup;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.ReviewRepository;
import com.ipme.poec.ACCSetup.Service.converter.ReviewConverter;
import com.ipme.poec.ACCSetup.Service.dto.review.ReviewDTO;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ReviewConverter reviewConverter;
	
	@Transactional
	public ReviewDTO createReview(String title, String comment) {
		Review review = new Review(title, comment);
		
		review = this.reviewRepository.save(review);
		
		return reviewConverter.converterTo(review);
	}
	
	public ReviewDTO findById(Long id) {
		return reviewConverter. converterTo(this.reviewRepository.getById(id));
	}
	
	@Transactional
	public List<Review> findAllReview() {
		return reviewRepository.findAll();
	}
	
//	@Transactional
//	public List<Review> findByUser(User user) {
//		return reviewRepository.findByUser(user);
//	}
//	
//	@Transactional
//	public List<Review> findBySetup(Setup setup) {
//		return reviewRepository.findBySetup(setup);
//	}
	
	
}

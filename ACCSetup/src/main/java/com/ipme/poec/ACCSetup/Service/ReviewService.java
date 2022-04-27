package com.ipme.poec.ACCSetup.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Model.Setup;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional
	public List<Review> findAllReview() {
		return reviewRepository.findAll();
	}
	
	@Transactional
	public List<Review> findByUser(User user) {
		return reviewRepository.findByUser(user);
	}
	
	@Transactional
	public List<Review> findBySetup(Setup setup) {
		return reviewRepository.findBySetup(setup);
	}
	
	
}

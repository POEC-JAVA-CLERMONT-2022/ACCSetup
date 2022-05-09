package com.ipme.poec.ACCSetup;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Repository.ReviewRepository;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReviewConverterTest {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@BeforeEach
	public void initData() {
       Review review = new Review();//TODO
       this.reviewRepository.save(review);
       
    }

	@AfterEach
	public void destruct() {
		this.reviewRepository.deleteAll();
	}

	@Test
	public void testReviewConverter() {
		//TODO
	}
}

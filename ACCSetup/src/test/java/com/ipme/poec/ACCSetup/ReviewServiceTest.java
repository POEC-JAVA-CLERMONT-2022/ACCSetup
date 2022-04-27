package com.ipme.poec.ACCSetup;

import static org.junit.jupiter.api.Assertions.*;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Repository.ReviewRepository;
import com.ipme.poec.ACCSetup.Service.ReviewService;
import com.ipme.poec.ACCSetup.Service.dto.review.ReviewDTO;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReviewServiceTest {

	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@AfterAll
	public void afterAll() {
		
	}
	
	@BeforeEach
	public void initData() {
        EasyRandom easyRandom = new EasyRandom();

        for(int i = 0; i<10; i++) {
            Review review = easyRandom.nextObject(Review.class);
            this.reviewRepository.save(review);
        }
    }

//	@AfterEach
//	public void destruct() {
//		this.reviewRepository.deleteAll();
//	}

	@Test
	public void testCreateReview() {
		Long nbReviews = this.reviewRepository.count();
		String title = "Super réglages";
		String comment = "Je les ai testés pour aller chercher le pain, c'était super!";
		
		ReviewDTO created = this.reviewService.createReview(title, comment);
		
		assertThat(nbReviews + 1).isEqualTo(this.reviewRepository.count());
		assertThat(created.getId()).isNotNull();
        assertThat(created.getTitle()).isEqualTo(title);
        assertThat(created.getComment()).isEqualTo(comment);

	}

}

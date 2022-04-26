package com.ipme.poec.ACCSetup.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Model.Setup;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	Review getById(String id);
	
	Review getByTitle(String title);
	
	List<Review> findByUser(Review review);

	List<Review> findBySetup(Setup setup);

}

package com.ipme.poec.ACCSetup.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipme.poec.ACCSetup.Model.Review;
import com.ipme.poec.ACCSetup.Model.Setup;
import com.ipme.poec.ACCSetup.Model.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	List<Review> findBySetup_SetupId(Long id);
	
	List<Review> findByUser_UserId(Long id);
	
	List<Review> findBySetup(Setup setup);
	
	List<Review> findByUser(User user);

}

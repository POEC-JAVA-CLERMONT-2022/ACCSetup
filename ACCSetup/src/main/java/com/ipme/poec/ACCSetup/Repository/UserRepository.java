package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
//    @Query("SELECT u FROM User u WHERE u.userId = :id")
//    User findById(@Param("userId") User userId);
}

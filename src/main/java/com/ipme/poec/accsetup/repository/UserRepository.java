package com.ipme.poec.accsetup.repository;

import com.ipme.poec.accsetup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userName = :user_name")
    User getByUserName(@Param("user_name") String name);

    @Query("DELETE FROM User u WHERE u.userName = :user_name")
    User deleteByUserName(@Param("user_name") String name);
}

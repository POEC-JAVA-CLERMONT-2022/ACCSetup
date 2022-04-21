package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer> {
    //TODO: utiliser JPA
    @Query("SELECT u FROM User u WHERE u.userName = :user_name")
    User getByUserName(@Param("user_name") String name);
    //TODO: utiliser JPA
    @Query("DELETE FROM User u WHERE u.userName = :user_name")
    User deleteByUserName(@Param("user_name") String name);
}

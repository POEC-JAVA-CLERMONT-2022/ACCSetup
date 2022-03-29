package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

//    @Query("SELECT s FROM Session s WHERE s.sessionId = :id")
//    Session findById(@Param("sessionId") Session sessionId);
}

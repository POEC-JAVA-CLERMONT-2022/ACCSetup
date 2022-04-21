package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface SessionRepository extends JpaRepository<Session, Integer> {
    //TODO: utiliser JPA
    @Query("SELECT s FROM Session s WHERE s.sessionName = :sessionname")
    Session getBySessionName(@Param("sessionname") String name);
}

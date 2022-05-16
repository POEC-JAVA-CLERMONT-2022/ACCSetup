package com.ipme.poec.accsetup.repository;

import com.ipme.poec.accsetup.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SessionRepository extends JpaRepository<Session, Integer> {

    @Query("SELECT s FROM Session s WHERE s.sessionName = :sessionname")
    Session getBySessionName(@Param("sessionname") String name);
}

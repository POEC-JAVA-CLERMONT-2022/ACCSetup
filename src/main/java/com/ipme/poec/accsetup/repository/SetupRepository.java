package com.ipme.poec.accsetup.repository;

import com.ipme.poec.accsetup.model.Setup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface SetupRepository extends JpaRepository<Setup, Integer> {

    @Query("SELECT s FROM Setup s WHERE s.setupName = :setupname")
    Setup getBySetupName(@Param("setupname") String name);

}

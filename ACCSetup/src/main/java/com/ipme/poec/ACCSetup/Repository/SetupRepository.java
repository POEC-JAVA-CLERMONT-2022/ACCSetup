package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Setup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface SetupRepository extends JpaRepository<Setup, Integer> {
    //TODO: utiliser JPA
    @Query("SELECT s FROM Setup s WHERE s.setupName = :setupname")
    Setup getBySetupName(@Param("setupname") String name);

}

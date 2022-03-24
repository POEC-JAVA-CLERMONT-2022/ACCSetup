package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Setup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetupRepository extends JpaRepository<Setup, Integer> {

//    @Query("SELECT s FROM Setup s WHERE s.setupId = :id")
//    Setup findById(@Param("setupId") Setup setupId);

}

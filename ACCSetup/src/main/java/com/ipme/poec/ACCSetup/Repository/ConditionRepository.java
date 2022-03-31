package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface ConditionRepository extends JpaRepository<Condition, Integer> {

//    @Query("SELECT c FROM Condition c WHERE c.trackConditionId = :id")
//    Condition findById(@Param("conditionID") Condition conditionId);

}

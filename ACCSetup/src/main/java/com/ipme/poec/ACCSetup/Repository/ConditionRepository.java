package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Condition;
import com.ipme.poec.ACCSetup.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ConditionRepository extends JpaRepository<Condition, Integer> {

    List<Condition> findAll( );
    Optional<Condition> findById(Integer id);
    @Query("SELECT t FROM Condition t WHERE t.trackConditionId IN :ids")
    List<Condition> findByIdsIn(@Param("ids") List<Integer> ids);

    @Query("SELECT c FROM Condition c WHERE c.trackConditionName = :trackconditionname")
    Condition getConditionByName(@Param("trackconditionname") String name);

}

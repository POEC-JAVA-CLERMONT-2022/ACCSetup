package com.ipme.poec.accsetup.repository;

import com.ipme.poec.accsetup.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

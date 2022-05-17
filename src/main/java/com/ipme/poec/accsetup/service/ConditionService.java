package com.ipme.poec.accsetup.service;


import com.ipme.poec.accsetup.model.Condition;
import com.ipme.poec.accsetup.repository.ConditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConditionService {

    @Autowired
    private ConditionRepository conditionRepository;

    public List<Condition> findAllConditions() {
        return conditionRepository.findAll();
    }

    public Condition getConditionByName(String name) {
        return conditionRepository.getConditionByName(name);
    }

    public Condition saveCondition(Condition condition) {
        return conditionRepository.saveAndFlush(condition);
    }

    public Condition getConditionById(Integer id) {
        return conditionRepository.getById(id);
    }

    public List<Condition> findConditionsByIdsIn(List<Integer> ids) {
        return conditionRepository.findByIdsIn(ids);
    } //méthode pour obtenir une liste de conditions selon le choix de l'utilisateur (une ou plusieurs)
}

package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.Condition;
import com.ipme.poec.accsetup.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConditionController {

    @Autowired
    private SetupService setupService;

    @GetMapping("conditions")
    public List<Condition> getConditions() {
        return setupService.findAllConditions();
    }

}

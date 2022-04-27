package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.Condition;
import com.ipme.poec.ACCSetup.Service.SetupService;
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

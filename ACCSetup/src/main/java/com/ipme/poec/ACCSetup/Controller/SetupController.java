package com.ipme.poec.ACCSetup.Controller;

import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Service.SessionService;
import com.ipme.poec.ACCSetup.Service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SetupController {

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;


    @GetMapping("setups/search")
    public List<Setup> getSetups() {
        return setupService.findAll();
    }


//    @PostMapping("setups/add")   //mapping de la méthode
//    public void createSetup(List<Integer> weatherIds, List<Integer> conditionIds, Integer id){
//        setupService.createSetup(weatherIds,conditionIds,id);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
//    }

}

package com.ipme.poec.accsetup.controller;

import com.ipme.poec.accsetup.model.*;
import com.ipme.poec.accsetup.service.SessionService;
import com.ipme.poec.accsetup.service.SetupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setups")
public class SetupController {

    @Autowired
    private SetupService setupService;

    @Autowired
    private SessionService sessionService;


    @GetMapping
    public List<Setup> getSetups() {
        return setupService.findAll();
    }


    @PostMapping("/add")   //mapping de la méthode
    public void createSetup(String name, List<Integer> weatherIds, List<Integer> conditionIds, Session session) {
        setupService.createSetup(name, weatherIds, conditionIds, session);   //appel à la méthode de création du user dans le service, qui lui fait appel au repository
    }

    @PutMapping("/edit")
    public void updateSetup(Setup setup, String nameToUpdate, float setupFLCamberToUpdate, float setupFRCamberToUpdate, float setupRLCamberToUpdate, float setupRRCamberToUpdate, float setupFLPsiToUpdate, float setupFRPsiToUpdate, float setupRLPsiToUpdate, float setupRRPsiToUpdate, float setupFLToeToUpdate, float setupFRToeToUpdate, float setupRLToeToUpdate, float setupRRToeToUpdate, float setupFLCasterToUpdate, float setupFRCasterToUpdate, String setupDescToUpdate, List<Integer> conditionsToUpdate, List<Integer> weathersToUpdate) {
        setupService.updateSetup(setup, nameToUpdate, setupFLCamberToUpdate, setupFRCamberToUpdate, setupRLCamberToUpdate, setupRRCamberToUpdate, setupFLPsiToUpdate, setupFRPsiToUpdate, setupRLPsiToUpdate, setupRRPsiToUpdate, setupFLToeToUpdate, setupFRToeToUpdate, setupRLToeToUpdate, setupRRToeToUpdate, setupFLCasterToUpdate, setupFRCasterToUpdate, setupDescToUpdate, conditionsToUpdate, weathersToUpdate);
    }

    @DeleteMapping("/delete")
    public void deleteSetup(Setup setup) {
        setupService.deleteSetup(setup.getSetupId());
    }

}

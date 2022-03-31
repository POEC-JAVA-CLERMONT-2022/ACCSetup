package com.ipme.poec.ACCSetup.Service;

import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Repository.ConditionRepository;
import com.ipme.poec.ACCSetup.Repository.SetupRepository;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import com.ipme.poec.ACCSetup.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetupService {

    @Autowired
    private SetupRepository setupRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private WeatherRepository weatherRepository;

    public List<Setup> findAll() { return setupRepository.findAll(); } //méthode pour obtenir tous les users

    public Optional<Setup> findById(Integer id) { return setupRepository.findById(id); } //méthode pour obtenir un user selon son userId

    public Setup getSetupById(Integer id) { return setupRepository.getById(id);}

    public List<Condition> findAllConditions(Integer id) {return conditionRepository.findAll();}

    public List<Weather> findAllWeathers(Integer id) { return weatherRepository.findAll();}

    public Weather getWeatherById(Integer id) { return weatherRepository.getById(id);}

    public Condition getConditionById(Integer id) { return conditionRepository.getById(id);}

    public void createSetup(Setup setup) { setupRepository.saveAndFlush(setup); } //méthode de création d'un user

    public void deleteSetup(Integer id) { setupRepository.deleteById(id); } //méthode de suppression d'un user, selon son userId

    public void updateUser(Setup setup, Integer id) {
        Setup setupToUpdate = setupRepository.getById(id);
        setupToUpdate.setSetupDesc(setup.getSetupDesc());
        setupToUpdate.setSetupFLCamber(setup.getSetupFLCamber());
        setupToUpdate.setSetupFRCamber(setup.getSetupFRCamber());
        setupToUpdate.setSetupRLCamber(setup.getSetupRLCamber());
        setupToUpdate.setSetupRRCamber(setup.getSetupRRCamber());
        setupToUpdate.setSetupFLPsi(setup.getSetupFLPsi());
        setupToUpdate.setSetupFRPsi(setup.getSetupFRPsi());
        setupToUpdate.setSetupRLPsi(setup.getSetupRLPsi());
        setupToUpdate.setSetupRRPsi(setup.getSetupRRPsi());
        setupToUpdate.setSetupFLToe(setup.getSetupFLToe());
        setupToUpdate.setSetupFRToe(setup.getSetupFRToe());
        setupToUpdate.setSetupRLToe(setup.getSetupRLToe());
        setupToUpdate.setSetupRRToe(setup.getSetupRRToe());
        setupToUpdate.setSetupFLCaster(setup.getSetupFLCaster());
        setupToUpdate.setSetupFRCaster(setup.getSetupFRCaster());
        setupToUpdate.setConditions(setup.getConditions());
        setupToUpdate.setWeathers(setup.getWeathers());
        setupRepository.save(setupToUpdate);
    }



    // attributs
	//private int setupID;
	

	
	// m�thode de nouveau setup, ajout setup vierge ou setup clone � modifier
	
	// m�thode �dition du setup , modifier, enregistrer, enregistrer-sous
	
	// m�thode d'ajout de commentaire
	
	// 
	
	
	
}

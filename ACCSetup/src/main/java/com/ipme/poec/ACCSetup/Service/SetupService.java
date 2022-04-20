package com.ipme.poec.ACCSetup.Service;

import com.ipme.poec.ACCSetup.Model.*;
import com.ipme.poec.ACCSetup.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
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

    @Autowired
    private SessionRepository sessionRepository;

    public List<Setup> findAll() { return setupRepository.findAll(); }

    public Optional<Setup> findById(Integer id) { return setupRepository.findById(id); }

    public Setup getSetupById(Integer id) { return setupRepository.getById(id);}

    public List<Condition> findAllConditions() {return conditionRepository.findAll();}

    public Condition saveCondition(Condition condition) {return  conditionRepository.saveAndFlush(condition);}

    public List<Weather> findAllWeathers() { return weatherRepository.findAll();}

    public Weather saveWeather (Weather weather) {return  weatherRepository.saveAndFlush(weather);}

    public Weather getWeatherById(Integer id) { return weatherRepository.getById(id);}

    public List<Weather> findWeathersByIdsIn(List<Integer> ids) { return weatherRepository.findByIdsIn(ids);} //méthode pour obtenir une liste de météos selon le choix de l'utilisateur (une ou plusieurs)

    public List<Condition> findConditionsByIdsIn(List<Integer> ids) { return conditionRepository.findByIdsIn(ids);} //méthode pour obtenir une liste de conditions selon le choix de l'utilisateur (une ou plusieurs)

    public Condition getConditionById(Integer id) { return conditionRepository.getById(id);}

    public void createSetup(List<Integer> weatherIds, List<Integer> conditionIds, Integer sessionId) {


        List<Weather> weathers = new LinkedList<>(); //on initialise une liste de météos
        weathers = weatherRepository.findByIdsIn(weatherIds); //on appelle la méthode du service, faisant appel à la méthode du repository pour chercher des objets à partir d'une liste d'ids

        List<Condition> conditions = new LinkedList<>();
        conditions = conditionRepository.findByIdsIn(conditionIds);

        Session session = sessionRepository.getById(sessionId);
        Setup setup = new Setup();
        setup.setConditions(conditions);
        setup.setWeathers(weathers);
        setup.setSession(session);

        setupRepository.saveAndFlush(setup); } //méthode de création d'un user

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

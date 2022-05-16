package com.ipme.poec.accsetup.service;

import com.ipme.poec.accsetup.model.*;
import com.ipme.poec.accsetup.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SetupService {

    @Autowired
    private SetupRepository setupRepository;

    @Autowired
    private ConditionRepository conditionRepository;

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private SessionRepository sessionRepository;

    public List<Setup> findAll() {
        return setupRepository.findAll();
    }

    public Optional<Setup> findById(Integer id) {
        return setupRepository.findById(id);
    }

    public Setup getSetupById(Integer id) {
        return setupRepository.getById(id);
    }

    public Setup getSetupByName(String name) {
        return setupRepository.getBySetupName(name);
    }

    public List<Condition> findAllConditions() {
        return conditionRepository.findAll();
    }

    public Condition getConditionByName(String name) {
        return conditionRepository.getConditionByName(name);
    }

    public Condition saveCondition(Condition condition) {
        return conditionRepository.saveAndFlush(condition);
    }

    public List<Weather> findAllWeathers() {
        return weatherRepository.findAll();
    }

    public Weather saveWeather(Weather weather) {
        return weatherRepository.saveAndFlush(weather);
    }

    public Weather getWeatherById(Integer id) {
        return weatherRepository.getById(id);
    }

    public Weather getWeatherByName(String name) {
        return weatherRepository.getByWeatherName(name);
    }

    public List<Weather> findWeathersByIdsIn(List<Integer> ids) {
        return weatherRepository.findByIdsIn(ids);
    } //méthode pour obtenir une liste de météos selon le choix de l'utilisateur (une ou plusieurs)

    public List<Condition> findConditionsByIdsIn(List<Integer> ids) {
        return conditionRepository.findByIdsIn(ids);
    } //méthode pour obtenir une liste de conditions selon le choix de l'utilisateur (une ou plusieurs)

    public Condition getConditionById(Integer id) {
        return conditionRepository.getById(id);
    }

    public void createSetup(String name, List<Integer> weatherIds, List<Integer> conditionIds, Session session) {


        List<Weather> weathers = new LinkedList<>(); //on initialise une liste de météos
        weathers = weatherRepository.findByIdsIn(weatherIds); //on appelle la méthode du service, faisant appel à la méthode du repository pour chercher des objets à partir d'une liste d'ids

        List<Condition> conditions = new LinkedList<>();
        conditions = conditionRepository.findByIdsIn(conditionIds);

        Setup setup = new Setup();
        setup.setSetupName(name);
        setup.setConditions(conditions);
        setup.setWeathers(weathers);
        setup.setSession(session);

        setupRepository.saveAndFlush(setup);
    } //méthode de création d'un user

    public void deleteSetup(Integer id) {
        setupRepository.deleteById(id);
    } //méthode de suppression d'un user, selon son userId

    public void deleteAllSetups() {
        setupRepository.deleteAll();
    }

    public void updateSetup(Setup setup, String nameToUpdate, float setupFLCamberToUpdate, float setupFRCamberToUpdate, float setupRLCamberToUpdate, float setupRRCamberToUpdate, float setupFLPsiToUpdate, float setupFRPsiToUpdate, float setupRLPsiToUpdate, float setupRRPsiToUpdate, float setupFLToeToUpdate, float setupFRToeToUpdate, float setupRLToeToUpdate, float setupRRToeToUpdate, float setupFLCasterToUpdate, float setupFRCasterToUpdate, String setupDescToUpdate, List<Integer> conditionsToUpdate, List<Integer> weathersToUpdate) {
        setup.setSetupName(nameToUpdate);
        setup.setSetupFLCamber(setupFLCamberToUpdate);
        setup.setSetupFRCamber(setupFRCamberToUpdate);
        setup.setSetupRLCamber(setupRLCamberToUpdate);
        setup.setSetupRRCamber(setupRRCamberToUpdate);
        setup.setSetupFLPsi(setupFLPsiToUpdate);
        setup.setSetupFRPsi(setupFRPsiToUpdate);
        setup.setSetupRLPsi(setupRLPsiToUpdate);
        setup.setSetupRRPsi(setupRRPsiToUpdate);
        setup.setSetupFLToe(setupFLToeToUpdate);
        setup.setSetupFRToe(setupFRToeToUpdate);
        setup.setSetupRLToe(setupRLToeToUpdate);
        setup.setSetupRRToe(setupRRToeToUpdate);
        setup.setSetupFLCaster(setupFLCasterToUpdate);
        setup.setSetupFRCaster(setupFRCasterToUpdate);
        setup.setSetupDesc(setupDescToUpdate);

        List<Weather> weathers = new LinkedList<>(); //on initialise une liste de météos
        weathers = weatherRepository.findByIdsIn(weathersToUpdate); //on appelle la méthode du service, faisant appel à la méthode du repository pour chercher des objets à partir d'une liste d'ids

        List<Condition> conditions = new LinkedList<>();
        conditions = conditionRepository.findByIdsIn(conditionsToUpdate);

        setup.setConditions(conditions);
        setup.setWeathers(weathers);
        setupRepository.save(setup);
    }

    public void updateSetupByName(String setupName, String nameToUpdate, float setupFLCamberToUpdate, float setupFRCamberToUpdate, float setupRLCamberToUpdate, float setupRRCamberToUpdate, float setupFLPsiToUpdate, float setupFRPsiToUpdate, float setupRLPsiToUpdate, float setupRRPsiToUpdate, float setupFLToeToUpdate, float setupFRToeToUpdate, float setupRLToeToUpdate, float setupRRToeToUpdate, float setupFLCasterToUpdate, float setupFRCasterToUpdate, String setupDescToUpdate, List<Integer> conditionsToUpdate, List<Integer> weathersToUpdate) {
        Setup setup = setupRepository.getBySetupName(setupName);
        setup.setSetupName(nameToUpdate);
        setup.setSetupFLCamber(setupFLCamberToUpdate);
        setup.setSetupFRCamber(setupFRCamberToUpdate);
        setup.setSetupRLCamber(setupRLCamberToUpdate);
        setup.setSetupRRCamber(setupRRCamberToUpdate);
        setup.setSetupFLPsi(setupFLPsiToUpdate);
        setup.setSetupFRPsi(setupFRPsiToUpdate);
        setup.setSetupRLPsi(setupRLPsiToUpdate);
        setup.setSetupRRPsi(setupRRPsiToUpdate);
        setup.setSetupFLToe(setupFLToeToUpdate);
        setup.setSetupFRToe(setupFRToeToUpdate);
        setup.setSetupRLToe(setupRLToeToUpdate);
        setup.setSetupRRToe(setupRRToeToUpdate);
        setup.setSetupFLCaster(setupFLCasterToUpdate);
        setup.setSetupFRCaster(setupFRCasterToUpdate);
        setup.setSetupDesc(setupDescToUpdate);

        List<Weather> weathers = new LinkedList<>(); //on initialise une liste de météos
        weathers = weatherRepository.findByIdsIn(weathersToUpdate); //on appelle la méthode du service, faisant appel à la méthode du repository pour chercher des objets à partir d'une liste d'ids

        List<Condition> conditions = new LinkedList<>();
        conditions = conditionRepository.findByIdsIn(conditionsToUpdate);

        setup.setConditions(conditions);
        setup.setWeathers(weathers);
        setupRepository.save(setup);
    }

}

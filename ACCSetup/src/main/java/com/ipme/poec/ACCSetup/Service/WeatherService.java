package com.ipme.poec.ACCSetup.Service;


import com.ipme.poec.ACCSetup.Model.Weather;
import com.ipme.poec.ACCSetup.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

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

}

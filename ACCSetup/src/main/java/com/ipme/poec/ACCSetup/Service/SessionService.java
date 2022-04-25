package com.ipme.poec.ACCSetup.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.ipme.poec.ACCSetup.Model.Car;
import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipme.poec.ACCSetup.Model.Session;
import com.ipme.poec.ACCSetup.Repository.CarRepository;
import com.ipme.poec.ACCSetup.Repository.SessionRepository;
import com.ipme.poec.ACCSetup.Repository.TrackRepository;

@Service
public class SessionService {


    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TrackRepository trackRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Session> findAllSessions() {
        return sessionRepository.findAll();
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public List<Track> findAllTracks() {
        return trackRepository.findAll();
    }

    public Optional<Session> findSessionById(Integer id) {
        return sessionRepository.findById(id);
    } //méthode pour obtenir un user selon son userId

    public Session getSessionById(Integer id) {
        return sessionRepository.getById(id);
    }

    public Session getSessionByName(String name) {
        return sessionRepository.getBySessionName(name);
    }

//    public Session getSessionByName(String name) {
//        return sessionRepository.getBySessionName(name);
//    }

    public Optional<Car> findCarById(Integer id) {
        return carRepository.findById(id);
    } //méthode pour obtenir la voiture

    public Car getCarById(Integer id) {
        return carRepository.getById(id);
    } //méthode pour obtenir obligatoirement la voiture, qui est forcément nécessaire pour créer une session

    public Car getCarByName(String name) {
        return carRepository.getCarByName(name);
    }

    public Car saveCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    public Optional<Track> findTrackById(Integer id) {
        return trackRepository.findById(id);
    } //méthode pour obtenir la piste

    public Track getTrackById(Integer id) {
        return trackRepository.getById(id);
    } //méthode pour obtenir obligatoirement la piste, qui est forcément nécessaire pour créer une session

    public Track getTrackByName(String name) {
        return trackRepository.getByTrackName(name);
    }

    public Track saveTrack(Track track) {
        return trackRepository.saveAndFlush(track);
    }

    public User getUserById(Integer id) {
        return userRepository.getById(id);
    } //méthode pour récupérer un user, qui est forcément lié à une session


    public void createSession(String sessionName, LocalDate sessionDate, Track track, Car car, User user) {
        Session session = new Session();
        session.setSessionName(sessionName);
        session.setSessionDate(sessionDate);
        session.setCar(car);
        session.setTrack(track);
        session.setUser(user);

        sessionRepository.saveAndFlush(session);
    }

    public void deleteSession(Integer id) {
        sessionRepository.deleteById(id);
    } //méthode de suppression d'un user, selon son userId

    public void deleteAllSessions() {
        sessionRepository.deleteAll();
    }

    public void deleteAllCars() {
        carRepository.deleteAll();
    }

    public void deleteAllTracks() {
        trackRepository.deleteAll();
    }

    public void updateSession(Session session, String sessionNameUpdate, LocalDate sessionDateUpdate) {
        session.setSessionName(sessionNameUpdate);
        session.setSessionDate(sessionDateUpdate);
        sessionRepository.save(session);
    }

}

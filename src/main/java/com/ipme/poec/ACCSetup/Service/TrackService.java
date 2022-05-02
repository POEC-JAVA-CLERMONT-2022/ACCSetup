package com.ipme.poec.ACCSetup.Service;


import com.ipme.poec.ACCSetup.Model.Track;
import com.ipme.poec.ACCSetup.Repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {


    @Autowired
    private TrackRepository trackRepository;

    public List<Track> findAllTracks() {
        return trackRepository.findAll();
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

    public void deleteAllTracks() {
        trackRepository.deleteAll();
    }

}

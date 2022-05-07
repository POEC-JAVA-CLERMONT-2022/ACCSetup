package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TrackRepository extends JpaRepository<Track, Integer> {

    @Query("SELECT t FROM Track t WHERE t.trackName = :trackname")
    Track getByTrackName(@Param("trackname") String name);

}

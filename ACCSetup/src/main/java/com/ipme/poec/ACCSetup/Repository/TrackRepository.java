package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {

//    @Query("SELECT t FROM Track t WHERE t.trackId = :id")
//    Track findById(@Param("trackId") Track trackId);

}

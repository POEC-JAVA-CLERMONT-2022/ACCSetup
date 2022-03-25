package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;

@Entity
@Table(name = "track")
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trackid", length = 11)
    private int trackId;

    @Column(name = "trackname", length = 255)
    private String trackName;

    public Track(int trackId, String trackName) {
        this.trackId = trackId;
        this.trackName = trackName;
    }

    public Track() {

    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        return trackId == track.trackId;
    }

    @Override
    public int hashCode() {
        return trackId;
    }
}

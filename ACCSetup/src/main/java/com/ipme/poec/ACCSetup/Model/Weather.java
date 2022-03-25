package com.ipme.poec.ACCSetup.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "weather")
public class Weather {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weatherID", length = 11)
    private int weatherId;

    @Column(name = "weather_name", length = 255)
    private String weatherName;


    public Weather(int weatherId, String weatherName) {
        this.weatherId = weatherId;
        this.weatherName = weatherName;
    }

    public Weather() {

    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Weather weather = (Weather) o;

        return weatherId == weather.weatherId;
    }

    @Override
    public int hashCode() {
        return weatherId;
    }
}

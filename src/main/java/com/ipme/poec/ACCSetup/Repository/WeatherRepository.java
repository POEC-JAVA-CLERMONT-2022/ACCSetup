package com.ipme.poec.ACCSetup.Repository;

import com.ipme.poec.ACCSetup.Model.User;
import com.ipme.poec.ACCSetup.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    List<Weather> findAll( );
    Optional<Weather> findById(Integer id);
    @Query("SELECT t FROM Weather t WHERE t.weatherId IN :ids")
    List<Weather> findByIdsIn(@Param("ids") List<Integer> ids);


    @Query("SELECT w FROM Weather w WHERE w.weatherName = :weather_name")
    Weather getByWeatherName(@Param("weather_name") String name);
}

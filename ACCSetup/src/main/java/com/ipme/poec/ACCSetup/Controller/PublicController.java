package com.ipme.poec.ACCSetup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.poec.ACCSetup.Service.CarService;
import com.ipme.poec.ACCSetup.Service.ConditionService;
import com.ipme.poec.ACCSetup.Service.ReviewService;
import com.ipme.poec.ACCSetup.Service.TrackService;
import com.ipme.poec.ACCSetup.Service.WeatherService;

@Controller
public class PublicController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private TrackService trackService;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private ConditionService conditionService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/")
	public ModelAndView index( ) {
		return new ModelAndView("index");
	}

	@GetMapping("/car-list")
	public ModelAndView carList( ) {
		ModelAndView mAV = new ModelAndView("cars/car-list");
		
		mAV.addObject("cars", carService.findAllCars());

        return mAV;
	}
	
	@GetMapping("/track-list")
	public ModelAndView trackList( ) {
		ModelAndView mAV = new ModelAndView("tracks/track-list");
		
		mAV.addObject("tracks", trackService.findAllTracks());

        return mAV;
	}
	
	@GetMapping("/weather-list")
	public ModelAndView weatherList( ) {
		ModelAndView mAV = new ModelAndView("weathers/weather-list");
		
		mAV.addObject("weathers", weatherService.findAllWeathers());

        return mAV;
	}
	
	@GetMapping("/condition-list")
	public ModelAndView conditionList( ) {
		ModelAndView mAV = new ModelAndView("conditions/condition-list");
		
		mAV.addObject("conditions", conditionService.findAllConditions());

        return mAV;
	}
	
	@GetMapping("/review-list")
	public ModelAndView reviewList( ) {
		ModelAndView mAV = new ModelAndView("reviews/review-list");
		
		mAV.addObject("reviews", reviewService.findAllReview());

        return mAV;
	}
	
	
}

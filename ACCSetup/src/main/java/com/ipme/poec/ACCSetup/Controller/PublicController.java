package com.ipme.poec.ACCSetup.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ipme.poec.ACCSetup.Service.SessionService;

@Controller
public class PublicController {
	
	@Autowired
	private SessionService sessionService;
	
	@GetMapping("/")
	public ModelAndView index( ) {
		return new ModelAndView("index");
	}

	@GetMapping("/car-list")
	public ModelAndView carList( ) {
		ModelAndView mAV = new ModelAndView("cars/car-list");
		
		mAV.addObject("cars", sessionService.findAllCars());

        return mAV;
	}
	
	@GetMapping("/track-list")
	public ModelAndView trackList( ) {
		ModelAndView mAV = new ModelAndView("tracks/track-list");
		
		mAV.addObject("tracks", sessionService.findAllTracks());

        return mAV;
	}
	
	
}

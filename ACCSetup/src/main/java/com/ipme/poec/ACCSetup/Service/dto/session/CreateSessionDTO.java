package com.ipme.poec.ACCSetup.Service.dto.session;

import javax.validation.constraints.NotBlank;

public class CreateSessionDTO {
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String date;
	
	@NotBlank
	private int trackId;
	
	@NotBlank
	private int carId;

	public CreateSessionDTO() {
	}

	public CreateSessionDTO(@NotBlank String name, @NotBlank String date, @NotBlank int trackId, @NotBlank int carId) {
		this.name = name;
		this.date = date;
		this.trackId = trackId;
		this.carId = carId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTrackId() {
		return trackId;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	

}

package com.ipme.poec.ACCSetup;

import java.util.Objects;

public class Car {

	private Double carId;
	private String carName;
	public Car(Double carId, String carName) {
		super();
		this.carId = carId;
		this.carName = carName;
	}
	public Double getCarId() {
		return carId;
	}
	public void setCarId(Double carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", carName=" + carName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(carId, carName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(carId, other.carId) && Objects.equals(carName, other.carName);
	}
	
	
	
}

package com.ipme.poec.ACCSetup.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carID", length = 11)
	private int carId;

	@Column(name = "carNAME", length = 100)
	@NotNull
	private String carName;

	public Car(String carName) {
		this.carName = carName;
	}

	public Car(int carId, String carName) {
		this.carId = carId;
		this.carName = carName;
	}

	public Car() {

	}


	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
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

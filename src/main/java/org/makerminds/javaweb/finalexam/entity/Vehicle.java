package org.makerminds.javaweb.finalexam.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "vehicle")
//@Data  @NoArgsConstructor @AllArgsConstructor lombok library doesnt work so i have manually generated constructors, getter and setters
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Long id;
	@NotBlank(message=" Manufacturer is required")
	@Column(name = "vehicle_manufacturer", nullable=false)
	private String manufacturer;
	@NotBlank(message=" Model is required")
	@Column(name = "vehicle_model", nullable=false)
	private String model;
	@NotNull(message=" Vehicle horsePower is required")
	@Min(value = 55, message = "Value must be greater than or equal to 55")
    @Max(value = 900, message = "Value must be less than or equal to 900")
	@Column(name = "vehicle_horsePower", nullable=false)
	private Long horsePower;
	@NotNull(message="Price is required")
	@Column(name = "vehicle_price", nullable=false)
	private Long price;
	@NotBlank(message="Color is required")
	private String color;
	@NotNull(message=" Vehicle mileage is required")
	@Column(name = "vehicle_mileage", nullable=false)
	private Long mileage;
	@NotNull(message="Vehicle production year is required")
	@Column(name = "vehicle_productionYear", nullable=false)
	private Long productionYear;
	@NotBlank(message="Vehicle transmission is required")
	@Column(name = "vehicle_transmission", nullable=false)
	private String transmission;
	@NotBlank(message="Vehicle fuelType is required")
	@Column(name = "vehicle_fuelType", nullable=false)
	private String fuelType;
		
	public Vehicle() {
	}
	
	public Vehicle(Long id, String manufacturer, String model, Long horsePower, Long price, 
		   String color, Long mileage, Long productionYear, String transmission, String fuelType) {
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.horsePower = horsePower;
		this.price = price;
		this.color = color;
		this.mileage = mileage;
		this.productionYear = productionYear;
		this.transmission = transmission;
		this.fuelType = fuelType;
	}

	public Long getId() {
		return id;
	}	
	public void setId(Long id) {
		this.id=id;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Long getHorsePower() {
		return horsePower;
	}
	public void setHorsePower(Long horsePower) {
		this.horsePower = horsePower;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Long getMileage() {
		return mileage;
	}
	public void setMileage(Long mileage) {
		this.mileage = mileage;
	}
	public Long getProductionYear() {
		return productionYear;
	}
	public void setProductionYear(Long productionYear) {
		this.productionYear = productionYear;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
}

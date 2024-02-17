package org.makerminds.javaweb.finalexam.controller;
import java.util.HashMap;
import java.util.Map;
import org.makerminds.javaweb.finalexam.entity.Vehicle;
import org.makerminds.javaweb.finalexam.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/api/vehicles")
@CrossOrigin()

public class VehicleController {
	private final VehicleService vehicleService;
	
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService=vehicleService;
	}
	@GetMapping(path = "/all")
	public Iterable<Vehicle> getVehicles() {
		return vehicleService.getAllVehicles();
	}
	@GetMapping(path="/{id}")
	public Vehicle getVehicleById(@PathVariable Long id) {
		return vehicleService.findById(id);
	}
	@PostMapping()
	public ResponseEntity<?> createVehicle(@Valid @RequestBody Vehicle vehicle, BindingResult results) {
		if(results.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			for(FieldError fieldError : results.getFieldErrors()) {
				errors.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(vehicleService.createOrUpdateVehicle(vehicle));
	}
	@DeleteMapping(path ="/delete/{id}")
	public ResponseEntity<?> sellVehicle(@PathVariable Long id) {
		return vehicleService.sellVehicle(id);
	}
}
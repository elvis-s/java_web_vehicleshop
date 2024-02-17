package org.makerminds.javaweb.finalexam.service;
import java.util.List;
import org.makerminds.javaweb.finalexam.entity.Vehicle;
import org.makerminds.javaweb.finalexam.repositorys.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor lombok library doesnt work, constructor is generated manually
public class VehicleService {
	
	private final VehicleRepository vehicleRepository;
	
	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}
	
	public Vehicle createOrUpdateVehicle(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
	public ResponseEntity<?> sellVehicle(Long id) {
		Vehicle vehicle = vehicleRepository.findById(id).orElse(null);
		if(vehicle !=null) {
		vehicleRepository.deleteById(id);
		String message= "Vehicle with id " + id+ "has been sold";
		return ResponseEntity.ok().body(message);
		}
		else {
			String message= "Vehicle with id " + id+ " was not found";
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
		}
	}
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}
	public Vehicle findById(Long id) {
		Vehicle vehicle= vehicleRepository.findById(id).orElse(null);
		return vehicle;
	}
}

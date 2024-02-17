package org.makerminds.javaweb.finalexam.repositorys;

import java.util.Optional;


import org.makerminds.javaweb.finalexam.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public Optional <Vehicle> findById(Long id);

}

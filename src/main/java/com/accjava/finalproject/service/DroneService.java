package com.accjava.finalproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accjava.finalproject.exception.ResourceNotFoundException;
import com.accjava.finalproject.model.Drone;
import com.accjava.finalproject.repository.DroneRepository;

@Service
public class DroneService {
  
  @Autowired
  private DroneRepository droneRepository;

  public List<Drone> getAllDrones() {
    return droneRepository.findAll();
  }

  public Drone createDrone(Drone drone) {
    return droneRepository.save(drone);
  }

  public ResponseEntity<Drone> getAllDroneById(Long id) {
    Drone droneFound = droneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drone doesn't exist with id: " + id));

    return ResponseEntity.ok(droneFound);
  }

  public ResponseEntity<Drone> updateDrone(Long id, Drone drone) {
    Drone droneFound = droneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drone doesn't exist with id: " + id));

    droneFound.setMarca(drone.getMarca());
    droneFound.setModelo(drone.getModelo());
    
    Drone updatedDrone = droneRepository.save(droneFound);

    return ResponseEntity.ok(updatedDrone);
  }

  public ResponseEntity<Map<String, Boolean>> deleteDrone(Long id) {
    Drone droneFound = droneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drone doesn't exist with id: " + id));

    droneRepository.delete(droneFound);
    Map<String, Boolean> response = new HashMap<>();
    response.put("Deleted", Boolean.TRUE);

    return ResponseEntity.ok(response);
  }




}

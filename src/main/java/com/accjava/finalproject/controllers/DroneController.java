package com.accjava.finalproject.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accjava.finalproject.model.Drone;
import com.accjava.finalproject.service.DroneService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/drones")
public class DroneController {
  
  @Autowired
  private DroneService droneService;

  @GetMapping
  public List<Drone> getAllDrones() {
    return droneService.getAllDrones();
  }

  @PostMapping
  public Drone createDrone(@RequestBody Drone drone) {
    return droneService.createDrone(drone);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Drone> getAllDroneById(@PathVariable Long id) {
    return droneService.getAllDroneById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Drone> updateDrone(@PathVariable Long id, @RequestBody Drone drone) {
    return droneService.updateDrone(id, drone);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteDrone(@PathVariable Long id) {
    return droneService.deleteDrone(id);
  }
}

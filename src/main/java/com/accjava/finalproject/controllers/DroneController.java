package com.accjava.finalproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accjava.finalproject.model.Drone;
import com.accjava.finalproject.service.DroneService;

@RestController
@RequestMapping("/drones")
public class DroneController {
  
  @Autowired
  private DroneService droneService;

  @GetMapping
  public List<Drone> getAllDrones() {
    return droneService.getAllDrones();
  }
}

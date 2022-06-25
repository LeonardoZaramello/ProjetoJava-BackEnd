package com.accjava.finalproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accjava.finalproject.model.Drone;
import com.accjava.finalproject.repository.DroneRepository;

@Service
public class DroneService {
  
  @Autowired
  private DroneRepository droneRepository;

  public List<Drone> getAllDrones() {
    return droneRepository.findAll();
  }
}

package com.accjava.finalproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.accjava.finalproject.exception.ResourceNotFoundException;
import com.accjava.finalproject.model.Drone;
import com.accjava.finalproject.model.Entrega;
import com.accjava.finalproject.repository.DroneRepository;
import com.accjava.finalproject.repository.EntregaRepository;

@Service
public class EntregaService {
  
  @Autowired
  private EntregaRepository entregaRepository;

  @Autowired
  private DroneRepository droneRepository;


  public List<Entrega> getAllEntregas() {
    return entregaRepository.findAll();
  }
  
  public Entrega createEntrega(Entrega entrega) {

    List<Drone> drones = droneRepository.findDroneByStatus("disponivel");

    if(drones.isEmpty()){
      throw new ResourceNotFoundException("No Drones available");
    }

    Drone drone = drones.get(0);

    entrega.setStatus("Em transito");
    entrega.setDrone(drone);

    drone.addEntrega(entrega);
    drone.setStatus("Ocupado");

    return entregaRepository.save(entrega);
  }


  public ResponseEntity<Entrega> getAllEntregaById(Long id) {
    Entrega entregaFound = entregaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrega doesn't exist with id: " + id));
    
    return ResponseEntity.ok(entregaFound);
  }
  
  public ResponseEntity<Entrega> updateEntrega(Long id, Entrega entrega) {
    Entrega entregaFound = entregaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrega doesn't exist with id: " + id));
    
    entregaFound.setLatitude(entrega.getLatitude());
    entregaFound.setLongitude(entrega.getLongitude());
    
    
    Entrega updatedEntrega = entregaRepository.save(entregaFound);

    return ResponseEntity.ok(updatedEntrega);
  }
  
  public ResponseEntity<Map<String, Boolean>> deleteEntrega(Long id) {
    Entrega entregaFound = entregaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrega doesn't exist with id: " + id));
    
    entregaRepository.delete(entregaFound);
    Map<String, Boolean> response = new HashMap<>();
    response.put("Deleted", Boolean.TRUE);
    
    return ResponseEntity.ok(response);
  }


  public ResponseEntity<Entrega> updateEntregaStatus(Long id) {
    Entrega entregaFound = entregaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrega doesn't exist with id: " + id));
  
    Long droneId = entregaFound.getDrone().getId();
    Drone droneFound = droneRepository.findById(droneId).orElseThrow(() -> new ResourceNotFoundException("Drone doesn't exist with id: " + droneId));
  
    droneFound.setStatus("Em transito");
    droneRepository.save(droneFound);
  
    entregaFound.setStatus("Entregue");
    Entrega updatedEntrega = entregaRepository.save(entregaFound);
  
  
    return ResponseEntity.ok(updatedEntrega);
  }
}
  


package com.accjava.finalproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accjava.finalproject.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long>{
  List<Drone> findDroneByStatus(String status);
}

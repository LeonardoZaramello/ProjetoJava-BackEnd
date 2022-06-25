package com.accjava.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accjava.finalproject.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long>{

}

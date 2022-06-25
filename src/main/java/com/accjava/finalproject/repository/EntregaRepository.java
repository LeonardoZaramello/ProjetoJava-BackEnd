package com.accjava.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accjava.finalproject.model.Entrega;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long>{
  
}

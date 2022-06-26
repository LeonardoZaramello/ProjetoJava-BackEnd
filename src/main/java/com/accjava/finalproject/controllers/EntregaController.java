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
import com.accjava.finalproject.model.Entrega;
import com.accjava.finalproject.service.EntregaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/entregas")
public class EntregaController {
  
  @Autowired
  private EntregaService entregaService;

  @GetMapping
  public List<Entrega> getAllEntregas() {
    return entregaService.getAllEntregas();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Entrega> getAllEntregaById(@PathVariable Long id) {
    return entregaService.getAllEntregaById(id);
  }

  @PostMapping
  public Entrega createEntrega(@RequestBody Entrega entrega) {
    return entregaService.createEntrega(entrega);
  }


  @PutMapping("/{id}")
  public ResponseEntity<Entrega> updateEntrega(@PathVariable Long id, @RequestBody Entrega entrega) {
    return entregaService.updateEntrega(id, entrega);
  }

  @PutMapping("/entrega-status/{id}")
  public ResponseEntity<Entrega> updateEntregaStatus(@PathVariable Long id) {
    return entregaService.updateEntregaStatus(id);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEntrega(@PathVariable Long id) {
    return entregaService.deleteEntrega(id);
  }

}

package com.accjava.finalproject;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.accjava.finalproject.model.Drone;
import com.accjava.finalproject.repository.DroneRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DroneControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private DroneRepository droneRepository;
  
  Drone droneMock = new Drone(null, "Marca", "Modelo");

  
  @DisplayName("1 - Deve checar a rota base com status ok.")
  @Test
  @Order(1)
  void endPointOk() throws Exception {
    mockMvc.perform(get("/drones").contentType("application/json").content("[]"))
    .andExpect(status().isOk());
    
  }

  
  @DisplayName("2 - Deve cadastrar um drone com sucesso.")
  @Test
  @Order(2)
  void cadastrarDroneOk() throws Exception {

    mockMvc.perform(post("/drones").contentType("application/json").content(new ObjectMapper().writeValueAsString(droneMock)))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.marca").value("Marca"))
      .andExpect(jsonPath("$.modelo").value("Modelo"));
  }

  @DisplayName("3 - Deve achar o drone.")
  @Test
  @Order(3)
  void testDroneFound() throws Exception {

    Drone droneSaved = this.droneRepository.save(droneMock);

    mockMvc.perform(get("/drones/" + droneSaved.getId()))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(droneSaved.getId()))
      .andExpect(jsonPath("$.marca").value(droneSaved.getMarca()))
      .andExpect(jsonPath("$.modelo").value(droneSaved.getModelo()));
  }

  @DisplayName("4 - Não deve achar o drone.")
  @Test
  @Order(4)
  void testDroneNotFound() throws Exception {
    mockMvc.perform(get("/drones/986576573")).andExpect(status().isNotFound());
  }

  @DisplayName("5 - Deve atualizar o drone.")
  @Test
  @Order(5)
  void testUpdateDrone() throws Exception {

    Drone droneSaved = this.droneRepository.save(droneMock);

    Drone droneForUpdate = new Drone(null, "Marca2", "Modelo2");

    mockMvc.perform(put("/drones/" + droneSaved.getId()).contentType("application/json").content(new ObjectMapper().writeValueAsString(droneForUpdate)))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.id").value(droneSaved.getId()))
    .andExpect(jsonPath("$.marca").value(droneForUpdate.getMarca()))
    .andExpect(jsonPath("$.modelo").value(droneForUpdate.getModelo()));
  }

  @DisplayName("6 - Deve deletar o drone.")
  @Test
  @Order(6)
  void testDeleteDrone() throws Exception {
    Drone droneSaved = this.droneRepository.save(droneMock);

    mockMvc.perform(delete("/drones/" + droneSaved.getId()))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.Deleted").value(true));
  }

  @DisplayName("7 - Não deve achar o drone para deletar.")
  @Test
  @Order(7)
  void testDroneToDeleteNotFound() throws Exception {
    mockMvc.perform(get("/drones/986576573")).andExpect(status().isNotFound());
  }
}

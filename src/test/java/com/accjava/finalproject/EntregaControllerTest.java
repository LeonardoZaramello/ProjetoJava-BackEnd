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
import com.accjava.finalproject.model.Entrega;
import com.accjava.finalproject.repository.EntregaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EntregaControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private EntregaRepository entregaRepository;

  Entrega entregaMock = new Entrega(null, "55.984", "98.231");
  

  @DisplayName("1 - Deve checar a rota base com status ok.")
  @Test
  @Order(1)
  void endPointOk() throws Exception {
    mockMvc.perform(get("/entregas").contentType("application/json").content("[]"))
    .andExpect(status().isOk());
    
  }

  
  @DisplayName("2 - Deve cadastrar uma entrega com sucesso.")
  @Test
  @Order(2)
  void cadastrarDroneOk() throws Exception {

    mockMvc.perform(post("/entregas").contentType("application/json").content(new ObjectMapper().writeValueAsString(entregaMock)))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.latitude").value("55.984"))
      .andExpect(jsonPath("$.longitude").value("98.231"));
  }

  @DisplayName("3 - Deve achar a entrega.")
  @Test
  @Order(3)
  void testDroneFound() throws Exception {

    Entrega entregaSaved = this.entregaRepository.save(entregaMock);

    mockMvc.perform(get("/entregas/" + entregaSaved.getId()))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id").value(entregaSaved.getId()))
      .andExpect(jsonPath("$.latitude").value(entregaSaved.getLatitude()))
      .andExpect(jsonPath("$.longitude").value(entregaSaved.getLongitude()));
  }

  @DisplayName("4 - Não deve achar a entrega.")
  @Test
  @Order(4)
  void testDroneNotFound() throws Exception {
    mockMvc.perform(get("/entregas/986576573")).andExpect(status().isNotFound());
  }

  @DisplayName("5 - Deve atualizar a entrega.")
  @Test
  @Order(5)
  void testUpdateDrone() throws Exception {

    Entrega entregaSaved = this.entregaRepository.save(entregaMock);

    Entrega entregaForUpdate = new Entrega(null, "22.543", "15.356");

    mockMvc.perform(put("/entregas/" + entregaSaved.getId()).contentType("application/json").content(new ObjectMapper().writeValueAsString(entregaForUpdate)))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.id").value(entregaSaved.getId()))
    .andExpect(jsonPath("$.latitude").value(entregaForUpdate.getLatitude()))
    .andExpect(jsonPath("$.longitude").value(entregaForUpdate.getLongitude()));
  }

  @DisplayName("6 - Deve deletar a entrega.")
  @Test
  @Order(6)
  void testDeleteDrone() throws Exception {
    Entrega entregaSaved = this.entregaRepository.save(entregaMock);

    mockMvc.perform(delete("/entregas/" + entregaSaved.getId()))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.Deleted").value(true));
  }

  @DisplayName("7 - Não deve achar a entrega para deletar.")
  @Test
  @Order(7)
  void testDroneToDeleteNotFound() throws Exception {
    mockMvc.perform(get("/entregas/986576573")).andExpect(status().isNotFound());
  }
}

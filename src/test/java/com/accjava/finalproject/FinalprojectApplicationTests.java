package com.accjava.finalproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class FinalprojectApplicationTests {

	@Autowired
  private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
    mockMvc
    .perform(get("/").contentType("text").content("Olá Mundo"))
    .andExpect(status().isOk());
	}

}

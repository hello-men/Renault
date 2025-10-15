package org.capgemini.renault.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.capgemini.renault.model.Garage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class GarageResourceTest {

    @Autowired
    private MockMvc mockMvc;
    private Garage garage;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void setupClass() {
        MockitoAnnotations.openMocks(this);
        initGarage();
    }

    private void initGarage() {
        garage = new Garage();
        garage.setName("garage1");
        garage.setAddress("Rabat");
        //return mapper.readValue(Files.readString(Paths.get(new ClassPathResource("json.request/garage_to_create.json").getURI())), Garage.class);
    }

    @Test
    void create_garage_test() throws Exception {
        mockMvc.perform(post("/garages")
                .contentType(MediaType.APPLICATION_JSON)
                .contentType(mapper.writeValueAsString(garage)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists());

        mockMvc.perform(post("/garages"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("garage1"));
    }

}

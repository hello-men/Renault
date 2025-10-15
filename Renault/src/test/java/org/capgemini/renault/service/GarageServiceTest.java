package org.capgemini.renault.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.capgemini.renault.model.Garage;
import org.capgemini.renault.repository.GarageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GarageServiceTest {

    @Mock
    private GarageRepository garageRepository;

    @InjectMocks
    private GarageService garageService;

    private static final ObjectMapper mapper = new ObjectMapper();

    private Garage garage;

    @BeforeEach
    void setupClass() {
        MockitoAnnotations.openMocks(this);
        initGarage();
    }

    private void initGarage() {
        garage = new Garage();
        garage.setId(1L);
        garage.setName("garage1");
        garage.setAddress("Rabat");
        //return mapper.readValue(Files.readString(Paths.get(new ClassPathResource("json.request/garage_to_create.json").getURI())), Garage.class);
    }
    @Test
    void create_Garage_OK() throws IOException {
        //when(garageRepository.save(any(Garage.class))).thenReturn(mapper.readValue(Files.readString(Paths.get(new ClassPathResource("json.request/garage_to_create.json").getURI())), Garage.class));
        when(garageRepository.save(any(Garage.class))).thenReturn(garage);
        Garage garageCreated = garageService.create(garage);
        Assertions.assertThat("garage1").isEqualTo(garageCreated.getName());
        Assertions.assertThat("Rabat").isEqualTo(garageCreated.getAddress());
        verify(garageRepository, times(1)).save(garage);
  }




}

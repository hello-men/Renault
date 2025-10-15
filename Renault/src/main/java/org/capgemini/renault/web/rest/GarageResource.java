package org.capgemini.renault.web.rest;

import org.capgemini.renault.model.FilterGarage;
import org.capgemini.renault.model.Garage;
import org.capgemini.renault.service.GarageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/garages")
public class GarageResource {

    private GarageService garageService;

    public GarageResource(GarageService garageService) {
        this.garageService = garageService;

    }

    @PostMapping
    Garage create(@RequestBody @Valid Garage garage) {
        return garageService.create(garage);
    }

    @PutMapping
    Garage update(@RequestBody Garage garage) {
        return garageService.update(garage);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable("id") Long id) {
        garageService.delete(id);
    }

    @GetMapping(path = "/{id}")
    List<Garage> getGarageById(@PathVariable("id") Long garageId) {
        return garageService.findGarageById(garageId);
    }

    @GetMapping
    Page<Garage> listAllGarages(@RequestParam int page, @RequestParam int size , @RequestParam String field ) {
        return garageService.listAllGarages(page, size, field);
    }





}

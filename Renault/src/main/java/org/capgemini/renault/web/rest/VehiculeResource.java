package org.capgemini.renault.web.rest;

import org.capgemini.renault.service.VehiculeService;
import org.capgemini.renault.model.Vehicule;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vehicules")
public class VehiculeResource {

    private VehiculeService vehiculeService;

    public VehiculeResource(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @PostMapping
    Vehicule create(@RequestParam Long garageId, @RequestBody @Valid Vehicule vehicule) {
        return vehiculeService.create(garageId, vehicule);
    }

    @PutMapping
    Vehicule update(@RequestBody Vehicule vehicule) {

        return vehiculeService.update(vehicule);
    }

    @DeleteMapping(path = "/{id}")
    void delete(@PathVariable("id") Long id) {
        vehiculeService.delete(id);
    }

    @GetMapping("/garage/{garageId}")
    List<Vehicule> getVehiculeByGarage(@PathVariable Long garageId) {
        return vehiculeService.getVehiculeByGarage(garageId);
    }

    @GetMapping("/brand/{brandName}")
    List<Vehicule> getVehiculeByBrand(@PathVariable String brandName) {
        return vehiculeService.getListVehiculesByBrand(brandName);
    }
}

package org.capgemini.renault.service;

import org.capgemini.renault.model.Garage;
import org.capgemini.renault.model.Vehicule;
import org.capgemini.renault.repository.GarageRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    private final GarageRepository garageRepository;


    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage create(Garage garage) {
        return garageRepository.save(garage);
    }


    public Garage update(Garage garage) {
        Garage garageToUpdate =  garageRepository.findById(garage.getId()).orElseThrow();

        garageToUpdate.setName(garage.getName());
        garageToUpdate.setAddress(garage.getAddress());
        garageToUpdate.setTelephone(garage.getTelephone());

        return garageRepository.save(garageToUpdate);
    }

    public void delete(Long id) {
        garageRepository.deleteById(id);
    }

    public List<Garage> findGarageById(Long garageId) {
         return garageRepository.findGarageById(garageId);
    }

    public Page<Garage> listAllGarages(int page, int size, String field) {
        Sort sort = Sort.by(field).ascending();
        PageRequest pageable = PageRequest.of(page, size, sort);
        return garageRepository.findAll(pageable);
    }
}

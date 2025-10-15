package org.capgemini.renault.service;

import org.capgemini.renault.event.VehiculeCreatedEvent;
import org.capgemini.renault.model.Garage;
import org.capgemini.renault.model.Vehicule;
import org.capgemini.renault.repository.GarageRepository;
import org.capgemini.renault.repository.VehiculeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final GarageRepository garageRepository;

    private final ApplicationEventPublisher applicationEventPublisher;

    public VehiculeService(VehiculeRepository vehiculeRepository, GarageRepository garageRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.vehiculeRepository = vehiculeRepository;
        this.garageRepository = garageRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public Vehicule create(Long garageId, Vehicule vehicule) {
        Garage garage = garageRepository.findById(garageId).orElseThrow();
        if(garage.getVehicules().size() >= 50) {
            throw new IllegalStateException("Garage have reached its maximum capacity : "+ 50);
        }
        vehicule.setGarage(garage);
        Vehicule vehiculeCreated = vehiculeRepository.save(vehicule);
        // Fire a event each time a vehicule is created
        applicationEventPublisher.publishEvent(new VehiculeCreatedEvent(vehiculeCreated.getId()));


        return vehiculeCreated;
    }

    public Vehicule update(Vehicule vehicule) {
        Vehicule vehicleToUpdate =  vehiculeRepository.findById(vehicule.getId()).orElseThrow();
        //Todo : update vehicule fields
        vehicleToUpdate.setTypeCarburant(vehicule.getTypeCarburant());
        vehicleToUpdate.setAnneeFabrication(vehicule.getAnneeFabrication());
        vehicleToUpdate.setBrand(vehicleToUpdate.getBrand());

        return vehiculeRepository.save(vehicleToUpdate);

    }

    public void delete(Long id) {
        vehiculeRepository.deleteById(id);
    }


    public List<Vehicule> getListVehiculesByBrand(String brand) {
        return vehiculeRepository.findByBrand(brand);
    }

    public List<Vehicule> getVehiculeByGarage(Long garageId) {
        return vehiculeRepository.findByGarageId(garageId);
    }
}

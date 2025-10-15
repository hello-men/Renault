package org.capgemini.renault.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class VehiculeEventListener {



    @EventListener
    public void handleVehiculeCreatedAndAct(VehiculeCreatedEvent event) {
        System.out.println("notifying Garage owner by email: "+ event.getVehiculeId());
    }
}

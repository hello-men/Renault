package org.capgemini.renault.event;

public class VehiculeCreatedEvent {

    private Long vehiculeId;


    public VehiculeCreatedEvent(Long vehiculeId) {
        this.vehiculeId = vehiculeId;
    }

    public Long getVehiculeId() {
        return vehiculeId;
    }
}

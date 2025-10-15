package org.capgemini.renault.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "garages")
public class Garage {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(nullable = false)
        @NotBlank
        private String name;
        @Column
        @NotBlank
        private String address;
        @Column
        @NotBlank
        private String telephone;
        //private Map<DayOfWeek, List<Long>> horairesOuverture;
        @JsonIgnore
        @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL)
        private List<Vehicule> vehicules;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public String getTelephone() {
                return telephone;
        }

        public void setTelephone(String telephone) {
                this.telephone = telephone;
        }
        /**
        public Map<DayOfWeek, List<Long>> getHorairesOuverture() {
                return horairesOuverture;
        }

        public void setHorairesOuverture(Map<DayOfWeek, List<Long>> horairesOuverture) {
                this.horairesOuverture = horairesOuverture;
        }
        **/
        public List<Vehicule> getVehicules() {
                return vehicules;
        }

        public void setVehicules(List<Vehicule> vehicules) {
                this.vehicules = vehicules;
        }
}

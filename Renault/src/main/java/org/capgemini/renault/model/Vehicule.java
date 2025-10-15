package org.capgemini.renault.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Vehicule {
        @Id
        @GeneratedValue
        private Long id;
        @Column
        @NotBlank
        private String brand;

        @Column
        @NotBlank
        private String typeCarburant;

        @Column
        @NotNull
        private Integer anneeFabrication;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "garage_id")
        private Garage garage;

        @JsonIgnore
        @OneToMany
        @JoinColumn(name = "vehicule_id")
        private List<Accessoire> accessoires;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getBrand() {
                return brand;
        }

        public void setBrand(String brand) {
                this.brand = brand;
        }

        public String getTypeCarburant() {
                return typeCarburant;
        }

        public void setTypeCarburant(String typeCarburant) {
                this.typeCarburant = typeCarburant;
        }

        public Integer getAnneeFabrication() {
                return anneeFabrication;
        }

        public void setAnneeFabrication(Integer anneeFabrication) {
                this.anneeFabrication = anneeFabrication;
        }

        public Garage getGarage() {
                return garage;
        }

        public void setGarage(Garage garage) {
                this.garage = garage;
        }

        public List<Accessoire> getAccessoires() {
                return accessoires;
        }

        public void setAccessoires(List<Accessoire> accessoires) {
                this.accessoires = accessoires;
        }
}

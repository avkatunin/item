package ru.andreykatunin.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.andreykatunin.model.HousingComplex;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@DiscriminatorValue("3")
public class HousingComplexPhoto extends Photo implements Serializable {
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private HousingComplex housingComplex;

    public HousingComplexPhoto() {

    }

    public HousingComplexPhoto(HousingComplex housingComplex, String name, String status, byte[] data) {
        super(name, status, data);
        this.housingComplex = housingComplex;
    }

    public HousingComplex getHousingComplex() {
        return housingComplex;
    }
}
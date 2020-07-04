package ru.andreykatunin.model.photo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.andreykatunin.model.Realty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@DiscriminatorValue("1")
public class RealtyPhoto extends Photo implements Serializable {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "id")
    private Realty realty;

    public RealtyPhoto() {
    }

    public Realty getRealty() {
        return realty;
    }
}

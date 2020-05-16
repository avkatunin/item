package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Модель данных жилого комплекса")
public class HousingComplex {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private int id;
    @ApiModelProperty(notes = "Название жилого комплекса")
    private String name;

    public HousingComplex() {
    }

    public HousingComplex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

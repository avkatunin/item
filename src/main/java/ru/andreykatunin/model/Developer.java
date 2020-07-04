package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel(description = "Модель данных застройщика")
public class Developer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private Long id;
    @ApiModelProperty(notes = "Название")
    private String name;
    @ApiModelProperty(notes = "Контакты застройщика (общедоступный)")
    private String commonContacts;
    @ApiModelProperty(notes = "Контакты застройщика для просмотра")
    private String viewContacts;
    @ApiModelProperty(notes = "Время просмотра")
    private String viewTime;
    @ApiModelProperty(notes = "Информация о застройщике")
    private String info;

    public Developer() {
    }

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

    public String getCommonContacts() {
        return commonContacts;
    }

    public void setCommonContacts(String commonContacts) {
        this.commonContacts = commonContacts;
    }

    public String getViewContacts() {
        return viewContacts;
    }

    public void setViewContacts(String viewContacts) {
        this.viewContacts = viewContacts;
    }

    public String getViewTime() {
        return viewTime;
    }

    public void setViewTime(String viewTime) {
        this.viewTime = viewTime;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

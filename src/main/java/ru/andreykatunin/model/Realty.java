package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@ApiModel(description = "Модель данных объекта недвижимости")
public class Realty {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private int id;
    @ApiModelProperty(notes = "Идентификатор записи здания")
    private int buildingId;
    @ApiModelProperty(notes = "Тип недвижимости")
    private String realtyType;
    @ApiModelProperty(notes = "Адрес")
    private String address;
    @ApiModelProperty(notes = "Площадь")
    private double area;
    @ApiModelProperty(notes = "Цена")
    private double price;
    @ApiModelProperty(notes = "Цена за квадратный метр")
    private double pricePerSquareMeter;
    @ApiModelProperty(notes = "Количество спален")
    private int amountBedrooms;
    @ApiModelProperty(notes = "Высота потолков")
    private float ceilingHeight;
    @ApiModelProperty(notes = "Этаж")
    private int floor;
    @ApiModelProperty(notes = "Сдан")
    private boolean rented;
    @ApiModelProperty(notes = "Срок сдачи")
    private LocalDate deadline;
    @ApiModelProperty(notes = "Вторичка")
    private boolean secondary;
    @ApiModelProperty(notes = "Информация об объекте")
    private String info;

    public Realty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getRealtyType() {
        return realtyType;
    }

    public void setRealtyType(String realtyType) {
        this.realtyType = realtyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public void setPricePerSquareMeter(double pricePerSquareMeter) {
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public int getAmountBedrooms() {
        return amountBedrooms;
    }

    public void setAmountBedrooms(int amountBedrooms) {
        this.amountBedrooms = amountBedrooms;
    }

    public float getCeilingHeight() {
        return ceilingHeight;
    }

    public void setCeilingHeight(float ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public boolean isSecondary() {
        return secondary;
    }

    public void setSecondary(boolean secondary) {
        this.secondary = secondary;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

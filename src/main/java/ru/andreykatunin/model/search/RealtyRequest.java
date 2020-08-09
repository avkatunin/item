package ru.andreykatunin.model.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.andreykatunin.model.RealtyType;

import java.time.LocalDate;

@ApiModel(description = "Модель данных поиска недвижимости ")
public class RealtyRequest {
    @ApiModelProperty(notes = "Цена от")
    private double priceFrom;
    @ApiModelProperty(notes = "Цена до")
    private double priceTo;
    @ApiModelProperty(notes = "Площадь от")
    private double areaFrom;
    @ApiModelProperty(notes = "Площадь до")
    private double areaTo;
    @ApiModelProperty(notes = "Этаж от")
    private int floorFrom;
    @ApiModelProperty(notes = "Этаж до")
    private int floorTo;
    @ApiModelProperty(notes = "Количество спален")
    private int amountBedrooms;
    @ApiModelProperty(notes = "Тип недвижимости")
    private RealtyType status;
    @ApiModelProperty(notes = "Отделка")
    private String decoration;
    @ApiModelProperty(notes = "Дата окончания стройки")
    private LocalDate deadline;
    @ApiModelProperty(notes = "Идентификатор района")
    private int districtId;
    @ApiModelProperty(notes = "Комплекс")
    private int housingComplexId;

    public RealtyRequest() {
    }

    public RealtyRequest(double priceFrom, double priceTo, double areaFrom, double areaTo, int floorFrom, int floorTo, int amountBedrooms, RealtyType status, String decoration, LocalDate deadline, int districtId, int housingComplexId) {
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.areaFrom = areaFrom;
        this.areaTo = areaTo;
        this.floorFrom = floorFrom;
        this.floorTo = floorTo;
        this.amountBedrooms = amountBedrooms;
        this.status = status;
        this.decoration = decoration;
        this.deadline = deadline;
        this.districtId = districtId;
        this.housingComplexId = housingComplexId;
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public double getAreaFrom() {
        return areaFrom;
    }

    public double getAreaTo() {
        return areaTo;
    }

    public int getFloorFrom() {
        return floorFrom;
    }

    public int getFloorTo() {
        return floorTo;
    }

    public int getAmountBedrooms() {
        return amountBedrooms;
    }

    public RealtyType getStatus() {
        return status;
    }

    public String getDecoration() {
        return decoration;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public int getDistrictId() {
        return districtId;
    }

    public int getHousingComplexId() {
        return housingComplexId;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public void setAreaFrom(double areaFrom) {
        this.areaFrom = areaFrom;
    }

    public void setAreaTo(double areaTo) {
        this.areaTo = areaTo;
    }

    public void setFloorFrom(int floorFrom) {
        this.floorFrom = floorFrom;
    }

    public void setFloorTo(int floorTo) {
        this.floorTo = floorTo;
    }

    public void setAmountBedrooms(int amountBedrooms) {
        this.amountBedrooms = amountBedrooms;
    }

    public void setStatus(RealtyType status) {
        this.status = status;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public void setHousingComplexId(int housingComplexId) {
        this.housingComplexId = housingComplexId;
    }
}

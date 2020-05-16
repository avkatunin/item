package ru.andreykatunin.model.search;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(description = "Модель данных поиска недвижимости ")
public class SearchRequest {
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
    private String amountBedrooms;
    @ApiModelProperty(notes = "Тип недвижимости")
    private String status;
    @ApiModelProperty(notes = "Отделка")
    private String decoration;
    @ApiModelProperty(notes = "Дата окончания стройки")
    private LocalDate deadline;
    @ApiModelProperty(notes = "Идентификатор района")
    private int districtId;
    @ApiModelProperty(notes = "Комплекс")
    private int housingComplexId;

    public SearchRequest() {
    }

    public SearchRequest(double priceFrom, double priceTo, double areaFrom, double areaTo, int floorFrom, int floorTo, String amountBedrooms, String status, String decoration, LocalDate deadline, int districtId, int housingComplexId) {
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

    public String getAmountBedrooms() {
        return amountBedrooms;
    }

    public String getStatus() {
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
}

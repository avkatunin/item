package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(description = "Модель данных поиска недвижимости ")
public class Search {
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
    private String realtyType;
    @ApiModelProperty(notes = "Акции")
    private String special;
    @ApiModelProperty(notes = "Дата окончания стройки")
    private LocalDate buildFinishDate;
    @ApiModelProperty(notes = "Район")
    private String districtName;
    @ApiModelProperty(notes = "Адрес")
    private String address;

    public Search() {
    }

    public double getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(double priceFrom) {
        this.priceFrom = priceFrom;
    }

    public double getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(double priceTo) {
        this.priceTo = priceTo;
    }

    public double getAreaFrom() {
        return areaFrom;
    }

    public void setAreaFrom(double areaFrom) {
        this.areaFrom = areaFrom;
    }

    public double getAreaTo() {
        return areaTo;
    }

    public void setAreaTo(double areaTo) {
        this.areaTo = areaTo;
    }

    public int getFloorFrom() {
        return floorFrom;
    }

    public void setFloorFrom(int floorFrom) {
        this.floorFrom = floorFrom;
    }

    public int getFloorTo() {
        return floorTo;
    }

    public void setFloorTo(int floorTo) {
        this.floorTo = floorTo;
    }

    public int getAmountBedrooms() {
        return amountBedrooms;
    }

    public void setAmountBedrooms(int amountBedrooms) {
        this.amountBedrooms = amountBedrooms;
    }

    public String getRealtyType() {
        return realtyType;
    }

    public void setRealtyType(String realtyType) {
        this.realtyType = realtyType;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public LocalDate getBuildFinishDate() {
        return buildFinishDate;
    }

    public void setBuildFinishDate(LocalDate buildFinishDate) {
        this.buildFinishDate = buildFinishDate;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", areaFrom=" + areaFrom +
                ", areaTo=" + areaTo +
                ", floorFrom=" + floorFrom +
                ", floorTo=" + floorTo +
                ", amountBedrooms=" + amountBedrooms +
                ", realtyType='" + realtyType + '\'' +
                ", special='" + special + '\'' +
                ", buildFinishDate=" + buildFinishDate +
                ", districtName='" + districtName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

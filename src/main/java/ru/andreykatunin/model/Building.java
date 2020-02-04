package ru.andreykatunin.model;

import java.time.LocalDate;

public class Building {
    private int id;
    private String address;
    private String district;
    private String metro;
    private String realtyInfo;
    private int floors;
    private LocalDate buildStartDate;
    private LocalDate buildFinishDate;
    private String elevator;
    private String facade;
    private String windows;
    private String parkingInfo;
    private double parkingPriceFrom;
    private double parkingPriceTo;
    private String presentationLink;
    private String priceLink;
    private String mortgage;
    private String installment;
    private String special;
    private double commercialArea;
    private String fee;

    public Building() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

    public String getRealtyInfo() {
        return realtyInfo;
    }

    public void setRealtyInfo(String realtyInfo) {
        this.realtyInfo = realtyInfo;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public LocalDate getBuildStartDate() {
        return buildStartDate;
    }

    public void setBuildStartDate(LocalDate buildStartDate) {
        this.buildStartDate = buildStartDate;
    }

    public LocalDate getBuildFinishDate() {
        return buildFinishDate;
    }

    public void setBuildFinishDate(LocalDate buildFinishDate) {
        this.buildFinishDate = buildFinishDate;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getFacade() {
        return facade;
    }

    public void setFacade(String facade) {
        this.facade = facade;
    }

    public String getWindows() {
        return windows;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public String getParkingInfo() {
        return parkingInfo;
    }

    public void setParkingInfo(String parkingInfo) {
        this.parkingInfo = parkingInfo;
    }

    public double getParkingPriceFrom() {
        return parkingPriceFrom;
    }

    public void setParkingPriceFrom(double parkingPriceFrom) {
        this.parkingPriceFrom = parkingPriceFrom;
    }

    public double getParkingPriceTo() {
        return parkingPriceTo;
    }

    public void setParkingPriceTo(double parkingPriceTo) {
        this.parkingPriceTo = parkingPriceTo;
    }

    public String getPresentationLink() {
        return presentationLink;
    }

    public void setPresentationLink(String presentationLink) {
        this.presentationLink = presentationLink;
    }

    public String getPriceLink() {
        return priceLink;
    }

    public void setPriceLink(String priceLink) {
        this.priceLink = priceLink;
    }

    public String getMortgage() {
        return mortgage;
    }

    public void setMortgage(String mortgage) {
        this.mortgage = mortgage;
    }

    public String getInstallment() {
        return installment;
    }

    public void setInstallment(String installment) {
        this.installment = installment;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public double getCommercialArea() {
        return commercialArea;
    }

    public void setCommercialArea(double commercialArea) {
        this.commercialArea = commercialArea;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}

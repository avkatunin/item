package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@ApiModel(description = "Модель данных поиска недвижимости")
public class Building {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private int id;
    @ApiModelProperty(notes = "Идентификатор района")
    private int districtId;
    @ApiModelProperty(notes = "Адрес объекта недвижимости")
    private String address;
    @ApiModelProperty(notes = "Станция метро")
    private String metro;
    @ApiModelProperty(notes = "Информация о недвижимости")
    private String realtyInfo;
    @ApiModelProperty(notes = "Этаж")
    private int floors;
    @ApiModelProperty(notes = "Начало строительства")
    private LocalDate buildStartDate;
    @ApiModelProperty(notes = "Окончание строительства")
    private LocalDate buildFinishDate;
    @ApiModelProperty(notes = "Лифты")
    private String elevator;
    @ApiModelProperty(notes = "Фасад")
    private String facade;
    @ApiModelProperty(notes = "Окна")
    private String windows;
    @ApiModelProperty(notes = "Информация о парковке")
    private String parkingInfo;
    @ApiModelProperty(notes = "Цена парковки от")
    private double parkingPriceFrom;
    @ApiModelProperty(notes = "Цена парковки до")
    private double parkingPriceTo;
    @ApiModelProperty(notes = "Ссылка на презентацию")
    private String presentationLink;
    @ApiModelProperty(notes = "Ссылка на прайс")
    private String priceLink;
    @ApiModelProperty(notes = "Ипотека")
    private String mortgage;
    @ApiModelProperty(notes = "Рассрочка")
    private String installment;
    @ApiModelProperty(notes = "Акции")
    private String special;
    @ApiModelProperty(notes = "Комерческая площадь")
    private double commercialArea;
    @ApiModelProperty(notes = "Вознаграждение")
    private String fee;
    @ApiModelProperty(notes = "Карточка ЖК/дома")
    private byte[] card;

    public Building() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public byte[] getCard() {
        return card;
    }

    public void setCard(byte[] card) {
        this.card = card;
    }
}

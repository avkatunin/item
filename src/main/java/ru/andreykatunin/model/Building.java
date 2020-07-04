package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@ApiModel(description = "Модель данных поиска недвижимости")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private Long id;
    @ApiModelProperty(notes = "Идентификатор района")
    private int districtId;
    @ApiModelProperty(notes = "Идентификатор застройщика")
    private int developerId;
    @ApiModelProperty(notes = "Идентификатор жилого комплекса")
    private String housingComplexId;

    @ManyToOne
    @JoinColumn(name = "housingComplexId", insertable=false, updatable=false)
    private HousingComplex housingComplex;

    @ApiModelProperty(notes = "Название объекта")
    private String name;
    @ApiModelProperty(notes = "Адрес объекта недвижимости")
    private String address;
    @ApiModelProperty(notes = "Станция метро")
    private String metro;
    @ApiModelProperty(notes = "Статус")
    private String status;
    @ApiModelProperty(notes = "Срок сдачи")
    private LocalDate deadline;
    @ApiModelProperty(notes = "Кол-во кв./аппарт.")
    private int numberOfApartments;
    @ApiModelProperty(notes = "S кв./аппарт.")
    private String areaRange;
    @ApiModelProperty(notes = "Этаж")
    private int floors;
    @ApiModelProperty(notes = "Стоимость")
    private double cost;
    @ApiModelProperty(notes = "Высота потолков")
    private double ceilingHeight;
    @ApiModelProperty(notes = "Кол-во машиномест")
    private int numberOfParkingSpaces;
    @ApiModelProperty(notes = "Стоимость машиноместа")
    private double parkingSpaceCost;
    @ApiModelProperty(notes = "Отделка")
    private String decoration;
    @ApiModelProperty(notes = "Документы продажи")
    private String salesDocuments;
    @ApiModelProperty(notes = "Коммунальные платежи")
    private String utilityBills;
    @ApiModelProperty(notes = "Архитектор Генподрядчик")
    private String generalContractor;
    @ApiModelProperty(notes = "Вознаграждение")
    private String award;

    public Building() {
    }

    public Building(Long id, int districtId, int developerId, String housingComplexId, String name, String address, String metro, String status, LocalDate deadline, int numberOfApartments, String areaRange, int floors, double cost, double ceilingHeight, int numberOfParkingSpaces, double parkingSpaceCost, String decoration, String salesDocuments, String utilityBills, String generalContractor, String award) {
        this.id = id;
        this.districtId = districtId;
        this.developerId = developerId;
        this.housingComplexId = housingComplexId;
        this.name = name;
        this.address = address;
        this.metro = metro;
        this.status = status;
        this.deadline = deadline;
        this.numberOfApartments = numberOfApartments;
        this.areaRange = areaRange;
        this.floors = floors;
        this.cost = cost;
        this.ceilingHeight = ceilingHeight;
        this.numberOfParkingSpaces = numberOfParkingSpaces;
        this.parkingSpaceCost = parkingSpaceCost;
        this.decoration = decoration;
        this.salesDocuments = salesDocuments;
        this.utilityBills = utilityBills;
        this.generalContractor = generalContractor;
        this.award = award;
    }

    public Long getId() {
        return id;
    }

    public int getDistrictId() {
        return districtId;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public String getHousingComplexId() {
        return housingComplexId;
    }

    public HousingComplex getHousingComplex() {
        return housingComplex;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMetro() {
        return metro;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public int getNumberOfApartments() {
        return numberOfApartments;
    }

    public String getAreaRange() {
        return areaRange;
    }

    public int getFloors() {
        return floors;
    }

    public double getCost() {
        return cost;
    }

    public double getCeilingHeight() {
        return ceilingHeight;
    }

    public int getNumberOfParkingSpaces() {
        return numberOfParkingSpaces;
    }

    public double getParkingSpaceCost() {
        return parkingSpaceCost;
    }

    public String getDecoration() {
        return decoration;
    }

    public String getSalesDocuments() {
        return salesDocuments;
    }

    public String getUtilityBills() {
        return utilityBills;
    }

    public String getGeneralContractor() {
        return generalContractor;
    }

    public String getAward() {
        return award;
    }
}

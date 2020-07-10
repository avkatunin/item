package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import ru.andreykatunin.model.photo.HousingComplexPhoto;
import ru.andreykatunin.model.photo.RealtyPhoto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "housing_complex")
@ApiModel(description = "Модель данных жилого комплекса")
public class HousingComplex implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private Long id;
    @ApiModelProperty(notes = "Название жилого комплекса")
    private String name;
    @ApiModelProperty(notes = "Дата старта продаж")
    @Column(name = "sale_start")
    private LocalDate saleStart;
    @ApiModelProperty(notes = "Краткая информация о ЖК")
    @Column(name = "short_description")
    private String shortDescription;
    @ApiModelProperty(notes = "Особенная информация о ЖК")
    @Column(name = "feature_description")
    private String featureDescription;
    @ApiModelProperty(notes = "Информация по продажам в ЖК")
    @Column(name = "sale_description")
    private String saleDescription;
    @ApiModelProperty(notes = "Информация о внешней инфраструктуры ЖК")
    @Column(name = "outside_infrastructure_description")
    private String outsideInfrastructureDescription;
    @ApiModelProperty(notes = "Основная информация о ЖК")
    @Column(name = "main_description")
    private String mainDescription;
    @ApiModelProperty(notes = "Информация о расположении ЖК")
    @Column(name = "location_description")
    private String locationDescription;
    @ApiModelProperty(notes = "Вид объекта")
    @Column(name = "realty_type")
    private String realtyType;
    @ApiModelProperty(notes = "Лоты")
    @Column(name = "lots")
    private String lots;
    @ApiModelProperty(notes = "Этажность")
    @Column(name = "floors")
    private String floors;
    @ApiModelProperty(notes = "Начало")
    @Column(name = "build_start")
    private LocalDate buildStart;
    @ApiModelProperty(notes = "Сдача")
    @Column(name = "build_end")
    private LocalDate buildEnd;
    @ApiModelProperty(notes = "Цена")
    @Column(name = "price_per_square_meter")
    private String pricePerSquareMeter;
    @ApiModelProperty(notes = "Площадь")
    @Column(name = "area")
    private String area;

    @ApiModelProperty(notes = "Район")
    @OneToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private District district;

    @ApiModelProperty(notes = "Адрес")
    @Column(name = "address")
    private String address;
    @ApiModelProperty(notes = "Метро")
    @Column(name = "metro")
    private String metro;

    @ApiModelProperty(notes = "Девелопер")
    @OneToOne
    @JoinColumn(name = "developer_id", referencedColumnName = "id")
    private Developer developer;

    @ApiModelProperty(notes = "Архитекторы")
    @Column(name = "architect")
    private String architect;
    @ApiModelProperty(notes = "Информация о материалах отделки")
    @Column(name = "decoration_materials_description")
    private String decorationMaterialsDescription;
    @ApiModelProperty(notes = "Лифты")
    @Column(name = "elevator")
    private String elevator;
    @ApiModelProperty(notes = "Фасад")
    @Column(name = "facade")
    private String facade;
    @ApiModelProperty(notes = "Окна")
    @Column(name = "windows")
    private String windows;

    @ApiModelProperty(notes = "Площадь 1-комнатной квартиры")
    @Column(name = "one_room_area")
    private String oneRoomArea;
    @ApiModelProperty(notes = "Цена 1-комнатной квартиры")
    @Column(name = "one_room_price")
    private String oneRoomPrice;
    @ApiModelProperty(notes = "Площадь 2-комнатной квартиры")
    @Column(name = "two_room_area")
    private String twoRoomArea;
    @ApiModelProperty(notes = "Цена 2-комнатной квартиры")
    @Column(name = "two_room_price")
    private String twoRoomPrice;
    @ApiModelProperty(notes = "Площадь 3-комнатной квартиры")
    @Column(name = "three_room_area")
    private String threeRoomArea;
    @ApiModelProperty(notes = "Цена 3-комнатной квартиры")
    @Column(name = "three_room_price")
    private String threeRoomPrice;
    @ApiModelProperty(notes = "Площадь 4-комнатной квартиры")
    @Column(name = "four_room_area")
    private String fourRoomArea;
    @ApiModelProperty(notes = "Цена 4-комнатной квартиры")
    @Column(name = "four_room_price")
    private String fourRoomPrice;
    @ApiModelProperty(notes = "Площадь 5-комнатной квартиры")
    @Column(name = "five_room_area")
    private String fiveRoomArea;
    @ApiModelProperty(notes = "Цена 5-комнатной квартиры")
    @Column(name = "five_room_price")
    private String fiveRoomPrice;
    @ApiModelProperty(notes = "Площадь пентхауса")
    @Column(name = "penthouse_area")
    private String penthouseArea;
    @ApiModelProperty(notes = "Цена пентхауса")
    @Column(name = "penthouse_price")
    private String penthousePrice;

    @ApiModelProperty(notes = "Налог")
    @Column(name = "tax")
    private String tax;
    @ApiModelProperty(notes = "Содержание")
    @Column(name = "support")
    private String support;
    @ApiModelProperty(notes = "Договор")
    @Column(name = "contract")
    private String contract;
    @ApiModelProperty(notes = "Потолки")
    @Column(name = "ceiling_height")
    private Float ceilingHeight;
    @ApiModelProperty(notes = "Паркинг")
    @Column(name = "parking")
    private String parking;
    @ApiModelProperty(notes = "Ипотека")
    @Column(name = "mortgage")
    private String mortgage;
    @ApiModelProperty(notes = "Рассрочка")
    @Column(name = "installment")
    private String installment;
    @ApiModelProperty(notes = "Акции")
    @Column(name = "special")
    private String special;
    @ApiModelProperty(notes = "Информация о внутренней инфраструктуры ЖК")
    @Column(name = "inside_infrastructure_description")
    private String insideInfrastructureDescription;
    @ApiModelProperty(notes = "Коммерческие площади и ритейл")
    @Column(name = "commercial_area")
    private String commercialArea;
    @ApiModelProperty(notes = "Будни")
    @Column(name = "weekday")
    private String weekday;
    @ApiModelProperty(notes = "Выходные")
    @Column(name = "weekend")
    private String weekend;

    @ApiModelProperty(notes = "Адрес")
    @Column(name = "sales_office_address")
    private String salesOfficeAddress;
    @ApiModelProperty(notes = "Парковка")
    @Column(name = "sales_office_parking")
    private String salesOfficeParking;
    @ApiModelProperty(notes = "Контакты")
    @Column(name = "sales_office_contacts")
    private String salesOfficeContacts;
    @ApiModelProperty(notes = "Информация для офиса продаж")
    @Column(name = "sales_office_information")
    private String salesOfficeInformation;

    @ApiModelProperty(notes = "Цена на старте")
    @Column(name = "start_price")
    private String startPrice;
    @ApiModelProperty(notes = "Вознаграждение")
    @Column(name = "award")
    private String award;

    @OneToMany(mappedBy = "housingComplex")
    private List<HousingComplexPhoto> photos;

    public HousingComplex() {
    }

    public HousingComplex(Long id) {
        this.id = id;
    }

    public HousingComplex(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getSaleStart() {
        return saleStart;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public String getSaleDescription() {
        return saleDescription;
    }

    public String getOutsideInfrastructureDescription() {
        return outsideInfrastructureDescription;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public String getRealtyType() {
        return realtyType;
    }

    public String getLots() {
        return lots;
    }

    public String getFloors() {
        return floors;
    }

    public LocalDate getBuildStart() {
        return buildStart;
    }

    public LocalDate getBuildEnd() {
        return buildEnd;
    }

    public String getPricePerSquareMeter() {
        return pricePerSquareMeter;
    }

    public String getArea() {
        return area;
    }

    public District getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public String getMetro() {
        return metro;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public String getArchitect() {
        return architect;
    }

    public String getDecorationMaterialsDescription() {
        return decorationMaterialsDescription;
    }

    public String getElevator() {
        return elevator;
    }

    public String getFacade() {
        return facade;
    }

    public String getWindows() {
        return windows;
    }

    public String getOneRoomArea() {
        return oneRoomArea;
    }

    public String getOneRoomPrice() {
        return oneRoomPrice;
    }

    public String getTwoRoomArea() {
        return twoRoomArea;
    }

    public String getTwoRoomPrice() {
        return twoRoomPrice;
    }

    public String getThreeRoomArea() {
        return threeRoomArea;
    }

    public String getThreeRoomPrice() {
        return threeRoomPrice;
    }

    public String getFourRoomArea() {
        return fourRoomArea;
    }

    public String getFourRoomPrice() {
        return fourRoomPrice;
    }

    public String getFiveRoomArea() {
        return fiveRoomArea;
    }

    public String getFiveRoomPrice() {
        return fiveRoomPrice;
    }

    public String getPenthouseArea() {
        return penthouseArea;
    }

    public String getPenthousePrice() {
        return penthousePrice;
    }

    public String getTax() {
        return tax;
    }

    public String getSupport() {
        return support;
    }

    public String getContract() {
        return contract;
    }

    public Float getCeilingHeight() {
        return ceilingHeight;
    }

    public String getParking() {
        return parking;
    }

    public String getMortgage() {
        return mortgage;
    }

    public String getInstallment() {
        return installment;
    }

    public String getSpecial() {
        return special;
    }

    public String getInsideInfrastructureDescription() {
        return insideInfrastructureDescription;
    }

    public String getCommercialArea() {
        return commercialArea;
    }

    public String getWeekday() {
        return weekday;
    }

    public String getWeekend() {
        return weekend;
    }

    public String getSalesOfficeAddress() {
        return salesOfficeAddress;
    }

    public String getSalesOfficeParking() {
        return salesOfficeParking;
    }

    public String getSalesOfficeContacts() {
        return salesOfficeContacts;
    }

    public String getSalesOfficeInformation() {
        return salesOfficeInformation;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public String getAward() {
        return award;
    }

    public List<HousingComplexPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(List<HousingComplexPhoto> photos) {
        this.photos = photos;
    }

    public void addPhoto(HousingComplexPhoto photo) {
        if (photos == null)
            photos = new ArrayList<>();
        photos.add(photo);
    }
}

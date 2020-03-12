package ru.andreykatunin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.andreykatunin.model.*;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/meta")
public class DefinitionRestController {

    public DefinitionRestController() {
    }

    @GetMapping(value = "/user")
    public User userDefinition() {
        User user = new User();
        user.setId(1);
        user.setRoleId(2);
        user.setCity("Москва");
        user.setCompany("ПТБ");
        user.setEmail("user@mail.ru");
        user.setPhoneNumber("+7 (999) 888-77-66");
        return user;
    }

    @GetMapping(value = "/building")
    public Building buildingDefinition() {
        Building building = new Building();
        building.setId(12);
        building.setAddress("Тверская улица, дом 13");
        building.setBuildFinishDate(LocalDate.MIN);
        building.setBuildFinishDate(LocalDate.MAX);
        building.setCommercialArea(2001.57);
        building.setDistrictId(1);
        building.setElevator("1 пассижрный, 1 грузовой");
        building.setFacade("Облицовка");
        building.setFee("50 процентов");
        building.setFloors(12);
        building.setInstallment("50 процентов");
        building.setMetro("Академическая");
        building.setSpecial("Акций нет");
        building.setWindows("Во двор");
        return building;
    }

    @GetMapping(value = "/district")
    public District districtDefinition() {
        District district = new District();
        district.setId(1);
        district.setName("Хамовники");
        district.setDescription("ОЧЕНЬ хороший раён");
        return district;
    }

    @GetMapping(value = "/developer")
    public Developer developerDefinition() {
        Developer developer = new Developer();
        developer.setId(1);
        developer.setName("ПИК");
        developer.setViewContacts("+7 (919) 134-61-35");
        developer.setCommonContacts("+7 (914) 714-14-16");
        developer.setInfo("Это лучший застройщик за последнюю тысячу лет");
        return developer;
    }

    @GetMapping(value = "/realty")
    public Realty realtyDefinition() {
        Realty realty = new Realty();
        realty.setId(104);
        realty.setAddress("Тверская улица, дом 13, кв.69");
        realty.setAmountBedrooms(2);
        realty.setArea(100.15);
        realty.setBuildingId(12);
        realty.setCeilingHeight(3.2f);
        realty.setDeadline(LocalDate.now());
        realty.setFloor(5);
        realty.setPrice(1245600.00);
        realty.setPricePerSquareMeter(12456);
        realty.setRealtyType("Квартира");
        realty.setRented(true);
        realty.setSecondary(true);
        realty.setInfo("Лучшая хата ин да лайф");
        return realty;
    }
}

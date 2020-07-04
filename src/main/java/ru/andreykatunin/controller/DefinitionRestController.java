package ru.andreykatunin.controller;

import org.springframework.web.bind.annotation.*;
import ru.andreykatunin.model.*;
import ru.andreykatunin.model.mail.MailData;
import ru.andreykatunin.services.mail.EmailServiceImpl;

import java.time.LocalDate;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/meta")
public class DefinitionRestController {

    public DefinitionRestController(
            EmailServiceImpl service
    ) {
        this.service = service;
    }

    public final EmailServiceImpl service;

    @PostMapping(value = "/check-mail")
    public String checkMail(@RequestBody MailData mailData) {
        service.sendSimpleMessage(mailData.getTo(), mailData.getSubject(), mailData.getText());
        return "ok";
    }

    @GetMapping(value = "/user")
    public Users userDefinition() {
        Users user = new Users();
        user.setId(1L);
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
        return building;
    }

    @GetMapping(value = "/district")
    public District districtDefinition() {
        District district = new District();
        district.setId(1L);
        district.setName("Хамовники");
        district.setDescription("ОЧЕНЬ хороший раён");
        return district;
    }

    @GetMapping(value = "/developer")
    public Developer developerDefinition() {
        Developer developer = new Developer();
        developer.setId(1L);
        developer.setName("ПИК");
        developer.setViewContacts("+7 (919) 134-61-35");
        developer.setCommonContacts("+7 (914) 714-14-16");
        developer.setInfo("Это лучший застройщик за последнюю тысячу лет");
        return developer;
    }

    @GetMapping(value = "/realty")
    public Realty realtyDefinition() {
        Realty realty = new Realty();
        realty.setId(104L);
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

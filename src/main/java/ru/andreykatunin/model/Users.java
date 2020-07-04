package ru.andreykatunin.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel(description = "Модель данных объекта пользователь")
public class Users {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Идентификатор записи БД")
    private Long id;
    @ApiModelProperty(notes = "Идентификатор записи роли")
    private int roleId;
    @ApiModelProperty(notes = "ФИО")
    private String fullName;
    @ApiModelProperty(notes = "Название организации")
    private String company;
    @ApiModelProperty(notes = "Номер телефона")
    private String phoneNumber;
    @ApiModelProperty(notes = "Почтовый адрес")
    private String email;
    @ApiModelProperty(notes = "Город")
    private String city;
    @ApiModelProperty(notes = "Пароль")
    private String password;
    @ApiModelProperty(notes = "Код регистрации")
    @Transient
    private String secretCode;

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretCode() {
        return secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }
}

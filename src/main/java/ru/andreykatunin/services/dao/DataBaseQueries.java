package ru.andreykatunin.services.dao;

public interface DataBaseQueries {
    String ADD_NEW_REALTY = "";
    String ADD_NEW_BUILDING = "";
    String SELECT_ALL_RECORDS_REALTY = "SELECT * FROM REALTY";
    String SELECT_ALL_RECORDS_USER = "SELECT * FROM USERS";
    String SELECT_ALL_RECORDS_BUILDING = "SELECT * FROM BUILDING";
    String SELECT_ALL_RECORDS_DEVELOPER = "SELECT * FROM DEVELOPER";
    String SELECT_ALL_RECORDS_DISTRICT = "SELECT * FROM DISTRICT";

    String SELECT_REALTY_BY_ID = "SELECT * FROM REALTY WHERE ID = ?";
    String SELECT_USER_BY_ID = "SELECT * FROM USERS WHERE ID = ?";
    String SELECT_USER_BY_EMAIL = "SELECT * FROM USERS WHERE EMAIL = ?";
    String SELECT_BUILDING_BY_ID = "SELECT * FROM BUILDING WHERE ID = ?";
    String SELECT_DEVELOPER_BY_ID = "SELECT * FROM DEVELOPER WHERE ID = ?";
    String SELECT_DISTRICT_BY_ID = "SELECT * FROM DISTRICT WHERE ID = ?";

    String INSERT_BUILDING_RECORD = "insert into building(districtid, address, metro, realtyinfo, floors, buildstartdate, buildfinishdate, elevator, facade, windows, parkinginfo, parkingpricefrom, parkingpriceto, presentationlink, pricelink, mortgage, installment, special, commercialarea, fee) \n" +
            "VALUES (:districtId, :address, :metro, :realtyInfo, :floors, :buildStartDate, :buildFinishDate, :elevator, :facade, :windows, :parkingInfo, :parkingPriceFrom, :parkingPriceTo, :presentationLink, :priceLink, :mortgage, :installment, :special, :commercialArea, :fee)";

    String INSERT_REALTY_RECORD = "insert into realty(buildingid, realtytype, address, area, price, pricepersquaremeter, amountbedrooms, ceilingheight, floor, rented, deadline, secondary, info) " +
            "VALUES (:buildingId, :realtyType, :address, :area, :price, :pricePerSquareMeter, :amountBedrooms, :ceilingHeight, :floor, :rented, :deadline, :secondary, :info)";

    String INSERT_USER_RECORD = "insert into users(roleid, company, phonenumber, email, city, fullName, password) " +
            "VALUES (:roleId, :company, :phoneNumber, :email, :city, :fullName, :password)";

    String INSERT_DEVELOPER_RECORD = "insert into developer(name, commoncontacts, viewcontacts, viewtime, info) " +
            "VALUES (:name, :commonContacts, :viewContacts, :viewTime, :info)";

    String INSERT_DISTRICT_RECORD = "insert into district(name, description) " +
            "VALUES (:name, :description)";

    String DELETE_REALTY_BY_ID = "DELETE FROM REALTY WHERE ID = ?";
    String DELETE_USER_BY_ID = "DELETE FROM USERS WHERE ID = ?";
    String DELETE_BUILDING_BY_ID = "DELETE FROM BUILDING WHERE ID = ?";
    String DELETE_DEVELOPER_BY_ID = "DELETE FROM DEVELOPER WHERE ID = ?";
    String DELETE_DISTRICT_BY_ID = "DELETE FROM DISTRICT WHERE ID = ?";

    String UPDATE_USER_ROLE = "update users set roleid = ? where id = ?";

    String SELECT_REALTY_FROM_SEARCH = "SELECT * FROM DISTRICT LEFT JOIN BUILDING on DISTRICT.id = BUILDING.districtid LEFT JOIN REALTY on BUILDING.id = REALTY.buildingid WHERE realty.id is not null";
}

package ru.andreykatunin.services.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.*;
import ru.andreykatunin.model.search.RealtyRequest;

import java.util.List;

@Service
public class SearchDao {
    private final static Logger logger = LogManager.getLogger(SearchDao.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SearchDao(
            NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Realty> getRealtyBySearchFromDB(RealtyRequest realtyRequest) {
        logger.info("Start search query");
        StringBuilder stringBuilder = new StringBuilder(DataBaseQueries.SELECT_REALTY_FROM_SEARCH);
        if (realtyRequest.getPriceFrom() != 0)
            stringBuilder.append(" AND ").append("price >= ").append(realtyRequest.getPriceFrom());
        if (realtyRequest.getPriceTo() != 0)
            stringBuilder.append(" AND ").append("price <= ").append(realtyRequest.getPriceTo());
        if (realtyRequest.getAreaFrom() != 0)
            stringBuilder.append(" AND ").append("area >= ").append(realtyRequest.getAreaFrom());
        if (realtyRequest.getAreaTo() != 0)
            stringBuilder.append(" AND ").append("area <= ").append(realtyRequest.getAreaTo());
        if (realtyRequest.getFloorFrom() != 0)
            stringBuilder.append(" AND ").append("floor >= ").append(realtyRequest.getFloorFrom());
        if (realtyRequest.getFloorTo() != 0)
            stringBuilder.append(" AND ").append("floor <= ").append(realtyRequest.getFloorTo());
        if (realtyRequest.getAmountBedrooms() > 0)
            stringBuilder.append(" AND ").append("amountBedrooms = ").append(realtyRequest.getAmountBedrooms());
        if (realtyRequest.getStatus() != null)
            stringBuilder.append(" AND ").append("status = ").append("'").append(realtyRequest.getStatus()).append("'");
        if (realtyRequest.getDecoration() != null)
            stringBuilder.append(" AND ").append("decoration = ").append("'").append(realtyRequest.getDecoration()).append("'");
        if (realtyRequest.getDistrictId() != 0)
            stringBuilder.append(" AND ").append("districtId = ").append(realtyRequest.getDistrictId());
        if (realtyRequest.getHousingComplexId() != 0)
            stringBuilder.append(" AND ").append("housingComplexId = ").append(realtyRequest.getDistrictId());

        System.out.println(stringBuilder.toString());
        logger.info("Query {}", stringBuilder.toString());
        return namedParameterJdbcTemplate.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(Realty.class));
    }
}

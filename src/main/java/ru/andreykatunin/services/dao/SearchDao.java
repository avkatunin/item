package ru.andreykatunin.services.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.*;
import ru.andreykatunin.model.search.SearchRequest;
import ru.andreykatunin.repository.UserRepository;

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

    public List<Realty> getRealtyBySearchFromDB(SearchRequest searchRequest) {
        logger.info("Start search query");
        StringBuilder stringBuilder = new StringBuilder(DataBaseQueries.SELECT_REALTY_FROM_SEARCH);
        if (searchRequest.getPriceFrom() != 0)
            stringBuilder.append(" AND ").append("price >= ").append(searchRequest.getPriceFrom());
        if (searchRequest.getPriceTo() != 0)
            stringBuilder.append(" AND ").append("price <= ").append(searchRequest.getPriceTo());
        if (searchRequest.getAreaFrom() != 0)
            stringBuilder.append(" AND ").append("area >= ").append(searchRequest.getAreaFrom());
        if (searchRequest.getAreaTo() != 0)
            stringBuilder.append(" AND ").append("area <= ").append(searchRequest.getAreaTo());
        if (searchRequest.getFloorFrom() != 0)
            stringBuilder.append(" AND ").append("floor >= ").append(searchRequest.getFloorFrom());
        if (searchRequest.getFloorTo() != 0)
            stringBuilder.append(" AND ").append("floor <= ").append(searchRequest.getFloorTo());
        if (searchRequest.getAmountBedrooms() != null)
            stringBuilder.append(" AND ").append("amountBedrooms = ").append(searchRequest.getAmountBedrooms());
        if (searchRequest.getStatus() != null)
            stringBuilder.append(" AND ").append("status = ").append("'").append(searchRequest.getStatus()).append("'");
        if (searchRequest.getDecoration() != null)
            stringBuilder.append(" AND ").append("decoration = ").append("'").append(searchRequest.getDecoration()).append("'");
        if (searchRequest.getDistrictId() != 0)
            stringBuilder.append(" AND ").append("districtId = ").append(searchRequest.getDistrictId());
        if (searchRequest.getHousingComplexId() != 0)
            stringBuilder.append(" AND ").append("housingComplexId = ").append(searchRequest.getDistrictId());

        System.out.println(stringBuilder.toString());
        logger.info("Query {}", stringBuilder.toString());
        return namedParameterJdbcTemplate.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(Realty.class));
    }
}

package ru.andreykatunin.services.dao;

import com.impossibl.postgres.jdbc.PGSQLIntegrityConstraintViolationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.*;

import java.util.List;

@Service
public class EntityDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static Logger logger = LogManager.getLogger(EntityDao.class);

    public EntityDao(
            JdbcTemplate jdbcTemplate,
            NamedParameterJdbcTemplate namedParameterJdbcTemplate
    ) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<Realty> getAllRealtyFromDB() {
        return jdbcTemplate.query(DataBaseQueries.SELECT_ALL_RECORDS_REALTY, new BeanPropertyRowMapper<>(Realty.class));
    }

    public List<User> getAllUserFromDB() {
        return jdbcTemplate.query(DataBaseQueries.SELECT_ALL_RECORDS_USER, new BeanPropertyRowMapper<>(User.class));
    }

    public List<Building> getAllBuildingFromDB() {
        return jdbcTemplate.query(DataBaseQueries.SELECT_ALL_RECORDS_BUILDING, new BeanPropertyRowMapper<>(Building.class));
    }

    public List<Developer> getAllDeveloperFromDB() {
        return jdbcTemplate.query(DataBaseQueries.SELECT_ALL_RECORDS_DEVELOPER, new BeanPropertyRowMapper<>(Developer.class));
    }

    public List<District> getAllDistrictFromDB() {
        return jdbcTemplate.query(DataBaseQueries.SELECT_ALL_RECORDS_DISTRICT, new BeanPropertyRowMapper<>(District.class));
    }


    public Realty getRealtyById(Long id) {
        return jdbcTemplate.query(DataBaseQueries.SELECT_REALTY_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Realty.class)).get(0);
    }

    public User getUserById(Long id) {
        return jdbcTemplate.query(DataBaseQueries.SELECT_USER_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(User.class)).get(0);
    }

    public User getUserByEmail(String email) {
        try {
            return jdbcTemplate.queryForObject(DataBaseQueries.SELECT_USER_BY_EMAIL, new Object[]{email}, new BeanPropertyRowMapper<>(User.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Building getBuildingById(Long id) {
        return jdbcTemplate.query(DataBaseQueries.SELECT_BUILDING_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Building.class)).get(0);
    }

    public Developer getDeveloperById(Long id) {
        return jdbcTemplate.query(DataBaseQueries.SELECT_DEVELOPER_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(Developer.class)).get(0);
    }

    public District getDistrictById(Long id) {
        return jdbcTemplate.query(DataBaseQueries.SELECT_DISTRICT_BY_ID, new Object[]{id}, new BeanPropertyRowMapper<>(District.class)).get(0);
    }

    /*Add Block*/
    public int addBuildingRecordToDB(Building building) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource districtParameters = new BeanPropertySqlParameterSource(building);
        try {
            namedParameterJdbcTemplate.update(DataBaseQueries.INSERT_BUILDING_RECORD,
                    districtParameters, keyHolder);
            return (int) keyHolder.getKeyList().get(0).get("id");
        } catch (Exception e) {
            if (e instanceof PGSQLIntegrityConstraintViolationException)
                System.out.println("PGSQLIntegrityConstraintViolationException districtId not fount " + building.getDistrictId());
            return 0;
        }
    }

    public int addDeveloperRecordToDB(Developer developer) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource districtParameters = new BeanPropertySqlParameterSource(developer);
        namedParameterJdbcTemplate.update(DataBaseQueries.INSERT_DEVELOPER_RECORD,
                districtParameters, keyHolder);
        return (int) keyHolder.getKeyList().get(0).get("id");
    }

    public int addRealtyRecordToDB(Realty realty) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameters = new BeanPropertySqlParameterSource(realty);
        try {
            namedParameterJdbcTemplate.update(DataBaseQueries.INSERT_REALTY_RECORD,
                    parameters, keyHolder);
            return (int) keyHolder.getKeyList().get(0).get("id");
        } catch (Exception e) {
            if (e instanceof PGSQLIntegrityConstraintViolationException)
                System.out.println("PGSQLIntegrityConstraintViolationException buildingId not fount " + realty.getBuildingId());
            return 0;
        }
    }

    public int addDistrictRecordToDB(District district) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource districtParameters = new BeanPropertySqlParameterSource(district);
        namedParameterJdbcTemplate.update(DataBaseQueries.INSERT_DISTRICT_RECORD,
                districtParameters, keyHolder);
        return (int) keyHolder.getKeyList().get(0).get("id");
    }

    public int addUserRecordToDB(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource districtParameters = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(DataBaseQueries.INSERT_USER_RECORD,
                districtParameters, keyHolder);
        return (int) keyHolder.getKeyList().get(0).get("id");
    }

    public void updateUserRoleId(Long roleId, Long userId) {
        jdbcTemplate.update(DataBaseQueries.UPDATE_USER_ROLE, roleId, userId);
    }

    public void deleteDeveloperById(Long id) {
        jdbcTemplate.update(DataBaseQueries.DELETE_DEVELOPER_BY_ID, id);
    }

    public void deleteBuildingById(Long id) {
        jdbcTemplate.update(DataBaseQueries.DELETE_BUILDING_BY_ID, id);
    }

    public void deleteRealtyById(Long id) {
        jdbcTemplate.update(DataBaseQueries.DELETE_REALTY_BY_ID, id);
    }

    public void deleteUserById(Long id) {
        jdbcTemplate.update(DataBaseQueries.DELETE_USER_BY_ID, id);
    }

    public void deleteDistrictById(Long id) {
        jdbcTemplate.update(DataBaseQueries.DELETE_DISTRICT_BY_ID, id);
    }

    public List<Realty> getRealtyBySearchFromDB(Search search) {
        logger.info("Start search query");
        StringBuilder stringBuilder = new StringBuilder(DataBaseQueries.SELECT_REALTY_FROM_SEARCH);
        if (search.getPriceFrom() != 0)
            stringBuilder.append(" AND ").append("price >= ").append(search.getPriceFrom());
        if (search.getPriceTo() != 0)
            stringBuilder.append(" AND ").append("price <= ").append(search.getPriceTo());
        if (search.getAreaFrom() != 0)
            stringBuilder.append(" AND ").append("area >= ").append(search.getAreaFrom());
        if (search.getAreaTo() != 0)
            stringBuilder.append(" AND ").append("area <= ").append(search.getAreaTo());
        if (search.getFloorFrom() != 0)
            stringBuilder.append(" AND ").append("floor >= ").append(search.getFloorFrom());
        if (search.getFloorTo() != 0)
            stringBuilder.append(" AND ").append("floor <= ").append(search.getFloorTo());
        if (search.getAmountBedrooms() != 0)
            stringBuilder.append(" AND ").append("amountBedrooms = ").append(search.getAmountBedrooms());
        if (search.getRealtyType() != null)
            stringBuilder.append(" AND ").append("realtyType = ").append("'").append(search.getRealtyType()).append("'");
        System.out.println(stringBuilder.toString());
        logger.info("Query {}", stringBuilder.toString());
        return jdbcTemplate.query(stringBuilder.toString(), new BeanPropertyRowMapper<>(Realty.class));
    }
}

package ru.andreykatunin.services.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Flat;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class FlatDao {

    private final JdbcTemplate jdbcTemplate;


    public FlatDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Flat> getFlatsFromDB(Flat flat) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ITEM WHERE ");
        if (flat.getAttr1() != null)
            stringBuilder.append("attr1 = ").append(flat.getAttr1()).append(" AND ");
        if (flat.getAttr2() != null)
            stringBuilder.append("attr2 = ").append(flat.getAttr2()).append(" AND ");
        if (flat.getAttr3() != null)
            stringBuilder.append("attr3 = ").append(flat.getAttr3()).append(" AND ");
        if (flat.getAttr4() != null)
            stringBuilder.append("attr4 = ").append(flat.getAttr4()).append(" AND ");
        if (flat.getAttr5() != null)
            stringBuilder.append("attr5 = '").append(flat.getAttr5()).append("' AND ");
        if (flat.getAttr6() != null)
            stringBuilder.append("attr6 = '").append(flat.getAttr6()).append("' AND ");
        if (flat.getAttr7() != null)
            stringBuilder.append("attr7 = '").append(flat.getAttr7()).append("' AND ");
        if (flat.getAttr7() != null)
            stringBuilder.append("attr8 = '").append(flat.getAttr8()).append("' AND ");
        if (flat.getAttr8() != null)
            stringBuilder.append("attr9 = '").append(flat.getAttr9()).append("' AND ");
        if (flat.getAttr9() != null)
            stringBuilder.append("attr10 = '").append(flat.getAttr10()).append("' AND ");

        String query = stringBuilder.toString();
        if (query.contains("AND"))
            query = query.substring(0, query.lastIndexOf(" AND "));
        else
            query = query.substring(0, query.lastIndexOf(" WHERE "));
        return jdbcTemplate.query(query, new ItemRowMapper());
    }

    class ItemRowMapper implements RowMapper<Flat> {
        public Flat mapRow(ResultSet rs, int rowNum) throws SQLException {
            Flat flat = new Flat();
            flat.setAttr1(rs.getInt("attr1"));
            flat.setAttr2(rs.getInt("attr2"));
            flat.setAttr3(rs.getInt("attr3"));
            flat.setAttr4(rs.getInt("attr4"));
            flat.setAttr5(rs.getString("attr5"));
            flat.setAttr6(rs.getString("attr6"));
            flat.setAttr7(rs.getString("attr7"));
            flat.setAttr8(rs.getString("attr8"));
            flat.setAttr9(rs.getString("attr9"));
            flat.setAttr10(rs.getString("attr10"));
            return flat;
        }
    }
}

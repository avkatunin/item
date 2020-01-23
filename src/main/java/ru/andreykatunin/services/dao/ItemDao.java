package ru.andreykatunin.services.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import ru.andreykatunin.model.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ItemDao {

    private final JdbcTemplate jdbcTemplate;


    public ItemDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> getItemListFromDB(Item item) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ITEM WHERE ");
        if (item.getAttr1() != null)
            stringBuilder.append("attr1 = ").append(item.getAttr1()).append(" AND ");
        if (item.getAttr2() != null)
            stringBuilder.append("attr2 = ").append(item.getAttr2()).append(" AND ");
        if (item.getAttr3() != null)
            stringBuilder.append("attr3 = ").append(item.getAttr3()).append(" AND ");
        if (item.getAttr4() != null)
            stringBuilder.append("attr4 = ").append(item.getAttr4()).append(" AND ");
        if (item.getAttr5() != null)
            stringBuilder.append("attr5 = '").append(item.getAttr5()).append("' AND ");
        if (item.getAttr6() != null)
            stringBuilder.append("attr6 = '").append(item.getAttr6()).append("' AND ");
        if (item.getAttr7() != null)
            stringBuilder.append("attr7 = '").append(item.getAttr7()).append("' AND ");
        if (item.getAttr7() != null)
            stringBuilder.append("attr8 = '").append(item.getAttr8()).append("' AND ");
        if (item.getAttr8() != null)
            stringBuilder.append("attr9 = '").append(item.getAttr9()).append("' AND ");
        if (item.getAttr9() != null)
            stringBuilder.append("attr10 = '").append(item.getAttr10()).append("' AND ");

        String query = stringBuilder.toString();
        if (query.contains("AND"))
            query = query.substring(0, query.lastIndexOf(" AND "));
        else
            query = query.substring(0, query.lastIndexOf(" WHERE "));
        return jdbcTemplate.query(query, new ItemRowMapper());
    }

    class ItemRowMapper implements RowMapper<Item> {
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setAttr1(rs.getInt("attr1"));
            item.setAttr2(rs.getInt("attr2"));
            item.setAttr3(rs.getInt("attr3"));
            item.setAttr4(rs.getInt("attr4"));
            item.setAttr5(rs.getString("attr5"));
            item.setAttr6(rs.getString("attr6"));
            item.setAttr7(rs.getString("attr7"));
            item.setAttr8(rs.getString("attr8"));
            item.setAttr9(rs.getString("attr9"));
            item.setAttr10(rs.getString("attr10"));
            return item;
        }
    }
}

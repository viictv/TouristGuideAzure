package apiassignment.touristguideapi.rowmappers;

import apiassignment.touristguideapi.model.SeasonModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SeasonRowMapper implements RowMapper<SeasonModel> {

    @Override
    public SeasonModel mapRow (ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("SEASON_ID");
        String name = rs.getString("SEASON_NAME");
        return new SeasonModel(id, name);
    }



}

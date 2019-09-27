package com.eiv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class JdbcTemplate {

    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource) {
        super();
        this.dataSource = dataSource;
    }
    
    public JdbcTemplate withDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        return this;
    }
    
    public <T> List<T> query(String sql, RowMapper<T> rowMapper) {
        int rowNum = 0;
        ArrayList<T> result = new ArrayList<T>();
        
        try (Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                T t = rowMapper.mapRow(rs, rowNum);
                result.add(t);            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return result;
    }
}



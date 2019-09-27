package com.eiv;


import java.util.List;
import javax.sql.DataSource;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class App {
    
    
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
    
    
    public void run() {
        
        JdbcTemplate template = new JdbcTemplate(getDataSource());
  
        List<CajaEntity> cajaEntities = template.query("SELECT * FROM cajas", (rs, row) -> {
            long numero = rs.getLong("numero");
            String estacion = rs.getString("estacion");
            String obs = rs.getString("obs");
            CajaEntity caja = new CajaEntity(numero, estacion, obs);
            return caja;
        });
        cajaEntities.forEach(cajaEntity -> {
            System.out.println("Caja: " + cajaEntity);
        });
    }
    
    
    public DataSource getDataSource() {
        
        HikariConfig cfg = new HikariConfig();
        cfg.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDataSource");
        cfg.setJdbcUrl("jdbc:sqlserver://sqlserver\\SQL2008;databaseName=DESARROLLO_MUTUAL");
        cfg.setUsername("sa");
        cfg.setPassword("rv760"); 
        
        HikariDataSource ds = new HikariDataSource(cfg);
        
        return ds;
    }

}


package ru.andreykatunin.config.database;

import com.impossibl.postgres.jdbc.PGDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfig {

    @Value(value = "${database.host}")
    String host;
    @Value(value = "${database.port}")
    int port;
    @Value(value = "${database.name}")
    String name;
    @Value(value = "${database.user}")
    String user;
    @Value(value = "${database.password}")
    String password;

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new PGDataSource();
        ((PGDataSource) dataSource).setHost(host);
        ((PGDataSource) dataSource).setPort(port);
        ((PGDataSource) dataSource).setDatabaseName(name);
        ((PGDataSource) dataSource).setUser(user);
        ((PGDataSource) dataSource).setPassword(password);
        return dataSource;
    }

}

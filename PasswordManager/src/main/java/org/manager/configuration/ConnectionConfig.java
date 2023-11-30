package org.manager.configuration;

import org.manager.models.PasswordInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan
@PropertySource("classpath:connection.properties")
public class ConnectionConfig {
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String name;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver.name}")
    private String driver;

    @Bean
    public DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, name, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}

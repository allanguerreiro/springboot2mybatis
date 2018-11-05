package br.com.springboot.mybatis.springboot2mybatis.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"br.com.springboot.mybatis.springboot2mybatis.*"})
public class DataSourceConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    //Base de dados ---------------------------------------------------------------------------------------
    @Primary
    @Bean(destroyMethod = "")
    public DataSource dataSourceH2() throws DataSourceException {

        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName("org.h2.Driver");
        hikariConfig.setJdbcUrl("jdbc:h2:mem:testdb");
        hikariConfig.setUsername("sa");
        hikariConfig.setPassword("");
        hikariConfig.setPoolName("H2");

        HikariDataSource dataSourceH2 = new HikariDataSource(hikariConfig);

        return dataSourceH2;
    }

    @Bean(name = "jdbcTemplateH2")
    public JdbcTemplate jdbcTemplateH2(@Qualifier("dataSourceH2") DataSource dataSourceH2) {
        return new JdbcTemplate(dataSourceH2);
    }
}

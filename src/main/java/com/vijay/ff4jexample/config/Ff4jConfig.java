package com.vijay.ff4jexample.config;


import org.ff4j.FF4j;
import org.ff4j.audit.repository.InMemoryEventRepository;
import org.ff4j.property.store.InMemoryPropertyStore;
import org.ff4j.springjdbc.store.EventRepositorySpringJdbc;
import org.ff4j.springjdbc.store.FeatureStoreSpringJdbc;
import org.ff4j.springjdbc.store.PropertyStoreSpringJdbc;
import org.ff4j.store.InMemoryFeatureStore;
import org.ff4j.web.FF4jDispatcherServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class Ff4jConfig {


//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public FF4j getFF4j() {
//        FF4j ff4j = new FF4j();
//        ff4j.setFeatureStore(new FeatureStoreSpringJdbc(dataSource));
//        ff4j.setPropertiesStore(new PropertyStoreSpringJdbc(dataSource));
//        ff4j.setEventRepository(new EventRepositorySpringJdbc(dataSource));
//        ff4j.createFeature("featureA");
//        return ff4j;
//    }


    @Bean
    public FF4j getFF4j() {
        FF4j ff4j = new FF4j();
        ff4j.createFeature("featureA");
        return ff4j;
    }


    @Bean
    public ServletRegistrationBean ff4jDispatcherServlet() {
        FF4jDispatcherServlet ff4jDispatcherServlet = new FF4jDispatcherServlet();
        ff4jDispatcherServlet.setFf4j(getFF4j());
        return new ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*");
    }

}

package org.armandosalazar.beans;

import org.armandosalazar.model.Connection;
import org.armandosalazar.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BuildConnection {

    @Bean
    public User getUser() {
        return new User();
    }

    @Bean(name = "beanConnection")
    public Connection getConnection() {
        Connection connection = new Connection();
        connection.setUrl("jdbc:mysql://localhost:3306/blog");
        connection.setUsername("root");
        connection.setPassword("root");
        return connection;
    }

    @Bean
    public String getHello() {
        return "Hello World";
    }
}

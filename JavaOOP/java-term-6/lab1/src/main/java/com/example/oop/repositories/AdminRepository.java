package com.example.oop.repositories;

import com.example.oop.entities.AdminEntity;
import com.example.oop.exceptions.HttpException;
import com.example.oop.Properties;

import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class AdminRepository {
    public AdminRepository() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            statement.execute("""
                    create table if not exists admin
                    (
                        id       int8 generated by default as identity,
                        username varchar(255),
                        primary key (id)
                    );
                    """);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AdminEntity findByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM admin WHERE username = '%s';"
                    .formatted(username));
            if (!resultSet.next()) {
                throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
            }
            return AdminEntity.builder()
                    .id(resultSet.getLong("id"))
                    .username(resultSet.getString("username"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
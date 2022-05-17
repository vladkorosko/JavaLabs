package com.example.oop.repositories;

import com.example.oop.entities.ClientEntity;
import com.example.oop.Properties;
import com.example.oop.exceptions.HttpException;

import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    public ClientRepository() {
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
                    create table if not exists client
                    (
                        id       int8 generated by default as identity,
                        username varchar(255),
                        amount   int8,
                        disable  boolean not null default false,
                        primary key (id)
                    );
                    """);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClientEntity> finAll() {
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client;");
            ArrayList<ClientEntity> result = new ArrayList<>();
            while (resultSet.next()) {
                result.add(ClientEntity.builder()
                        .id(resultSet.getLong("id"))
                        .username(resultSet.getString("username"))
                        .amount(resultSet.getLong("amount"))
                        .disable(resultSet.getBoolean("disable"))
                        .build());
            }
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ClientEntity findByUsername(String username) {
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE username = '%s';"
                    .formatted(username));
            if (!resultSet.next()) {
                throw new HttpException(HttpServletResponse.SC_NOT_FOUND);
            }
            return ClientEntity.builder()
                    .id(resultSet.getLong("id"))
                    .username(resultSet.getString("username"))
                    .amount(resultSet.getLong("amount"))
                    .disable(resultSet.getBoolean("disable"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAmount(Long id, Long nuwAmount) {
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            statement.execute(
                    "UPDATE client SET amount = %s WHERE id = %s;"
                            .formatted(nuwAmount, id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void disable(Long id) {
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            statement.execute(
                    "UPDATE client SET disable = true WHERE id = %s;"
                            .formatted(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void enable(Long id) {
        try (Connection connection = DriverManager.getConnection(
                Properties.getInstance().getDatabaseUrl(),
                Properties.getInstance().getDatabaseUsername(),
                Properties.getInstance().getDatabasePassword());
             Statement statement = connection.createStatement()) {
            statement.execute(
                    "UPDATE client SET disable = false WHERE id = %s;"
                            .formatted(id));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
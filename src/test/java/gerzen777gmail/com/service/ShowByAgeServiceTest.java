package gerzen777gmail.com.service;

import gerzen777gmail.com.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ShowByAgeServiceTest {
    @Test
    public void showUsersByAgeTest() {
        Connection connection = prepareConnection();
        Collection<User> users = new ArrayList<>();
        ShowByAgeService showByAgeService = new ShowByAgeService();

        Assertions.assertEquals(2, showByAgeService.showUsersByAge(30, 40, connection, users).size());

    }

    private Connection prepareConnection() {
        Connection connection = null;
        try {
            DataBaseConnection dataBaseConnection = new DataBaseConnection();
            DataSource dataSource = dataBaseConnection.createDataSource();
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return connection;
    }

}
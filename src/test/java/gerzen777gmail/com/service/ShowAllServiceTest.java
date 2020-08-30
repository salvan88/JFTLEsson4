package gerzen777gmail.com.service;

import gerzen777gmail.com.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class ShowAllServiceTest {

    @Test
    public void showAllTest() {
        Connection connection = prepareConnection();
        Collection<User> users = new ArrayList<>();
        ShowAllService showAllService = new ShowAllService();

        System.out.println(showAllService.showAll(connection, users));

        Assertions.assertEquals("Ivan", showAllService.showAll(connection, users).iterator().next().getName());

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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
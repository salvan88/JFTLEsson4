package gerzen777gmail.com.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class AddUserServiceTest {

    @Test
    public void addUserTest() {
        Connection connection = prepareConnection();
        AddUserService addUserService = new AddUserService();

        Assertions.assertEquals(1, addUserService.addUser(connection, "Bob", 32, "bob32@gmail.com"));
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
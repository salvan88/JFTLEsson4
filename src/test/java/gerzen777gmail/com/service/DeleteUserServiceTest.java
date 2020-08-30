package gerzen777gmail.com.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DeleteUserServiceTest {

    @Test
    public void deleteUserTest() throws SQLException {
        Connection connection = prepareConnection();
        DeleteUserService deleteUserService = new DeleteUserService();

        Assertions.assertEquals(1, deleteUserService.deleteUser("Bob", connection));
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
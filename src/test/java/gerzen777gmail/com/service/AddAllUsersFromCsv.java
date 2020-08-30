package gerzen777gmail.com.service;

import gerzen777gmail.com.deserializer.CsvUserDeserializer;
import gerzen777gmail.com.model.User;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class AddAllUsersFromCsv {

    @Test
    public void addAllFromFile() {

        Statement statement = null;
        Connection connection = null;

        try {
            Collection<User> users = prepareTestData();
            connection = prepareConnection();

            statement = connection.createStatement();

            PreparedStatement prepInsert = connection.prepareStatement(
                    "INSERT INTO userinfo.userinfotable (id, name, age, email) VALUES (?, ?, ?, ?)");

            for (User user : users) {
                prepInsert.setInt(1, user.getId());
                prepInsert.setString(2, user.getName());
                prepInsert.setInt(3, user.getAge());
                prepInsert.setString(4, user.getEmail());
                prepInsert.addBatch();
            }
            prepInsert.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Test
    public void deserialize() {
        CsvUserDeserializer csvUserDeserializer = new CsvUserDeserializer();
        System.out.println(csvUserDeserializer.deserializer(new File("userinfo.csv")));

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

    private Collection<User> prepareTestData() {

        CsvUserDeserializer csvUserDeserializer = new CsvUserDeserializer();

        return csvUserDeserializer.deserializer(new File("userinfo.csv"));
    }
}

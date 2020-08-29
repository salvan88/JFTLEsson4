package gerzen777gmail.com.service;

import gerzen777gmail.com.deserializer.CsvUserDeserializer;
import gerzen777gmail.com.model.User;
import gerzen777gmail.com.model.UserCollection;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class DataBaseFunctionsTest {

//    @org.junit.jupiter.api.Test
//    void showAll() {
//
//            Connection connection = null;
//            Statement statement = null;
//
//            try {
//                DataBaseConnection dataBaseConnection = new DataBaseConnection();
//                DataSource dataSource = dataBaseConnection.createDataSource();
//                connection = dataSource.getConnection();
//                statement = connection.createStatement();
//                statement.execute("INSERT INTO userinfotable VALUE (1, 'Ivan', 56, 'Ivan@gmail.com')");
//
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } finally {
//                try {
//                    if (statement != null) {
//                        statement.close();
//                    }
//                    if (connection != null) {
//                        connection.close();
//                    }
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//    }

    @Test
    public void deserialize() {
        CsvUserDeserializer csvUserDeserializer = new CsvUserDeserializer();
        System.out.println(csvUserDeserializer.deserializer("userinfo.csv"));

    }
//
//    private UserCollection prepareTestData() {
//        CsvUserDeserializer csvUserDeserializer = new CsvUserDeserializer();
//        UserCollection userCollection = new UserCollection();
//        try {
//            userCollection = csvUserDeserializer.deserializer(new File("userinfo.csv"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return userCollection;
//    }
//
}
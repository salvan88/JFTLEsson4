package gerzen777gmail.com.service;

import gerzen777gmail.com.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class ShowByAgeService {
    public Collection<User> showUsersByAge(int min, int max, Connection connection, Collection<User> users) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM userinfo.userinfotable WHERE age BETWEEN " + min + " AND " + max);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                User user = new User();

                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setAge(Integer.parseInt(resultSet.getString("age")));
                user.setEmail(resultSet.getString("email"));

                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return users;
    }
}

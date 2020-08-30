package gerzen777gmail.com.service;

import gerzen777gmail.com.model.User;

import java.sql.*;
import java.util.Collection;

public class ShowAllService {
    public Collection<User> showAll(Connection connection, Collection<User> users) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT * FROM userinfo.userinfotable");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                User user = new User();

                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setAge(Integer.parseInt(resultSet.getString("age")));
                user.setEmail(resultSet.getString("email"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
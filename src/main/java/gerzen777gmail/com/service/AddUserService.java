package gerzen777gmail.com.service;

import java.sql.*;

public class AddUserService {
    public int addUser(Connection connection, String name, int age, String email) {

        int[] insertedRows = new int[0];

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = statement.executeQuery("SELECT * FROM userinfo.userinfotable");

            rs.last();
            int id = rs.getRow();

            PreparedStatement ps = connection.prepareStatement("INSERT INTO userinfo.userinfotable (id, name, age, email) VALUES (?, ?, ?, ?)");

            ps.setInt(1, ++id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, email);
            ps.addBatch();
            insertedRows = ps.executeBatch();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return insertedRows.length;
    }
}

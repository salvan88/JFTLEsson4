package gerzen777gmail.com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteUserService {
    public int deleteUser(String name, Connection connection) throws SQLException {

        PreparedStatement ps = connection.prepareStatement("DELETE FROM userinfo.userinfotable WHERE name = ?");
        ps.setString(1, name);

        return ps.executeUpdate();
    }
}

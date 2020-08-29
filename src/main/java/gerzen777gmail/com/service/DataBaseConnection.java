package gerzen777gmail.com.service;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;


public class DataBaseConnection {

    public DataSource createDataSource() throws SQLException {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("3773");
        dataSource.setUrl("jdbc:mysql://localhost:3306/userinfo");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }
}
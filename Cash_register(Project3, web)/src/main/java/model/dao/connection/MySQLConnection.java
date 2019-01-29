package model.dao.connection;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class MySQLConnection {
    private static volatile DataSource dataSource;
    private static DataSource getDataSource(){
        if(dataSource == null) {
            synchronized (MySQLConnection.class) {
                if(dataSource == null) {
                    MysqlDataSource basicDataSource = new MysqlDataSource();
                    ResourceBundle resource = ResourceBundle.getBundle("mysqlconnection");
                    //basicDataSource.(resource.getString("driver"));
                    basicDataSource.setUrl(resource.getString("url"));
                    basicDataSource.setUser(resource.getString("user"));
                    basicDataSource.setPassword(resource.getString("password"));
                    //basicDataSource.setMaxIdle(Integer.valueOf(resource.getString("max")));
                    //basicDataSource.setMinIdle(Integer.valueOf(resource.getString("min")));
                    //basicDataSource.setMaxOpenPreparedStatements(Integer.valueOf(resource.getString("statements")));
                    dataSource = basicDataSource;
                }
            }
        }
        return dataSource;
    }

    public Connection getConnection(){
        try{
            Connection cn = getDataSource().getConnection();
            return cn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

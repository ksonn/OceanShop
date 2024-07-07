/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBContext {
    protected Connection connection = null;

    protected Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        return DriverManager.getConnection(url, userID, password);
    }


    private final String serverName = "LocalHost";
    private final String dbName = "DBSap";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456";

    
    public PreparedStatement ps(String sql) throws Exception {
        connection = getConnection();
        return connection.prepareStatement(sql);
    }

    public ResultSet rs(String sql) throws Exception {
        return ps(sql).executeQuery();
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception ex) {

            System.out.println(ex);
        }
        


    }

    public static void main(String[] args) {
        try {
            DBContext dBContext = new DBContext();
            if (dBContext.getConnection() != null) {
                System.out.println("ket noi thanh cong");
            } else {
                System.out.println("ket noi that bai");
            }
        } catch (Exception ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

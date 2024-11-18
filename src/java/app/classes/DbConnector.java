/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.classes;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PINKI
 */
public class DbConnector {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/task_tracker";
    private static final String DBUSER = "task";
    private static final String DBPW = "task";
    
     public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = (Connection) DriverManager.getConnection(URL, DBUSER, DBPW);
            return con;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DbConnector.class.getName()).log(Level.SEVERE, null, ex);
            throw ex; // Rethrow the exception to handle it in the JSP
        }
        return null;
    }
    
    }



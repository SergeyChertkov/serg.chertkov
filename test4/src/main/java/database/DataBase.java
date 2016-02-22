package database;

import java.sql.*;
import org.h2.tools.*;

/**
 * Created by Sergii_Chertkov on 2/17/2016.
 */
public class DataBase {
    private static final String DB_PATH = "d:/Projects/test4/database";
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:" + DB_PATH + "/test";
    private static final String DB_USER = "";
    private static final String DB_PASSWORD = "";
    private static Connection connection;

    public DataBase (){
        DataBase.connection = getDBConnection();
    }

    public void close() {
        try {
            DataBase.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean execute (String query) {
        boolean result = false;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            stmt.executeUpdate();
            result = true;
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public ResultSet select (String query) {
        ResultSet result = null;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(query);
            result = stmt.executeQuery();
        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }
/*
    public static void main(String[] args) throws Exception {
        try {
            // delete the H2 database named 'test' in the user home directory
            DeleteDbFiles.execute("DB_PATH", "test", true);
            insertWithStatement();
            DeleteDbFiles.execute("DB_PATH", "test", true);
            insertWithPreparedStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}

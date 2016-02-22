package database;

import org.junit.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergii_Chertkov on 2/17/2016.
 */
public class TestDataBase {
    @Test
    public void test_connect () throws SQLException{
        DataBase db = new DataBase();
        ResultSet rs = db.select("select 1");
        db.close();
    }
}

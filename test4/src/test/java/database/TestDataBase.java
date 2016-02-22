package database;

import org.junit.*;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergii_Chertkov on 2/17/2016.
 */
public class TestDataBase {
    @Ignore
    @Test
    public void test_connect () throws SQLException{
        DataBase db = new DataBase();
        db.execute("DROP TABLE PERSON");
        db.execute("CREATE TABLE PERSON(id int primary key, name varchar(255), surname varchar(255))");
        db.execute("INSERT INTO PERSON(id, name, surname) VALUES(1, 'Serg', 'Qwerty')");
        db.execute("INSERT INTO PERSON(id, name, surname) VALUES(2, 'Den', 'Asdfg')");
        db.execute("INSERT INTO PERSON(id, name, surname) VALUES(3, 'Ivan', 'Zxcvbn')");
        ResultSet rs = db.select("select * from PERSON");
        while (rs.next()) {
            System.out.println("Id "+rs.getInt("id")+" Name "+rs.getString("name")+" Surame "+rs.getString("surname"));
        }
        db.close();
    }
}

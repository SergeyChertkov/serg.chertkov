package database;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * Created by Sergii_Chertkov on 2/19/2016.
 */
public class TestDBResult {
    @Test
    public void test_connect () throws SQLException {
        DataBase db = new DataBase();
        db.execute("DROP TABLE PERSON");
        db.execute("CREATE TABLE PERSON(id int primary key, name varchar(255), surname varchar(255))");
        db.execute("INSERT INTO PERSON(id, name, surname) VALUES(1, 'Serg', 'Qwerty')");
        db.execute("INSERT INTO PERSON(id, name, surname) VALUES(2, 'Den', 'Asdfg')");
        db.execute("INSERT INTO PERSON(id, name, surname) VALUES(3, 'Ivan', 'Zxcvbn')");
        ResultSet rs = db.select("select * from PERSON");

        DBResult result = new DBResult(rs);
        //ResultSetMetaData rsmd = rs.getMetaData();
        //System.out.println(rsmd.getColumnCount());
        //for (int i=1; i<=rsmd.getColumnCount(); i++)
        //    System.out.println(rsmd.getColumnLabel(i));

        for (int i=0; i<result.row_count(); i++){
            for (int j=0; j<result.col_count(); j++){
                System.out.println(result.get(j,i) + "\t");
            }
            System.out.println("\n");
        }


        //while (rs.next()) {
        //    System.out.println("Id "+rs.getString("id")+" Name "+rs.getString("name")+" Surame "+rs.getString("surname"));
        //}
        db.close();
    }
}

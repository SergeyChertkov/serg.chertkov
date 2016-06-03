package database;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergii_Chertkov on 2/19/2016.
 */
public class TestDBResult {
    @Test
    public void test_connect () throws SQLException {
        DataBase db = new DataBase();
        db.execute("DROP TABLE members");
        db.execute("CREATE TABLE members(" +
                "id int unsigned NOT NULL auto_increment, " +
                "first_name varchar(45), " +
                "last_name varchar(45), " +
                "email varchar(45), " +
                "uname varchar(45), " +
                "pass varchar(45), " +
                "regdate DATE," +
                "primary key (id)" +
                ")");
        db.execute("DROP TABLE PERSON");
        db.execute("CREATE TABLE PERSON(" +
                "id int primary key, " +
                "name varchar(255), " +
                "surname varchar(255), " +
                "mail varchar(255), " +
                "born DATE)");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(1, 'Serg', 'Qwerty', 'Qwerty@test.com', '1977-01-01')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(2, 'Den', 'Asdfg', 'Asdfg@test.com', '1988-02-02')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(3, 'Ivan', 'Zxcvbn', 'Zxcvbn@test.com', '1999-03-03')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(4, 'Petr', 'Dfghjk', 'Dfghjk@test.com', '1999-04-04')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(5, 'Danil', 'Rtyuio', 'Rtyuio@test.com', '1999-05-05')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(6, 'John', 'Hgfds', 'Hgfds@test.com', '1999-06-06')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(7, 'Marc', 'Iuytre', 'Iuytre@test.com', '1999-07-07')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(8, 'Max', 'Plkjhgf', 'Plkjhgf@test.com', '1999-08-08')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(9, 'Truvor', 'Mnbvcxz', 'Mnbvcxz@test.com', '1999-09-09')");
        db.execute("INSERT INTO PERSON(id, name, surname, mail, born) VALUES(10, 'Horiv', 'Ehgfd', 'Ehgfd@test.com', '1999-10-10')");
        ResultSet rs = db.select("SELECT * FROM PERSON");

        DBResult result = new DBResult(rs);
        /*
        System.out.print("\n| ");
        for (int j=0; j<result.col_count(); j++) {
            System.out.print(result.getColumnName(j) + " | ");
        }

        for (int i=0; i<result.row_count(); i++){
            System.out.print("\n| ");
            for (int j=0; j<result.col_count(); j++) {
                System.out.print(result.get(i, j) + " | ");
            }
        }
        System.out.print("\n\n");
        */
        assertEquals(result.get(0,0), "1");
        assertEquals(result.get(1,1), "Den");
        assertEquals(result.get(2,2), "Zxcvbn");
        assertEquals(result.get(0,3), "Qwerty@test.com");
        assertEquals(result.get(1,4), "1988-02-02");
        db.close();
    }
}

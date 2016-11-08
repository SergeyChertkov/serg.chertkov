package database;

/**
 * Created by Sergii_Chertkov on 11/7/2016.
 */
public class CreateDB {
    public static void main (String args[]){
        DataBase.setPrint(true);
        DataBase.connect();
        DataBase.execute("DROP TABLE MEMBERS");
        DataBase.execute("CREATE TABLE MEMBERS (" +
                "  id int(10) unsigned NOT NULL auto_increment," +
                "  first_name varchar(45) NOT NULL," +
                "  last_name varchar(45) NOT NULL," +
                "  email varchar(45) NOT NULL," +
                "  uname varchar(45) NOT NULL," +
                "  pass varchar(45) NOT NULL," +
                "  regdate date NOT NULL," +
                "  PRIMARY KEY  (id)" +
                ")");
        DataBase.execute("INSERT INTO MEMBERS (id, first_name, last_name, email, uname, pass, regdate) " +
                "VALUES (1,'Test','User','test@mail.com','test','test', NOW())");
        DBResult res = new DBResult(
                DataBase.select("select * from members where uname='" + "test" + "' and pass='" + "test" + "'"));
        System.out.println(res);
        DataBase.close();
    }
}

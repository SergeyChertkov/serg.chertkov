package database;

/**
 * Created by Sergii_Chertkov on 11/7/2016.
 */
public class CreateDB {
    public static void main (String args[]){
        DataBase.setPrint(true);
        createMembersTable();
        createSettingsTable();
    }

    private static void createSettingsTable(){
        String [] settingsList = {"time_field", "gps", "gprs", "some_data", "name", "other_setting"};
        String query;

        DataBase.connect();
        DataBase.execute("DROP TABLE SETTINGS");

        query = "CREATE TABLE SETTINGS (" +
                "  id int(10) unsigned NOT NULL auto_increment," +
                "  user_id int(10) NOT NULL,";
        for (int i=0; i<settingsList.length; i++){
            query += "  " + settingsList[i] + " boolean DEFAULT TRUE,";
        }
        query += "  editdate date NOT NULL," +
                "  PRIMARY KEY  (id)" +
                ")";

        DataBase.execute(query);

        DataBase.execute("INSERT INTO SETTINGS (user_id, editdate) " +
                "VALUES (1, NOW())");
        DBResult res = new DBResult(
                DataBase.select("select * from SETTINGS where id=1"));
        System.out.println(res);
        DataBase.close();
    }

    private static void createMembersTable(){
        DataBase.connect();
        DataBase.execute("DROP TABLE MEMBERS");
        DataBase.execute("CREATE TABLE MEMBERS (" +
                "  id int(10) unsigned NOT NULL auto_increment," +
                "  first_name varchar(45) NOT NULL," +
                "  last_name varchar(45) NOT NULL," +
                "  email varchar(45) NOT NULL," +
                "  uname varchar(45) NOT NULL," +
                "  pass varchar(45) NOT NULL," +
                "  admin int(2) DEFAULT 0," + // 0 - not confirmed; 1 - confirmed; 2 - admin;
                "  regdate date NOT NULL," +
                "  PRIMARY KEY  (id)" +
                ")");
        DataBase.execute("INSERT INTO MEMBERS (first_name, last_name, email, uname, pass, admin, regdate) " +
                "VALUES ('Mega','Admin','admin@mail.com','admin','admin', 2, NOW())");
        DataBase.execute("INSERT INTO MEMBERS (first_name, last_name, email, uname, pass, regdate) " +
                "VALUES ('Test','User','test@mail.com','test','test', NOW())");
        DBResult res = new DBResult(
                DataBase.select("select * from members where uname='" + "test" + "' and pass='" + "test" + "'"));
        System.out.println(res);
        DataBase.close();
    }
}

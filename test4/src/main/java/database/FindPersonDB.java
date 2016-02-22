package database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii_Chertkov on 2/22/2016.
 */
public class FindPersonDB {
    private String name;
    private String surname;
    private String date;
    private String mail;
    private String query = "SELECT * FROM PERSON";
    private boolean where = false;


    public FindPersonDB name (String NAME){
        if(NAME == null || NAME.equals(""))
            return this;
        this.name = NAME;
        if (where)
            query += " AND ";
        else{
            query += " WHERE ";
            where = true;
        }
        query += "NAME LIKE '%'||'"+name+"'||'%'";
        return this;
    }

    public FindPersonDB surname (String SURNAME){
        if(SURNAME == null || SURNAME.equals(""))
            return this;
        this.surname = SURNAME;
        if (where)
            query += " AND ";
        else{
            query += " WHERE ";
            where = true;
        }
        query += "SURNAME LIKE '%'||'"+surname+"'||'%'";
        return this;
    }

    public FindPersonDB mail (String MAIL){
        if(MAIL == null || MAIL.equals(""))
            return this;
        this.mail = MAIL;
        if (where)
            query += " AND ";
        else{
            query += " WHERE ";
            where = true;
        }
        query += "MAIL LIKE '%'||'"+mail+"'||'%'";
        return this;
    }

    public FindPersonDB date (String DATE){
        if(DATE == null || DATE.equals(""))
            return this;
        this.date = DATE;
        if (where)
            query += " AND ";
        else{
            query += " WHERE ";
            where = true;
        }
        query += "DATE='"+date+"'";
        return this;
    }

    public List<Person> getResult (){
        DataBase db = new DataBase();

        List<Person> per = new ArrayList<Person>();
        System.out.println("query: "+query);
        DBResult dbres = new DBResult(db.select(query));
        for (int i=0; i<dbres.row_count(); i++){
            Person tmp = new Person();
            tmp.setId(dbres.get(i,0));
            tmp.setName(dbres.get(i,1));
            tmp.setSurname(dbres.get(i,2));
            tmp.setMail(dbres.get(i,3));
            tmp.setBorn(dbres.get(i,4));
            per.add(tmp);
        }

        db.close();
        return per;
    }
}

package database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Sergii_Chertkov on 2/19/2016.
 */
public class DBResult {
    public ArrayList<String> column_name;
    private ArrayList<Row> row;
    private int columns;
    private boolean result;

    public DBResult(ResultSet rs){
        row = new ArrayList<Row>();
        column_name = new ArrayList<String>();
        columns = 0;
        result = false;
        try{
            ResultSetMetaData rsmd = rs.getMetaData();
            this.columns = rsmd.getColumnCount();
            for (int i=1; i<=this.columns; i++)
                column_name.add(rsmd.getColumnName(i));
            while (rs.next()) {
                Row row_tmp = new Row();
                for (int i=1; i<=this.columns; i++)
                    row_tmp.add(rs.getString(i));
                row.add(row_tmp);
            }
        } catch (SQLException e){
            this.result = false;
        }
    }

    public String get (int column_id, int row_number){
        return row.get(row_number).get(column_id);
    }

    public int row_count (){return row.size();}

    public int col_count (){return columns;}

    private class Row {
        public ArrayList<String> param;
        public Row(){
            param = new ArrayList<String>();
        }
        public Row(ArrayList<String> par){
            param = new ArrayList<String>();
            param = par;
        }
        public void add (String p){
            param.add(p);
        }
        public String get(int id){
            return param.get(id);
        }
    }

}

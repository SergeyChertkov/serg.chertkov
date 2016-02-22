package servlet;

import database.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergii_Chertkov on 2/17/2016.
 */

@WebServlet(
        name = "SqlServlet",
        urlPatterns = {"/sql"}
)
public class SqlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("POST");
        DataBase db = new DataBase();
        if (req.getParameter("query")==null) {
            req.setAttribute("query", "");
            req.setAttribute("result", "");
        }
        else {
            String query = req.getParameter("query").toString();
            String result = "";
            if(query.substring(0,6).toUpperCase().equals("SELECT")) {
                ResultSet rs = db.select(query);
                try{
                    while (rs.next()) {
                        result += "<br/> Id=" + rs.getInt("id") + " Name=" + rs.getString("name") + " Surame " + rs.getString("surname");
                    }
                } catch(Exception e) {
                    result = "fail";
                }
            } else {
                if (db.execute(query))
                    result = "success";
                else
                    result = "fail";
            }
            req.setAttribute("query", query);
            req.setAttribute("result", result);
        }
        req.getRequestDispatcher("sql_query.jsp").forward(req, resp);
        db.close();
    }

}

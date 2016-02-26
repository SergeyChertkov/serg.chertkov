package servlet;

import database.DBResult;
import database.DataBase;
import database.FindPersonDB;
import database.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergii_Chertkov on 2/17/2016.
 */

@WebServlet(
        name = "SqlServlet",
        urlPatterns = {"/test_jsp"}
)
public class SqlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("POST");

        FindPersonDB per = new FindPersonDB();
        req.setAttribute("persons",per.name(req.getParameter("name"))
                .surname(req.getParameter("surname")).mail(req.getParameter("mail"))
                .dateFrom(req.getParameter("dateFrom")).dateTo(req.getParameter("dateTo"))
                .getResult());

        req.getRequestDispatcher("sql_query.jsp").forward(req, resp);
    }

}

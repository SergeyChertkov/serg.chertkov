<%@ page import ="database.*" %>
<%
    String userid = request.getParameter("uname");
    String pwd = request.getParameter("pass");
    DataBase.connect();
    DataBase.setPrint(true);
    DBResult res = new DBResult(
        DataBase.select("select * from members where uname='" + userid + "' and pass='" + pwd + "'"));
    DataBase.close();

    if (res.row_count()>0) {
        session.setAttribute("userid", userid);
        response.sendRedirect("success.jsp");
    } else {
        out.println("Invalid password <a href='index.jsp'>try again</a>");
    }
%>
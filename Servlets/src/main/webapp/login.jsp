<%@ page import ="database.*" %>
<%
    String user_id = request.getParameter("uname");
    String pwd = request.getParameter("pass");
    DataBase.connect();
    DBResult res = new DBResult(
        DataBase.select("select * from members where uname='" + user_id + "' and pass='" + pwd + "'"));
    DataBase.close();

    if (res.row_count()>0) {
        session.setAttribute("user_id", res.get(0,0));
        session.setAttribute("first_name", res.get(0,1));
        session.setAttribute("last_name", res.get(0,2));
        session.setAttribute("admin", res.get(0,6));
        response.sendRedirect("success.jsp");
    } else {%>
    <jsp:include page="header.jsp" flush="true" />
    <%
        out.println("Invalid password <a href='login_page.jsp'>try again</a>");
    }
%>
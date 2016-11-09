<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP TEST</title>
    </head>
    <body>
        <center>
            <table border="0" width="100%" cellpadding="3" bgcolor="#E6E6FA">
                <thead>
                    <tr>
                        <th colspan="2"><a href="index.jsp">This is a Test site</a></th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            if ((session.getAttribute("user_id") == null) ||
                                (session.getAttribute("user_id") == "")){%>
                                <td align="left">
                                    You are not logged in
                                </td>
                                <td align="right" width="10%">
                                    <a href='login_page.jsp'>log in</a>&nbsp;
                            <%} else {%>
                                <td align="left">
                                    You are <a href='settings.jsp'><b><%=session.getAttribute("first_name")%> <%=session.getAttribute("last_name")%></b></a>
                                </td>
                                <td align="right" width="10%">
                                    <a href='logout.jsp'>log out</a>&nbsp;
                            <%}
                        %>
                        </td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                    </tr>
                </tbody>
            </table>
            <br>
        </center>
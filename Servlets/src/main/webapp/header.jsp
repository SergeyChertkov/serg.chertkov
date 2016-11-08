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
                        <th colspan="2">This is a Test site</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            if ((session.getAttribute("userid") == null) ||
                                (session.getAttribute("userid") == "")){%>
                                <td align="left">
                                    You are not logged in
                                </td>
                                <td align="right" width="10%">
                                    <a href='login_page.jsp'>log in</a>&nbsp;
                            <%} else {%>
                                <td align="left">
                                    You are <b><%=session.getAttribute("userid")%></b>
                                </td>
                                <td align="right" width="10%">
                                    <a href='logout.jsp'>log out</a>&nbsp;
                            <%}
                        %>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">&nbsp;</td>
                    </tr>
                </tbody>
            </table>
            <br>
        </center>
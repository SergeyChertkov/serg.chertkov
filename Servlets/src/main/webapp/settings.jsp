    <jsp:include page="header.jsp" flush="true" />
        <%@ page import ="database.*" %>

        <form method="post" action="save_settings.jsp">

        <table border="0" width="200" cellpadding="3"><tbody><tr><td colspan="2"><tbody>
            <table border="0" width="100%" align="center">
                <tbody>
                    <%
                    DataBase.connect();
                    DBResult res = new DBResult(
                        DataBase.select("select * from settings where user_id='" + session.getAttribute("user_id") + "'"));
                    DataBase.close();
                    String checked = "";

                    if(res.row_count()>0){
                        for (int i=2; i<res.col_count()-1; i++)
                            session.setAttribute(res.getColumnName(i),res.getRow(0).get(i));
                    }
                    else{
                        for (int i=2; i<res.col_count()-1; i++)
                            session.setAttribute(res.getColumnName(i),"TRUE");
                    }

                    for (int i=2; i<res.col_count()-1; i++){
                        if(session.getAttribute(res.getColumnName(i)).equals("TRUE")){checked = "checked";}
                        else checked = "";
                        %>
                    <tr><td><input type="checkbox" <%=checked%> name= <%=res.getColumnName(i)%>>
                        <%=res.getColumnName(i)%>
                    <td></tr><%
                    }%>
                </tbody>
            </table>
        </td></tr>
        <tr>
            <td width="50%" align="center">
                <input type="reset" value="Reset" onClick='parent.location="javascript:location.reload()"'>
            </td>
            <td width="50%" align="center">
                <input type="submit" value="Save">
            </td>
        </td></tr>
    </tbody></table>

    </form>

    </body>
</html>
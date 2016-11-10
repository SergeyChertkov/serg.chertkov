<%@ page import ="database.*" %>
<%
    DataBase.connect();
    DBResult res = new DBResult(
        DataBase.select("select * from settings where user_id='" + session.getAttribute("user_id") + "'"));

    String checkbox = "";

    for (int i=2; i<res.col_count()-1; i++){
        checkbox = request.getParameter(res.getColumnName(i));

        if (checkbox==null)
            session.setAttribute(res.getColumnName(i), "FALSE");
        else session.setAttribute(res.getColumnName(i), "TRUE");
    }

    String query = "";
    if (res.row_count()>0){
        query = "update settings set ";
        for (int i=2; i<res.col_count()-1; i++){
            query += res.getColumnName(i) + "=" + session.getAttribute(res.getColumnName(i));
            if (i<res.getRow(0).size()-2)
                query += ", ";
        }
        query += " where user_id=" + session.getAttribute("user_id");
        DataBase.execute(query);
    }
    else {
        query = "insert into settings (user_id, ";
        for (int i=2; i<res.col_count()-1; i++){
            query += res.getColumnName(i) + ", ";
        }
        query += "editdate) values (" + session.getAttribute("user_id")+", ";
        for (int i=2; i<res.col_count()-1; i++){
            query += session.getAttribute(res.getColumnName(i)) + ", ";
        }
        query += "NOW())";
        DataBase.execute(query);
    }
    DataBase.close();
%>
<jsp:include page="settings.jsp" flush="true" />
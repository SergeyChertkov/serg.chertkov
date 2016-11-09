    <jsp:include page="header.jsp" flush="true" />
    <%
        if ((session.getAttribute("user_id") != null) &&
            (session.getAttribute("user_id") != "")){%>
            content: <%= new java.util.Date () %>
            <%if(session.getAttribute("online")=="online"){%>
                <meta HTTP-EQUIV="Refresh" content="1" />
            <%}%>
            <br><br>
            <form method="post" action="online.jsp">
                &nbsp;
                <input type="submit" value=<%
                    if (session.getAttribute("online")=="online")
                        out.println("offline");
                    else out.println("online");
                %> />
            </form>
        <%}
    %>
    </body>
</html>
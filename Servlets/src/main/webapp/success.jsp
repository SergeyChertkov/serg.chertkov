    <jsp:include page="header.jsp" flush="true" />
        <%
            if ((session.getAttribute("user_id") == null) || (session.getAttribute("user_id") == "")) {
        %>
        You are not logged in<br/>
        <a href="index.jsp">Please Login</a>
        <%} else {
        %>
        Welcome <%=session.getAttribute("first_name")%> <%=session.getAttribute("last_name")%>
        <a href='index.jsp'>go to main page</a>
        <%
            }
        %>
    </body>
</html>
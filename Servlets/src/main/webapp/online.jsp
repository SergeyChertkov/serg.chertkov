
<%
    if (session.getAttribute("online")=="online")
        session.setAttribute("online", "offline");
    else session.setAttribute("online", "online");

    response.sendRedirect("index.jsp");
%>
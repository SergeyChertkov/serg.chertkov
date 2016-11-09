<html>
    <body>
        <h2>Hello Heroku!</h2>
        <%
            // This scriptlet declares and initializes "date"
            System.out.println( "Evaluating date now" );
            java.util.Date date = new java.util.Date();
        %>

        <%
            out.println( "<b>Hello!  The time is now</b>" );
            out.println( date );
            out.println( "<BR>Your machine's address is " );
            out.println( request.getRemoteHost());
        %>
        <p>
        <TABLE BORDER=1>
        <%
            for ( int i = 0; i < 10; i++ ) {
                %>
                <TR>
                <TD>Number</TD>
                <TD><%= i+1 %></TD>
                <%
                for (int j=0; j<8; j++){
                    %>
                    <TD>...</TD>
                    <%
                }
                %>
                </TR>
                <%
            }
        %>
        </TABLE>
        <p>
        java.version = <%= System.getProperty("java.version") %>
        <BR>java.home = <%= System.getProperty("java.home") %>
        <BR>os.name = <%= System.getProperty("os.name") %>
        <BR>user.name = <%= System.getProperty("user.name") %>
        <BR>user.home = <%= System.getProperty("user.home") %>
        <BR>user.dir = <%= System.getProperty("user.dir") %>
        <p>
        <meta HTTP-EQUIV="Refresh" content="1">
        <%= new java.util.Date () %>
        </meta>


    </body>
</html>
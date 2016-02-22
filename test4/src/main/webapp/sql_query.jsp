<html>
<body>

    <form action="/sql" method="GET">
        Query: <input type="text" name="query">
        <input type="submit" value="Submit" />
    </form>

    <ul>
    <li><p><b>Last query:</b>
       <%= request.getAttribute("query")%>
    </p></li>
    <li><p><b>Result:</b>
       <%= request.getAttribute("result")%>
    </p></li>
    </ul>

</body>
</html>
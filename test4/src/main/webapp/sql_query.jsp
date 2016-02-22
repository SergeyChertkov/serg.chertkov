<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="datapiker.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
<script>
  $(function() {
    $( "#datepickerFrom" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
  });
</script>
<script>
  $(function() {
    $( "#datepickerTo" ).datepicker({ dateFormat: 'yy-mm-dd' }).val();
  });
</script>
</head>
<body>

<h1 align=center>TEST JSP</h1>
    <form action="/sql" method="GET">
        <table cellpadding="5">
            <tr><td> Name: </td> <td> <input type="text" name="name"> </td></tr>
            <tr><td> Surname: </td> <td> <input type="text" name="surname"> </td></tr>
            <tr><td> Mail: </td> <td> <input type="text" name="mail"> </td></tr>
            <tr><td> Date from: </td> <td> <input type="text" name="dateFrom" id="datepickerFrom"> </td></tr>
            <tr><td> Date to: </td> <td> <input type="text" name="dateTo" id="datepickerTo"> </td></tr>
        </table>
        <br>
        <input type="submit" value="Submit" />
    </form>

    <table border=1 width=100% cellpadding="5">
    <tr bgcolor=lightgray align=center>
        <td min-width=10%> <b>ID</b> </td>
        <td width=25%> <b>NAME</b> </td>
        <td width=25%> <b>SURNAME</b> </td>
        <td width=20%> <b>MAIL</b> </td>
        <td width=20%> <b>BORN</b> </td>
    </tr>
    <c:forEach var="person" items="${persons}">
        <tr>
            <td width=10% align=center> ${person.id} </td>
            <td width=25%> ${person.name} </td>
            <td width=25%> ${person.surname} </td>
            <td width=20%> ${person.mail} </td>
            <td width=20% align=center> ${person.born} </td>
        </tr>
    </c:forEach>
    </table>

</body>
</html>
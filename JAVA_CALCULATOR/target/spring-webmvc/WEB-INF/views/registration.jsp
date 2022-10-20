<%--
  Created by IntelliJ IDEA.
  User: MIRMDKAWSUR
  Date: 10/13/2022
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form method="post" action="data/create">
        <label for="input1">First Input :</label>
        <input type="number" name="input1" id="input1"/>

        <br><br>

        <label for="input2">Secound Input:</label>
        <input type="text" name="input2" id="input2"/>

        <br><br>

        <input type="submit" value="Register">
    </form>
<h2>${res}</h2>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kawsu
  Date: 10/25/2022
  Time: 9:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>

<h1>Tax Calculations</h1>


<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Designation</th>
        <th>Gross Salary</th>
        <th>Gender</th>
        <th>Annual Taxable Pay</th>
        <th>Monthly Taxable Pay</th>
    </tr>
    </thead>
    <tbody>

        <tr>
            <td>${name}</td>
            <td>${desig}</td>
            <td>${gsal}</td>
            <td>${gender}</td>
            <td>${annual}</td>
            <td>${monthly}</td>
        </tr>

    </tbody>
</table>


</body>
</html>

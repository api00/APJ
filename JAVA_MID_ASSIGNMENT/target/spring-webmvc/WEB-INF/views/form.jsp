<%--
  Created by IntelliJ IDEA.
  User: API ALAM
  Date: 11/4/2022
  Time: 12:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>To calculate TAX fill up this form</h1>
<%--@elvariable id="user" type="com.domain.User"--%>
<form:form action="create" modelAttribute="user">
    <label for="name">Name:</label>
    <form:input path="name" id="name"/>
    <form:errors path="name"/>
    <label for="Designation">Designation:</label>
    <form:input path="designation" id="Designation"/>
    <form:errors path="designation"/>
    <label for="Gender">Gender:</label>
    <form:input path="gender" id="Gender"/>
    <form:errors path="gender"/>
    <label for="Gross_sal">Gross Salary:</label>
    <form:input path="GSal" id="Gross_sal"/>
    <form:errors path="GSal"/>
    <label for="b_salary">Basic Salary:</label>
    <form:input path="BSal" id="b_salary"/>
    <form:errors path="BSal"/>
    <label for="h_rent">House rent:</label>
    <form:input path="h_rent" id="h_rent"/>
    <form:errors path="h_rent"/>
    <label for="c_allaowence">Conveyance allowance :</label>
    <form:input path="CAllowance" id="c_allaowence"/>
 <form:errors path="CAllowance"/>
   <label for="m_allowance">Medical allowance :</label>
    <form:input path="MAllowance" id="m_allowance"/>
   <form:errors path="MAllowance"/>
    <label for="others">Others:</label>
    <form:input path="others" id="others"/>
    <form:errors path="others"/>



    <br><br>

    <input type="submit">

</form:form>
</body>
</html>

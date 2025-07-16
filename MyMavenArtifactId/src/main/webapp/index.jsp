<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<sql:setDataSource var="myDB" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/students" user="root" password="venkey"/>
<sql:query dataSource="${myDB}" var="ids">
select id from employees
</sql:query>
<form action="welcome.jsp" method="GET">
<fieldset>
<legend>Update League records:</legend>

<label>Id:</label><select name="id">

<c:forEach var="myId" items="${ids.rows}">
<option value="${myId.id}">${myId.id}</option>
</c:forEach>
</select>
<br>
<label>Field:</label><input type="radio" name="myField" value="firstName">firstName<input type="radio" name="myField" value="lastName">lastName<input type="radio" name="myField" value="phone_number">phone_number<input type="radio" name="myField" value="age">age<input type="radio" name="myField" value="join_date">join_date:<input type="date" name="join_date"><br>
<br>
<label>Value:</label><input type="text" name="fieldValue"><br>
<input type="submit" value="submit">

</fieldset>

</form>

</body>
</html>
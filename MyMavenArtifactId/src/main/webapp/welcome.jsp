<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%int myKey=Integer.parseInt(request.getParameter("id")); 
String myField=request.getParameter("myField");
String myValue="";
String join_date=request.getParameter("join_date");

Date jDate=null;	
if(myField.equals("join_date"))
{
	Date d=null;
	SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"); 
	try
	{
		d=formatter.parse(join_date);
		jDate=d;
	}
	catch(ParseException e)
	{
		e.printStackTrace();
	}
}
else
{
myValue=request.getParameter("fieldValue");
}
%>

<c:set var="jDate" value="<%=join_date%>"></c:set>

<c:set var="myKey" value="<%=myKey%>"/>

<c:set var="myField" value="<%=myField %>"/>
<c:choose>
<c:when test="${myField.equals('join_date')}">
<c:set var="myValue" value="<%=jDate%>"/>
</c:when>
<c:otherwise>
<c:set var="myValue" value="<%=myValue%>"/>
</c:otherwise>
</c:choose>
<sql:setDataSource var="myDB" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/students" user="root" password="venkey"/>
<sql:update dataSource="${myDB}" var="count">
<c:choose>
<c:when test="${myField.equals('firstName')}">
UPDATE employees SET First_Name=? where id=?

</c:when>
<c:when test="${myField.equals('lastName')}">
UPDATE employees SET Last_Name=? where id=?
</c:when>
<c:when test="${myField.equals('join_date')}">

UPDATE employees SET join_date=? where id=?

</c:when>
</c:choose>
<sql:param value="${myValue}"/>
<sql:param value="${myKey}"/>
</sql:update>

<H1>Record updated successfully!!!!!</H1>
<h2>Join_date:<c:out value="${jDate}"></c:out></h2>
</body>
</html>
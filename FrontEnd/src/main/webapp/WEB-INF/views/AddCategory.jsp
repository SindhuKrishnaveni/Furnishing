<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<c:url var="url" value="/all/addCategory"></c:url>
  <form:form method="post" action="${url }" modelAttribute="Categorys">
  Enter CategoryName:<form:input path="categoryname"/><br>
  <br>
  Enter CategoryDescription:<form:input path="categorydescp"/><br>
  <br>
  <input type="submit" value="Add"/>
  </form:form>
  </div>
</body>
</html>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<c:url var="url" value="/all/addProduct"></c:url>
  <form:form method="post" action="${url }" modelAttribute="Products" enctype="multipart/form-data">
  Enter ProductName:<form:input path="productname"/><br>
  <br>
  Enter ProductDescription:<form:input path="productdesc"/><br>
  <br>
  Enter Quantity:<form:input path="quantity"/><br>
  <br>
  Enter Price:<form:input path="price"/><br>
  <br>
  Image <form:input type="file" path="pimage"/><br>
  <br/>
  <input type="submit" value="Add"/>
  </form:form>
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="Header.jsp" %>
    <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>Product Table</h2>           
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>ProductId</th>
        <th>ProductName</th>
        <th>ProductDescription</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Images</th>
        <th>Deleting</th>
        <th>Editing</th>
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${productlist}" var="t">
      <tr>
        <td>${t.id}</td>
        <td>${t.productname}</td>
        <td>${t.productdesc}</td>
        <td>${t.quantity}</td>
        <td>${t.price}</td>
        <td><img src="<c:url value='/resources/images/${t.id }.png'></c:url>" height="30px" width="40px"></td>
        <td><a href="<c:url value='DeleteProduct?id=${t.id}'></c:url>">Delete</a></td>
        <td><a href="<c:url value='Edit?id=${t.id}'></c:url>">Edit</a></td>
      </tr>
      </c:forEach>
      </tbody>
  </table>
</div>


</body>
</html>
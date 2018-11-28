<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <h2>Category Table</h2>            
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>CategoryId</th>
        <th>CategoryName</th>
        <th>CategoryDescription</th> 
        <th>Deleting</th> 
        <th>Editing</th> 
     </tr>
    </thead>
    <tbody>
    <c:forEach items="${categorylist}" var="v">
      <tr>
        <td>${v.categoryid}</td>
        <td>${v.categoryname}</td>
        <td>${v.categorydescp}</td>
        <td><a href="<c:url value='DeleteCategory?id=${v.categoryid}'></c:url>">Delete</a></td>
        <td><a href="<c:url value='EditCategory?id=${v.categoryid}'></c:url>">Edit</a></td>  
      </tr>
      </c:forEach>
      </tbody>
  </table>
</div>
</body>
</html>
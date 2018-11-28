<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<nav class="navbar navbar-inverse">
<div class="container-fluid">
<div class="navbar-header">
</div>
<ul class="nav navbar-nav">
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">Product
<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="<c:url value='/all/AddProduct'></c:url>">Add</a></li>
<li><a href="<c:url value='/all/ViewProduct'></c:url>">View</a></li>
</ul>
</li>
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">Category
<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="<c:url value='/all/AddCategory'></c:url>">Add</a></li>
<li><a href="<c:url value='/all/ViewCategory'></c:url>">View</a></li>
</ul>
</li>
<li class="dropdown">
<a class="dropdown-toggle" data-toggle="dropdown" href="#">Supplier
<span class="caret"></span></a>
<ul class="dropdown-menu">
<li><a href="<c:url value='/all/AddSupplier'></c:url>">Add</a></li>
<li><a href="<c:url value='/all/ViewSupplier'></c:url>">View</a></li>
</ul>
</li>
</ul>
</div>
</nav>
  
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false"%>
<%@ include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Products</title>
<style>
.card button {
  border: none;
  outline: 0;
  padding: 12px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto;
  grid-template-rows: auto auto ;
  grid-gap: 10px;
  padding: 10px;
}
.grid-container>div {
  background-color: rgba(255, 255, 255, 0.8);
  text-align: center;
  padding:10px 0;
  font-size: 30px;
}
</style>
</head>
<body>
<div class="grid-container" style="grid-auto-flow: row;">                                        
   <c:forEach items="${productlist}" var="t">
   <div class="item1">
   <div class="card"> 
   <div class="thumbnail">
       <img src="<c:url value='/resources/images/${t.id }.png'></c:url>" height="300px" width="300px">
       <div class="caption">
                    <h4 class="group inner list-group-item-heading" align="center"> ${t.productname} </h4>
                    </div>
              
         <a href="<c:url value='/all/Info?id=${t.id}'></c:url>"><button> View </button><br></a>
          </div>
          </div>
          </div>
          
      </c:forEach>
     </div>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="ISO-8859-1">
	<title>AppPizzaria</title>
</head>
<body>
	<div class="container mt-3">
	  <c:import url="/WEB-INF/jsp/menu.jsp" />

	  <h3>Classe: Massa</h3>	   
	  
	    <c:if test="${not empty mensagem}">
		  <div class="alert alert-info">
		    <strong>Informação!</strong> ${mensagem}
		  </div>
	    </c:if> 
	             
	  <table class="table table-striped">
	    <thead>
	      <tr>
			<th>ID</th>
	        <th>Sabor</th>
	        <th>Tipo</th>
	        <th>Data</th>
			<th></th>
	      </tr>
	    </thead>
	    <tbody>
		  <c:forEach var="m" items="${listagem}">
			<tr>
				<td>${m.id}</td>
				<td>${m.sabor}</td>
				<td>${m.tipo}</td>
				<td>${m.data}</td>
				<td><a href="/massa/${m.id}/excluir">excluir</a></td>
			</tr>
		  </c:forEach>
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
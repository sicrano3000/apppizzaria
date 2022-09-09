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

		<h2>${projeto.nome}</h2>
		<p>${projeto.descricao}</p>
		
		<c:forEach var="classe" items="${projeto.classes}">
		<h3>Classe: ${classe.nome}</h3>	              
		  <table class="table table-striped">
		    <thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="atributo" items="${classe.atributos}">
					<tr>
						<td>${atributo.nome}</td>
						<td>${atributo.tipo}</td>
						<td>${atributo.descricao}</td>
					</tr>
				</c:forEach>
		    </tbody>
		  </table>
	    </c:forEach>
	</div>	
</body>
</html>
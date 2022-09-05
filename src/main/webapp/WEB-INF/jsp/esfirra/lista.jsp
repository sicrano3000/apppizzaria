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

	  <h3>Classe: Esfirra</h3>	              
	  <table class="table table-striped">
	      <thead>
			<tr>
			  <th>ID</th>
			  <th>Tipo</th>
			  <th>Sabor</th>
			  <th>Borda</th>
			  <th>Valor</th>
			  <th>Descrição</th>
			  <th>Data</th>
			  <th></th>
			</tr>
		  </thead>
		  <tbody>
			<c:forEach var="e" items="${listagem}">
			  <tr>
				  <td>${e.id}</td>
				  <td>${e.tipo}</td>
				  <td>${e.sabor}</td>
				  <td>${e.borda}</td>
				  <td>${e.valor}</td>
				  <td>${e.descricao}</td>
				  <td>${e.data}</td>
				  <td><a href="/esfirra/${e.id}/excluir">excluir</a></td>
			  </tr>
			</c:forEach>
		  </tbody>
	  </table>
	  
	  <p><a href="/esfirra">Cadastrar esfirra</a></p>
	  
	</div>	
</body>
</html>
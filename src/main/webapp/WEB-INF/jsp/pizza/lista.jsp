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
		<nav class="navbar navbar-expand-sm bg-light navbar-light">
			<div class="container-fluid">
			  <ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="/">Home</a>
				</li>
			   <li class="nav-item">
					<a class="nav-link active" href="/pizza/lista">Pizza</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/esfirra/lista">Esfirra</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/espaguete/lista">Espaguete</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/entrega/lista">Entrega</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/cliente/lista">Cliente</a>
				</li>
			  </ul>
			</div>
		</nav>

	  <h3>Classe: Pizza</h3>	              
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
		  <c:forEach var="p" items="${listagem}">
			<tr>
				<td>${p.id}</td>
				<td>${p.tipo}</td>
				<td>${p.sabor}</td>
				<td>${p.borda}</td>
				<td>${p.valor}</td>
				<td>${p.descricao}</td>
				<td>${p.data}</td>
				<td><a href="/pizza/${p.id}/excluir">excluir</a></td>
			</tr>
		  </c:forEach>
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
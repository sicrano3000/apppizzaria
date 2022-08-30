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
					<a class="nav-link active" href="/">Home</a>
				</li>
				
				<c:if test="${ not empty user }">
					<li class="nav-item">
						<a class="nav-link" href="/usuario/lista">Usuário</a>
					</li>
				    <li class="nav-item">
						<a class="nav-link" href="/pizza/lista">Pizza</a>
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
				</c:if>
			  </ul>
			  
			  <ul class="navbar-nav">
			    <c:if test="${ empty user }">
					<li class="nav-item">
						<a class="nav-link" href="">Signup</a>
					</li>
				  	<li class="nav-item">
						<a class="nav-link" href="/login">Login</a>
					</li>
				</c:if>
				
				<c:if test="${ not empty user }">
					<li class="nav-item">
						<a class="nav-link" href="/logout">Logout ${ user }</a>
					</li>
				</c:if>
			  </ul>
			</div>
		  </nav>

	  <h2>AppPizzaria</h2>
	  <p>Projeto de Gestão de Pizzas e Massas</p>
	  
	</div>	
</body>
</html>
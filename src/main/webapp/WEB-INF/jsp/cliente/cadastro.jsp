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

		<h2>AppPizzaria</h2>
		<p>Projeto de Gest�o de Pizzas e Massas</p>
	  
		<div class="container mt-3">
			<h2>Cadastramento de Cliente</h2>
		    <form action="/cliente/incluir" method="post">
	    	  <div class="mb-3 mt-3">
			    <label for="nome" class="form-label">Nome:</label>
			    <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome">
			  </div>		    
			  <div class="mb-3 mt-3">
			    <label for="cpf" class="form-label">Cpf:</label>
			    <input type="text" class="form-control" placeholder="Entre com o seu cpf" name="cpf">
			  </div>			  
			  <div class="mb-3">
			    <label for="email" class="form-label">Email:</label>
			    <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
			  </div>
			  <button type="submit" class="btn btn-primary">Cadastrar</button>
			</form> 
		</div>
	  
	</div>	
</body>
</html>
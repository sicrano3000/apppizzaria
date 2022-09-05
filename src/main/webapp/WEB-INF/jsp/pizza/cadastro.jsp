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
		<p>Projeto de Gestão de Pizzas e Massas</p>
	 
		<div class="container mt-3">
			<h2>Cadastramento de Pizza</h2>
		    <form action="/pizza/incluir" method="post">
	    	  <div class="mb-3 mt-3">
			    <label for="tipo" class="form-label">Tipo:</label>
			    <input type="text" class="form-control" placeholder="Entre com o tipo" name="tipo">
			  </div>		    
			  <div class="mb-3 mt-3">
			    <label for="sabor" class="form-label">Sabor:</label>
			    <input type="text" class="form-control" placeholder="Entre com o sabor" name="sabor">
			  </div>			  
			  <div class="mb-3 mt-3">
			    <label for="borda" class="form-label">Borda:</label>
			    <input type="text" class="form-control" placeholder="Entre com a borda" name="borda">
			  </div>
			  <div class="mb-3 mt-3">
			    <label for="valor" class="form-label">Valor:</label>
			    <input type="text" class="form-control" placeholder="Entre com o valor" name="valor">
			  </div>			  
			  <div class="mb-3">
			    <label for="descricao" class="form-label">Descrição:</label>
			    <input type="text" class="form-control" placeholder="Entre com a descrição" name="descricao">
			  </div>
			  <button type="submit" class="btn btn-primary">Cadastrar</button>
			</form> 
		</div>
	  
	</div>	
</body>
</html>
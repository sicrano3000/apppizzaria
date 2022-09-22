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
			<h2>Cadastramento de Entregas</h2>
		    <form action="/entrega/incluir" method="post">	    
			  <div class="mb-3 mt-3">
			    <label for="endereco" class="form-label">Endereço:</label>
			    <input type="text" class="form-control" placeholder="Entre com o Endereço" name="endereco">
			  </div>			  
			  <div class="mb-3 mt-3">
			    <label for="borda" class="form-label">Tempo de preparo:</label>
			    <input type="text" class="form-control" placeholder="Entre com a borda" name="borda">
			  </div>
			  <div class="mb-3 mt-3">
			    <select name="cliente" id="cliente">
				    <c:forEach var="c" items="${clientes}">
					  <option value="${c}">${c.nome}</option>
				  	</c:forEach>
				</select>
			  </div>			  
			  <div class="mb-3">
				  <c:forEach var="p" items="${produtos}">
				    <input type="checkbox" id="massas" name="massas" value="${p.sabor}">
					<label for="massas"> ${p}</label><br>
			  	  </c:forEach>
			  </div>
			  <button type="submit" class="btn btn-primary">Cadastrar</button>
			</form> 
		</div>
	  
	</div>	
</body>
</html>
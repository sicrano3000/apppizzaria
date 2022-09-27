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
	  
	    <c:if test="${not empty mensagem}">
		  <div class="alert alert-info">
		    <strong>Informação!</strong> ${mensagem}
		  </div>
	    </c:if> 
	  
		<div class="container mt-3">
			<h2></h2>
		    <form action="/login" method="post">
			  <div class="mb-3 mt-3">
			    <label for="email" class="form-label">Email:</label>
			    <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
			  </div>			  
			  <div class="mb-3">
			    <label for="senha" class="form-label">Password:</label>
			    <input type="password" class="form-control" placeholder="Entre com sua senha" name="senha">
			  </div>
			  <button type="submit" class="btn btn-primary">Logar</button>
			</form> 
		</div>
	  
	</div>	
</body>
</html>
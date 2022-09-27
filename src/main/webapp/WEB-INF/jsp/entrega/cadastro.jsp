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
		<c:set var="ativaBotao" value="" />
		
		<c:import url="/WEB-INF/jsp/menu.jsp" />

		<h2>AppPizzaria</h2>
		<p>Projeto de Gest�o de Pizzas e Massas</p>
	 
		<div class="container mt-3">
			<h2>Cadastramento de Entregas</h2>
		    <form action="/entrega/incluir" method="post">	    
			  <div class="mb-3 mt-3">
			    <label for="endereco" class="form-label">Endere�o:</label>
			    <input type="text" class="form-control" placeholder="Entre com o Endere�o" name="endereco">
			  </div>
			  			  
			  <div class="mb-3 mt-3">
			    <label for="borda" class="form-label">Tempo de preparo:</label>
			    <input type="text" class="form-control" placeholder="Entre com a borda" name="tempoPreparo">
			  </div>
			  
			  <div class="mb-3 mt-3">
			  	<c:if test="${not empty clientes}">
				    <select name="cliente" class="form-control" id="cliente">
					    <c:forEach var="c" items="${clientes}">
						  <option value="${c.id}">${c.nome}</option>
					  	</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty clientes}">
					<label>N�o existe cliente cadastrado!</label>
					
					<c:set var="ativaBotao" value="disabled" />
				</c:if>
			  </div>	
			  		  
			  <div class="mb-3">
			  	<c:if test="${not empty produtos}">
				  <c:forEach var="p" items="${produtos}">
				    <input type="checkbox" id="${p.id}" name="massas" value="${p.id}">
					<label for="${p.id}"> ${p}</label><br>
			  	  </c:forEach>
			  	</c:if>
			  	<c:if test="${empty produtos}">
					<label>N�o existe produto cadastrado!</label>
					
					<c:set var="ativaBotao" value="disabled" />
				</c:if>
			  </div>
			  
			  <button ${ativaBotao} type="submit" class="btn btn-primary">Cadastrar</button>
			</form> 
		</div>
	  
	</div>	
</body>
</html>
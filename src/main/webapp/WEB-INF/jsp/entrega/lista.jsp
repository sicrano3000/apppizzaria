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

	  <h3>Classe: Entrega</h3>
	  <table class="table table-striped">
	    <thead>
	      <tr>
			<th>ID</th>
	        <th>Endereço</th>
	        <th>Tempo de Preparo</th>
	        <th>Previsão de Entrega</th>
	        <th>Cliente</th>
	        <th>Carrinho</th>
			<th></th>
	      </tr>
	    </thead>
	    <tbody>
		  <c:forEach var="e" items="${listagem}">
			<tr>
				<td>${e.id}</td>
				<td>${e.endereco}</td>
				<td>${e.tempoPreparo}</td>
				<td>${e.previsaoEntrega}</td>
				<td>${e.cliente.nome}</td>
				<td>
					<c:forEach var="c" items="${e.carrinho}">
						- ${c.sabor}<br />
					</c:forEach>
				</td>
				<td><a href="/entrega/${e.id}/excluir">excluir</a></td>
			</tr>
		  </c:forEach>
	    </tbody>
	  </table>
	  
	  <p><a href="/entrega">Cadastrar entrega</a></p>
	  
	</div>	
</body>
</html>
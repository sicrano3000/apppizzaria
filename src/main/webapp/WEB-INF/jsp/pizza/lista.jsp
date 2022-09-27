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

	  <h3>Classe: Pizza</h3>	
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-info">
		  <strong>Informação!</strong> ${mensagem}
		</div>
	  </c:if>
	                
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
	  
	  <p><a href="/pizza">Cadastrar pizza</a></p>
	  
	</div>	
</body>
</html>
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

	  <h3>Classe: Cliente</h3>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-info">
		  <strong>Informação!</strong> ${mensagem}
		</div>
	  </c:if>
	               
	  <table class="table table-striped">
	    <thead>
	      <tr>
			<th>ID</th>
	        <th>Nome</th>
	        <th>CPF</th>
	        <th>Email</th>
	        <th>Usuário</th>
			<th></th>
	      </tr>
	    </thead>
	    <tbody>
		  <c:forEach var="c" items="${listagem}">
			<tr>
				<td>${c.id}</td>
				<td>${c.nome}</td>
				<td>${c.cpf}</td>
				<td>${c.email}</td>
				<td>${c.usuario.email}</td>
				<td><a href="/cliente/${c.id}/excluir">excluir</a></td>
			</tr>
		  </c:forEach>
	    </tbody>
	  </table>
	  
	  <p><a href="/cliente">Cadastrar cliente</a></p>
	  
	</div>	
</body>
</html>
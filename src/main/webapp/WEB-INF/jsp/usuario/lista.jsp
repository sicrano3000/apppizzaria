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

	  <h3>Classe: Usu�rio</h3>	
	  
      <c:if test="${not empty mensagem}">
	    <div class="alert alert-info">
	      <strong>Informa��o!</strong> ${mensagem}
	    </div>
      </c:if> 
	                
	  <table class="table table-striped">
	    <thead>
	      <tr>
			<th>Nome</th>
	        <th>Email</th>
	        <th>Senha</th>
	        <th></th>
	      </tr>
	    </thead>
	    <tbody>
		  <c:forEach var="u" items="${listagem}">
			<tr>
				<td>${u.nome}</td>
				<td>${u.email}</td>
				<td>${u.senha}</td>
				<td><a href="/usuario/${u.email}/excluir">excluir</a></td>
			</tr>
		  </c:forEach>
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
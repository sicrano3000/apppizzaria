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
					<a class="nav-link" href="/">Home</a>
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
					<a class="nav-link" href="/massa/lista">Massa</a>
				</li>
				<li class="nav-item">
					<a class="nav-link active" href="/entrega/lista">Entrega</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/cliente/lista">Cliente</a>
				</li>
			  </ul>
			</div>
		  </nav>

	  <h3>Classe: Entrega</h3>
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Atributo</th>
	        <th>Tipo</th>
	        <th>Descrição</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>Endereco</td>
	        <td>String</td>
	        <td>Local para ser entregue</td>
	      </tr>
	      <tr>
	        <td>TempoPreparo</td>
	        <td>Integer</td>
	        <td>Tempo em minutos necessário para preparar o pedido</td>
	      </tr>
	      <tr>
	        <td>PrevisaoEntrega</td>
	        <td>LocalDateTime</td>
	        <td>Horário para o pedido ser entregue</td>
	      </tr>
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
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
					<a class="nav-link active" href="/espaguete/lista">Espaguete</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/massa/lista">Massa</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/entrega/lista">Entrega</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/cliente/lista">Cliente</a>
				</li>
			  </ul>
			</div>
		  </nav>

	  <h3>Classe: Espaguete</h3>	              
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
	        <td>Sabor</td>
	        <td>String</td>
	        <td>Indica o sabor do espaguete</td>
	      </tr>
	      <tr>
	        <td>Valor</td>
	        <td>Double</td>
	        <td>Valor a ser pago</td>
	      </tr>
	      <tr>
	        <td>Descricao</td>
	        <td>String</td>
	        <td>Detalhe adicional</td>
	      </tr>
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
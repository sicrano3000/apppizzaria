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
					<a class="nav-link active" href="/">Home</a>
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
					<a class="nav-link" href="/entrega/lista">Entrega</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/cliente/lista">Cliente</a>
				</li>
			  </ul>
			  
			  <ul class="navbar-nav">
				<li class="nav-item">
					<a class="nav-link" href="">Signup</a>
				</li>
			  	<li class="nav-item">
					<a class="nav-link" href="/login">Login</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="">Logout</a>
				</li>
			  </ul>
			</div>
		</nav>

		<h2>AppPizzaria</h2>
		<p>Projeto de Gestão de Pizzas e Massas</p>
	  
		<div class="container mt-3">
			<h2>Cadastramento de Usuário</h2>
		    <form action="/usuario/incluir" method="post">
	    	  <div class="mb-3 mt-3">
			    <label for="nome" class="form-label">Nome:</label>
			    <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome">
			  </div>		    
			  <div class="mb-3 mt-3">
			    <label for="email" class="form-label">Email:</label>
			    <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email">
			  </div>			  
			  <div class="mb-3">
			    <label for="senha" class="form-label">Password:</label>
			    <input type="password" class="form-control" placeholder="Entre com sua senha" name="senha">
			  </div>
			  <button type="submit" class="btn btn-primary">Cadastrar</button>
			</form> 
		</div>
	  
	</div>	
</body>
</html>
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
	  <h2>AppPizzaria</h2>
	  <p>Projeto de Gestão de Pizzas e Massas</p>
	  
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
	        <td>endereco</td>
	        <td>string</td>
	        <td>Local para ser entregue</td>
	      </tr>
	      <tr>
	        <td>tempoPreparo</td>
	        <td>integer</td>
	        <td>Tempo em minutos necessário para preparar o pedido</td>
	      </tr>
	      <tr>
	        <td>previsaoEntrega</td>
	        <td>localDateTime</td>
	        <td>Horário para o pedido ser entregue</td>
	      </tr>
	    </tbody>
	  </table>

	  <h3>Classe: Pizza</h3>	              
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
	        <td>sabor</td>
	        <td>string</td>
	        <td>Indicativo o sabor da pizza</td>
	      </tr>
	      <tr>
	        <td>valor</td>
	        <td>double</td>
	        <td>Valor a ser pago</td>
	      </tr>
	      <tr>
	        <td>descricao</td>
	        <td>String</td>
	        <td>Detalhe adicional</td>
	      </tr>
	    </tbody>
	  </table>
	  
	</div>	
</body>
</html>
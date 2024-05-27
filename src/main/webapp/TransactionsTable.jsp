<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Historial de Transacciones</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-expand-md bg-body-tertiary"
		data-bs-theme="dark">
		<div class="container-fluid">
			<a class="navbar-brand ">Alke Wallet </a>
		</div>
	</nav>
	<div class="container">
		<div class="col-md-12">
			<h2>Historial de transacciones</h2>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Id transaccion</th>
						<th scope="col">Retiro</th>
						<th scope="col">Deposito</th>
						<th scope="col">fecha</th>
						<th scope="col">Id del usuario</th>
						<th scope="col">Saldo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listadoTransactions}" var="transactions">
						<tr>
							<td>${transactions.getId()}</td>
							<td>${transactions.getRetiro()}</td>
							<td>${transactions.getDeposito()}</td>
							<td>${transactions.getFecha()}</td>
							<td>${transactions.getUsuario_id()}</td>
							<td>${transactions.getSaldo()}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	<a class="btn btn-primary" href="moveform.jsp">volver al menú
		principal</a>
		<br>
		<br>
	<footer>
		<div class="shadow p-3 mb-5 bg-body rounded">Banco Alke 2024</div>
	</footer>
</body>
</html>
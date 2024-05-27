<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>Transacciones</title>
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
	<br>
	<br>
	<div class="text-center">
		<img
			src="https://jcmagazine.com/wp-content/uploads/2021/10/billetera-digital.jpg"
			class="rounded" alt="imagencorporativa">
	</div>
	<br>
	<br>
	<div class="position-relative">
		<div class="position-absolute top-50 start-50 translate-middle">
			<h3>Bienvenido/a, ${username} Atreides</h3>
			<h6>¿Desea hacer alguna transacción?</h6>
		</div>
	</div>
	<br>
	<br>
	<div
		class="col-lg-4 offset-lg-4 col-md-6 offset-md-3
                    col-12 ">
		<form action="transaction" method="post">
			<input type="hidden" name="id" value="1" /> Monto: <input
				type="text" name="amount" /><br /> <br>
			<button type="submit" class="btn btn-primary mb-2" name="action"
				value="deposit">Deposito</button>
			<br>
			<button type="submit" class="btn btn-info mb-2" name="action"
				value="withdraw">Retiro</button>
			<br>
			<a href="/WalletPersonal/historic" class="btn btn-warning" >Historial de transacciones</a>

		</form>
	</div>
	<br>
	<footer>
		<div class="shadow p-3 mb-5 bg-body rounded">Banco Alke 2024</div>
	</footer>
</body>
</html>

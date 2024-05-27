<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Result</title>
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
	<div class="card w-25" class="position-relative">
		<div class="card-body" class="shadow p-3 mb-5 bg-body rounded" class="position-absolute top-50 start-50">
			<p>Balance actual: ${saldo}</p>
			<a class="btn btn-primary" href="moveform.jsp">volver al menú
				principal</a>
		</div>
	</div>
<footer>
		<div class="shadow p-3 mb-5 bg-body rounded">Banco Alke 2024</div>
	</footer>
</body>
</html>
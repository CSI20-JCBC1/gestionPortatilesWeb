<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Formulario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="text-center container w-50 mt-3  border border-2 rounded">
	<br>
		<h1>Nuevo Portatil</h1>
		<form:form method="POST" action="guardarPortatil"
			modelAttribute="portatilV">
			<div>
				<form:label path="marca">Marca</form:label>
				<br>
				<form:input path="marca" />
			</div>
			<div>
				<form:label path="modelo">Modelo</form:label>
				<br>
				<form:input path="modelo" />
				<br> <br>

				<div>
					<input type="submit" class="btn btn-success" value="Guardar">
				</div>
				<br>
		</form:form>
		<p>
			Mensaje del controlador:
			<c:out value="${miModelo.mensaje}" />
		</p>
		<br> <a class="btn btn-secondary"
			href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a> <br>
		<br>
	</div>
</body>
</html>
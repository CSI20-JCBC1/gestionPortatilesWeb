<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Registro</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="text-center container w-50 mt-3  border border-2 rounded">
		<br>
		<h1>Registro</h1>
		<form:form method="POST" action="registrar" modelAttribute="usuarioV">
			<div>
				<form:label path="username">Usuario</form:label>
				<br>
				<form:input path="username" required="required"/>
			</div>
			<div>
				<form:label path="email">Email</form:label>
				<br>
				<form:input path="email" required="required"/>
				<br>
			</div>
			<div>
				<form:label path="password">Contraseña</form:label>
				<br>
				<form:input type="password" path="password" required="required"/>
				
			</div>
			<div>
				<form:label path="password2">Repita la contraseña</form:label>
				<br>
				<form:input type="password" path="password2" required="required"/>
				<br><br>
			</div>
			
			
			<div>
				<input type="submit" class="btn btn-success" value="Registrar">
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
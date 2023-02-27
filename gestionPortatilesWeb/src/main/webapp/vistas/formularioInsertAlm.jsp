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
		<h1>Lista de Portatiles</h1>

		<c:forEach items="${miModelo.listaPortatilesDTO2}" var="portatil">
      Id (<c:out value="${portatil.id_ordenador}" />) 
      Modelo (<c:out value="${portatil.modelo}" />) 
      Marca (<c:out value="${portatil.marca}" />)  
      <br>
			<br>
		</c:forEach>
	</div>
	<div class="text-center container w-50 mt-3  border border-2 rounded">
		<h1>Nuevo Alumno</h1>
		<form:form method="POST" action="guardarAlumno"
			modelAttribute="alumnoV">
			<div>
				<p>IdPortatil</p>
				<select name="idPortatil">

					<c:forEach items="${miModelo.listaPortatilesDTO2}" var="portatil">
						<option><c:out value="${portatil.id_ordenador}" /></option>
					</c:forEach>
				</select>
			</div>
			<div>
				<form:label path="nombre">Nombre</form:label>
				<br>
				<form:input path="nombre" />

			</div>
			<div>
				<form:label path="apellidos">Apellidos</form:label>
				<br>
				<form:input path="apellidos" />
			</div>
			<div>
				<form:label path="num_telefono">Numero de teléfono</form:label>
				<br>
				<form:input path="num_telefono" />
			</div>
			<br>
			<div>
				<input type="submit" class="btn btn-success" value="Guardar">
			</div>

		</form:form>
		<p>
			Mensaje del controlador:
			<c:out value="${miModelo.mensaje}" />
		</p>

		<a class="btn btn-primary"
			href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a> <br>
		<br>
	</div>
</body>
</html>
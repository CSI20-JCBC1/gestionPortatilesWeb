<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>SeleccionarPortatil</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
	<div class="text-center container w-50 mt-3  border border-2 rounded">
		<br>
		<h1>Lista de alumnos</h1>

		<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
      Id (<c:out value="${alumno.id_alumno}" />) 
      Nombre (<c:out value="${alumno.nombre}" />) 
      Apellidos (<c:out value="${alumno.apellidos}" />)  
      <br>
			<br>
		</c:forEach>
	</div>

	<div class="text-center container w-50 mt-3  border border-2 rounded">
		<form:form method="POST" action="buscarPortatil"
			modelAttribute="alumnoV">
			<br>
			<div>
				<h5>Introduce el id del alumno para mostrar su portatil</h5>
				<select name="id_alumno">

					<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
						<option><c:out value="${alumno.id_alumno}" /></option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div>

				<input type="submit" class="btn btn-success" value="Buscar">
			</div>


		</form:form>
		<br>

		<p>
			Mensaje del controlador:
			<c:out value="${miModelo.mensaje}" />
		</p>
		<br> <a class="btn btn-warning"
			href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a> <br>
		<br>
	</div>
</body>
</html>
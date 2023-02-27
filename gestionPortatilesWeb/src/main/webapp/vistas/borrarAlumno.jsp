<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>BorrarAlumnos</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
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
		<br>
		<form:form name="insertAlm" method="POST" action="borrarAlum"
			modelAttribute="alumnoV">

			<div>
				<h5>Introduce el id del alumno a eliminar</h5>
				<select name="id_alumno">

					<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
						<option><c:out value="${alumno.id_alumno}" /></option>
					</c:forEach>
				</select>
			</div>
			<br>
			<div>

				<input
					onclick="return confirm('¿Seguro que desea borrar el usuario?')"
					type="submit" class="btn btn-danger" value="Borrar">
			</div>

		</form:form>
		<br>

		<p>
			Mensaje del controlador:
			<c:out value="${miModelo.mensaje}" />
		</p>
		<br> <a class="btn btn-danger"
			href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a> <br>
			<br>
	</div>



</body>
</html>
<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>BorrarAlumnos</title>
<script language="JavaScript">
	function pregunta() {
		if (confirm('¿Estas seguro de borrar este usuario?')) {
			document.insertAlm.submit()
		}
	}
</script>
</head>
<body>
	<h1>Lista de alumnos</h1>

	<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
      Id (<c:out value="${alumno.id_alumno}" />) 
      Nombre (<c:out value="${alumno.nombre}" />) 
      Apellidos (<c:out value="${alumno.apellidos}" />)  
      <br>
		<br>
	</c:forEach>

	<form:form name="insertAlm" method="POST" action="borrarAlum"
		modelAttribute="alumnoV">
		<table>
			<tr>
				<p>Introduce el id del alumno a eliminar</p>
				<select name="id_alumno">

					<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
						<option><c:out value="${alumno.id_alumno}" /></option>
					</c:forEach>
				</select>
			</tr>
			<tr>
				<td><input onclick="pregunta()" type="submit" value="Borrar" /></td>
			</tr>
		</table>
	</form:form>
	<p>
		Mensaje del controlador:
		<c:out value="${miModelo.mensaje}" />
	</p>

	<a href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a>
</body>
</html>
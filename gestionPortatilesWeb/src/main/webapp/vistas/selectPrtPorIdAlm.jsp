<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>SeleccionarPortatil</title>
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

	<form:form method="POST" action="buscarPortatil"
		modelAttribute="alumnoV">
		<table>
			<tr>
				<p>Introduce el id del alumno para mostrar su portatil</p>
				<select name="id_alumno">

					<c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
						<option><c:out value="${alumno.id_alumno}" /></option>
					</c:forEach>
				</select>
			</tr>

			<tr>
				<td><input type="submit" value="Buscar" /></td>
			</tr>
		</table>
	</form:form>
	<p>
		<c:out value="${miModelo.mensaje}" />
	</p>

	<a href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a>
</body>
</html>
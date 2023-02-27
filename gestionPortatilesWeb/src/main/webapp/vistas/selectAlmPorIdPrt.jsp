<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>SeleccionarAlumno</title>
</head>
<body>
	<h1>Lista de Portatiles</h1>

	<c:forEach items="${miModelo.listaPortatilesDTO2}" var="portatil">
      Id (<c:out value="${portatil.id_ordenador}" />) 
      Modelo (<c:out value="${portatil.modelo}" />) 
      Marca (<c:out value="${portatil.marca}" />)  
      <br>
		<br>
	</c:forEach>

	<form:form method="POST" action="buscarAlumno"
		modelAttribute="portatilV">
		<table>
			<tr>
				<p>Introduce el id del portatil para mostrar su alumno</p>
				<select name="id_ordenador">

					<c:forEach items="${miModelo.listaPortatilesDTO2}" var="portatil">
						<option><c:out value="${portatil.id_ordenador}" /></option>
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
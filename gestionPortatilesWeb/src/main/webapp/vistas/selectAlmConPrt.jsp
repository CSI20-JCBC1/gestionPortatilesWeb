<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>AlumnosConPortatil</title>
</head>
<body>
	<h1>Alumnos con su portatil</h1>

	<c:forEach items="${miModelo.listaAlumnosDTO}" var="alum">
		<c:out value="${alum}" />

		<br>
		<br>
	</c:forEach>

	<a href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a>
</body>
</html>
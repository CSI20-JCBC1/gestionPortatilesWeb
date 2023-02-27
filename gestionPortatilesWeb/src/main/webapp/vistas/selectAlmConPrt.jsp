<%@ include file="/vistas/cabecera.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>AlumnosConPortatil</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
<div class="text-center container w-50 mt-3">
	<h1>Alumnos con su portatil</h1>

	<c:forEach items="${miModelo.listaAlumnosDTO}" var="alum">
		<c:out value="${alum}" />

		<br>
		<br>
	</c:forEach>

	<a class="btn btn-success"
			href="<c:url value="../gestionPortatilesWeb"/>"> Volver al menu</a> <br>
	</div>
</body>
</html>
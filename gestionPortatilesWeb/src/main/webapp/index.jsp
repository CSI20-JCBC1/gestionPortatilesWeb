<%@ include file="/vistas/cabecera.jsp" %>


<html>
<head>
<title>AccesoEjemploWeb</title>
</head>
<body>
	<h1>APP Gestión Alumnos y portatiles</h1>
	<p>Opciones</p>
	<a href="<c:url value="navegacionFormularioPrt"/>">1) Insertar portatil</a>
	<br>
	<a href="<c:url value="selectAlmConPrt"/>">2) Listar alumno con su portatil</a>
	<br>
	<a href="<c:url value="navegacionFormularioAlm"/>">3) Insertar alumno</a>
</body>
</html>
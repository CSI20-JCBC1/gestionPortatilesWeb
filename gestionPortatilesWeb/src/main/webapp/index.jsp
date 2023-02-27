<%@ include file="/vistas/cabecera.jsp" %>


<html>
<head>
<title>AccesoEjemploWeb</title>
</head>
<body>
	<h1>APP Gestión Alumnos y portatiles</h1>
	<p>Opciones</p>
	1)<a href="<c:url value="navegacionFormularioAlm"/>"> Insertar alumno</a>
	<br>
	2)<a href="<c:url value="navegacionFormularioPrt"/>"> Insertar portatil</a>	
	<br>
	3)<a href="<c:url value="selectAlmConPrt"/>"> Listar alumnos con su portatil</a>
	<br>
	4)<a href="<c:url value="borrarAlumno"/>"> Borrar alumno</a>
	<br>
	5)<a href="<c:url value="navegacionFormularioPortatilPorIdAlumno"/>"> Buscar portatil por Id alumno</a>
	<br>
	6)<a href="<c:url value="navegacionFormularioAlumnoPorIdPortatil"/>"> Buscar alumno por Id portatil</a>
	
</body>
</html>
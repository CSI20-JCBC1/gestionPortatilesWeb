<%@ include file="/vistas/cabecera.jsp" %>


<html>
<head>
<title>AccesoEjemploWeb</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<style type="text/css">
	body{
    background-image: url(https://images.pexels.com/photos/3184454/pexels-photo-3184454.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1);
    background-size: cover;
  background-repeat:no-repeat;
  background-position: center center;
}
	</style>
</head>
<body>
     <nav>
        <ul>
            <li><a class="btn btn-primary"href="<c:url value="navegacionRegistroUsu"/>"> Registro</a></li>
            <li><a class="btn btn-primary"href="<c:url value="navegacionLoginUsu"/>"> Login</a></li>
        </ul>
    </nav>
    <div class="text-center container w-50 mt-3">
	<h1 class="alert alert-secondary">APP Gestión Alumnos y portatiles</h1>
	<h3 class="alert alert-secondary">Opciones</h3>
	<br>
	<a class="btn btn-primary"href="<c:url value="navegacionFormularioAlm"/>"> 1 Insertar alumno</a>
	<br>
	<br>
	<a class="btn btn-secondary" href="<c:url value="navegacionFormularioPrt"/>"> 2 Insertar portatil</a>	
	<br>
	<br>
	<a class="btn btn-success" href="<c:url value="selectAlmConPrt"/>"> 3 Listar alumnos con su portatil</a>
	<br>
	<br>
	<a class="btn btn-danger" href="<c:url value="borrarAlumno"/>"> 4 Borrar alumno</a>
	<br>
	<br>
	<a class="btn btn-warning" href="<c:url value="navegacionFormularioPortatilPorIdAlumno"/>"> 5 Buscar portatil por Id alumno</a>
	<br>
	<br>
	<a class="btn btn-dark" href="<c:url value="navegacionFormularioAlumnoPorIdPortatil"/>"> 6 Buscar alumno por Id portatil</a>
	</div>
</body>
</html>
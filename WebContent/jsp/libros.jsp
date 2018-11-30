<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta los libros</title>
</head>
<body>
	<h1>Listado de la tabla "libros"</h1>
	<ul>

		<c:forEach items="${libros}" var="libro">

			<li>${libro.getTitulo() }</li>

			<li>${libro.precio}</li>

			<li>${libro["autor"]}</li>

		</c:forEach>
	</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
background-image: url("https://img.freepik.com/photos-premium/concept-preparation-aux-examens-tests_185193-78716.jpg?w=2000");
 }
</style>
</head>
<body>
<div align="center">
<h1>Les etudiants inscrits</h1>
<table border="1">
			<tr>
				<th>ID</th>
				<th>Email</th>
				<th>Nom</th>
				<th>Prenom</th>
			</tr>
			<c:forEach items="${listeEtudiants}" var="cp">
				<tr>
				    <td>${cp.getId() }</td>
					<td>${cp.getEmail()}</td>
					<td>${cp.getNom()}</td>
					<td>${cp.getPrenom()}</td>

				</tr>
			</c:forEach>
		</table>
</div>
</body>
</html>
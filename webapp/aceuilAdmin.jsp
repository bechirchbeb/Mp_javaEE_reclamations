<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
body {
background-image: url("https://img.freepik.com/photos-premium/concept-preparation-aux-examens-tests_185193-78716.jpg?w=2000");
 

}
.btn { 
display: inline-block;
  color:bleu;
  border-radius: 10px;
  border: 4px double #cccccc;
  text-align: center;
  font-size: 20px;
  padding:  10px;
}
h1
{  
font-size: 50px;
}

</style>
</head>
<body>
<div align="center">
<h1>welcome mr admin</h1>
<form  action="AjoutAdministrateur">
<input type="submit" class="btn" value="Ajouter un Admin" name="action" />
</form>
<br>
<form  action="AjoutTypereclamation">
<input type="submit"  class="btn" value="Ajouter un type de reclamation" name="action" />
</form>
<br>
<form  action="AfficherRec">
<input type="submit" class="btn" value="Afficher les reclamations" name="action" />
</form>
<br>
<form  action="AfficherEtud">
<input type="submit"  class="btn" value="Afficher les etudiants" name="action" />
</form>
<br>
<form  action="Activer">
<input type="submit" class="btn" value="Activer ou desactiver un compte" name="action" />
</form>
</div>

</body>
</html>
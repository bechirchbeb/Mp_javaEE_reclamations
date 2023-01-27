<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
body {
  font-family: 'Lato', sans-serif;
  color: #4A4A4A;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  overflow: hidden;
  margin: 0;
  padding: 0;
}

form {
  width: 350px;
  position: relative;
}
form .form-field::before {
  font-size: 20px;
  position: absolute;
  left: 15px;
  top: 17px;
  color: #888888;
  content: " ";
  display: block;
  background-size: cover;
  background-repeat: no-repeat;
}
form .form-field:nth-child(1)::before {
  width: 20px;
  height: 20px;
  top: 15px;
}
form .form-field:nth-child(2)::before {
  width: 16px;
  height: 16px;
}
form .form-field {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-pack: justify;
  -ms-flex-pack: justify;
  justify-content: space-between;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  margin-bottom: 1rem;
  position: relative;
}
form input {
  font-family: inherit;
  width: 100%;
  outline: none;
  background-color: #fff;
  border-radius: 4px;
  border: none;
  display: block;
  padding: 0.9rem 0.7rem;
  box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.16);
  font-size: 17px;
  color: #4A4A4A;
  text-indent: 40px;
}
form .btn {
  outline: none;
  border: none;
  cursor: pointer;
  display: inline-block;
  margin: 0 auto;
  padding: 0.9rem 2.5rem;
  text-align: center;
  background-color: #47AB11;
  color: #fff;
  border-radius: 4px;
  box-shadow: 0px 3px 6px rgba(0, 0, 0, 0.16);
  font-size: 17px;
}
#bg {
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  filter: blur(5px);
}

</style>
</head>
<body>
<div id="bg"></div>
<br>
<div Align="center">
    <h1>Ajouter un Etudiant</h1>
    <form method="POST" action="AjoutEtudiant">
    <div  class="form-field">
   <input type="number" placeholder="Id" name="id" required="required"/>  <br>  <br>   
   </div>
   <div  class="form-field">     
         <input type="text" placeholder="Email" name="email" size="20" />   <br>  <br>  
   </div>
   <div  class="form-field">
          <input type="password" placeholder="Password"  name="password" size="20" />  <br>   <br>    
    </div>
    <div  class="form-field">
          <input type="text" placeholder="Nom" name="nom" size="20" /> <br><br>
   </div>
   <div  class="form-field"> 
        <input type="text" placeholder="Prenom" name="prenom" size="20" /> <br><br>
   </div>
   <div  class="form-field">   
              <input class="btn"  type="submit" value="ajouter" name="action" />
              <input type="reset" value="Reset" name="reset" />
   </div>   
    </form>
</div>

</body>
</html>
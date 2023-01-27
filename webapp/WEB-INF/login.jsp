<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  background-image: url(https://upload.wikimedia.org/wikipedia/commons/9/99/Sample_User_Icon.png);
  width: 20px;
  height: 20px;
  top: 15px;
}
form .form-field:nth-child(2)::before {
  background-image: url(data:image/png;base64,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);
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
  background-image: url('https://media.istockphoto.com/id/1140524542/photo/were-laughing-a-new-website.jpg?s=612x612&w=0&k=20&c=bCnLYqg6VpBX0_Zz1OFlrjUQwEJzZjTg6ewzPzrL-j4=');
  position: fixed;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-size: cover;
  filter: blur(5px);
}
a{   
color:red;
}

</style>
</head>
<body>
<div id="bg"></div>
<div Align="center">
    <h1>Login Etudiant</h1>
    <form method="post" action="LogEtud">
       <div class="form-field">
        <input type="text" placeholder="Email / Username" name="email" size="20" />   <br>  <br>  
       </div >
       <div class="form-field">
       <input type="password" placeholder="Password" name="password" size="20" />  <br>   <br>      
       </div>
       <div class="form-field">
              <input type="submit" class="btn"   value="Login" name="action" />
       </div>
        <a href="http://localhost:8080/projetV2/AjoutEtudiant"> si vous n'êtes pas encore inscrit creer un compte </a>
    </form>
</div>

</body>
</html>
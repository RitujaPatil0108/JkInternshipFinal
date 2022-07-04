<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
<%
		System.out.println("isadminlogin");
        response.setHeader("Cache-Control","no-cache");
          response.setHeader("Cache-Control","no-store");
          response.setHeader("Pragma","no-cache");
          response.setDateHeader("Expires", 0);

          if(session.getAttribute("isadminlogin")!=null)
          {
              response.sendRedirect("/Web_Repo/adminView");
          }
%>

          <nav id="navv" class="navbar navbar-dark navbar-expand-lg" style="background-color: #0E75EB">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
    <!-- Article: https://www.labnol.org/internet/embed-google-photos-in-website/29194/#:~:text=Go%20to%20photos.google.com,code%20for%20your%20selected%20picture.
    website: https://www.labnol.org/embed/google/photos/
     -->
      <img src="https://lh3.googleusercontent.com/peJKs3OoK2Y9mISBgNS8tI8Jb5XOPK8w095Un_BAG4pLfdhgtxSyfbSlbXE2_FcowYTk2IErDdFL12Xb6JAVoitKw9KXVtz7o0hg-ZZGdJbX67icNd9nHEyJZgF5uISiVA1diY6RfA=s180-p-k"  width="50px" >
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="h"> Home </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="http://www.jkorg.in/index.php/image-gallery" target=”_blank”> Gallery </a>
        </li>
        <li class="nav-item">
        
      </ul>
      
      <ul class="navbar-nav ms-auto">
        
      </ul>
      <br>
      <br>
    </div>
  </div>
</nav>
<!-- _______________________________________NAVBAR________________________________________________ -->

	
	
<form action="validateAdmin" modelAttribute="adminPOJO">
   <div class="con">
   <header class="head-form">
      <h2>Log In</h2>
   </header>
   <br>
   <div class="field-set">
     <br>
      <!--   user name -->
         <span class="input-item">
           <i class="fa fa-user-circle"></i>
         </span>
        <!--   user name Input-->
         <input class="form-input" id="txt-input" type="text" name="username" placeholder="Username" required>
     
      <br><br>
     
           <!--   Password -->
     
      <span class="input-item">
        <i class="fa fa-key"></i>
       </span>
      <!--   Password Input-->
      <input class="form-input" type="password" placeholder="Password" id="pwd"  name="pass" required>
     
      <br>
<!--      button LogIn -->
      <button class="log-in"> Log In </button>
      <h2 style="color: red; font-size: 15px;">${wrong}</h2>
      <h2 style="color: green; font-size: 15px;">${update}</h2>
      <a href="changePassword" >Change Password </a>
   </div>
     </div>
  </form>
  
  <img src="https://lh3.googleusercontent.com/nOdUTr_4Td6adJWra6rltcqZHdZUpzYeFDpGwMbiS0dj_IaAIj53bpgRGAf0KXpqwYLqZTQEC9N9ehqUTqJGAJOLVPuSJ2PhGHajQknCpAiJ0dOFMH_L7ULkFy_Q39sQul2d-3KjhQ=w2400"  class="img-fluid" alt="Sample image" width=700px>

   
</body>
<style>
*
{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
body 
{
    background-color: #2397F5;
    background-attachment: fixed;
    background-repeat: no-repeat;
    font-family: 'Vibur', cursive;
    font-family: 'Abel', sans-serif;
    opacity: .95;
}
form 
{
    position: absolute;
    right: 150px;
    width: 325px;
    min-height: 400px;
    height: 450px;
    border-radius: 10px;
    margin: 2% auto;
    box-shadow: 10px 9px 50px hsla(20, 67%, 75%, 0.31);
    padding: 2%;
    background-image: linear-gradient(-225deg, #C5DBEC 100%, #FFE6FA 0%);
}
form .con 
{
    display: -webkit-flex;
    display: flex;
  
    -webkit-justify-content: space-around;
    justify-content: space-around;
  
    -webkit-flex-wrap: wrap;
    flex-wrap: wrap;
  
      margin: 0 auto;
}
header 
{
    margin: 2% auto 10% auto;
    text-align: center;
}
header h2 
{
    font-size: 250%;
    font-family: 'Playfair Display', serif;
    color: #3e403f;
}
header p {letter-spacing: 0.05em;}
.input-item 
{
    background: #fff;
    color: #333;
    padding: 14.5px 0px 15px 9px;
    border-radius: 5px 0px 0px 5px;
}

input[class="form-input"]
{
    width: 250px;
    height: 50px;
  
    margin-top: -3%;
    padding: 12px;
    
    font-size: 16px;
    font-family: 'Abel', sans-serif;
    color: #5E6472;
  
    outline: none;
    border: none;
  
    border-radius: 0px 5px 5px 0px;
    transition: 0.2s linear;
    
}
input:focus 
{
    transform: translateX(-2px);
    border-radius: 5px;
}

button 
{
    display: inline-block;
    color: #fff;
  
    width: 250px;
    height: 50px;
  
    padding: 0 20px;
    background: #2397F5;
    border-radius: 5px;
    
    outline: none;
    border: none;
  
    cursor: pointer;
    text-align: center;
    transition: all 0.2s linear;
    
    margin: 15% auto;
    letter-spacing: 0.05em;
}
.submits 
{
    width: 48%;
    display: inline-block;
    float: left;
    margin-left: 2%;
}
button:hover 
{
    transform: translatey(3px);
    box-shadow: none;
}
button:hover 
{
    animation: ani9 0.4s ease-in-out infinite alternate;
}
@keyframes ani9 
{
    0% 
    {
        transform: translateY(3px);
    }
    100% 
    {
        transform: translateY(5px);
    }
}


.one
{
width: 30%;
border-style: solid red;
}
.fluid
{
text-align: center;
}
.img-fluid
{
margin-left: 90px;
margin-top:1rem;
margin-bottom:5rem;
width: 45%;
border-radius: 75px;
transform-style: preserve-3d;
perspective: 500px;
  -webkit-filter: drop-shadow(10px 10px 10px #222);
  filter: drop-shadow(10px 10px 10px #222);
  opacity: 85%;
}
</style>
</html>
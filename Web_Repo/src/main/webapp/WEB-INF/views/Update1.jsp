<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Update</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
    <div class="area" >
            <ul class="circles">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
            </ul>
    </div >
   
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
      </ul>
      
     <ul class="navbar-nav ms-auto">
      <li class="nav-item">
                  <a style="color: white;" class="nav-link btn btn-sm btn-danger float-right" href="logout" >Logout</a>
      </li>
      
      </ul>

      <br>
      <br>
    </div>
  </div>
</nav>
<!-- _______________________________________NAVBAR________________________________________________ -->

    <div class="form-body">
        <div class="row">
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Edit Department Details</h3>
                        <p>Fill in the data below.</p>
    <div align="center">
	<form:form action="processUpdate" method="post" modelAttribute="functionPOJO" >
	
	   
	
		<div class="col-md-12">
	    <form:input type="text" path="id" class="notvisible"/>
			
		<label for="title"> <strong>Department Function Name</strong></label>
		<form:input class="form-control" type="text" path="title"  placeholder="Add Department Function"/> <br>
		<form:errors path="title" cssClass="errors"/> <br>
		
		<label for="description"> <strong> Department Description </strong> </label>
		<form:textarea class="form-control" type="text" path="description" placeholder="Add Function Description" /> <br>
		<form:errors path="description" cssClass="errors"/>
		
		</div>
		
		 <div class="form-button mt-3">
         <input id="submit" class="btn btn-primary" type="submit" value="Update">
         </div>
	</form:form>
	</div>
	</div>
                </div>
            </div>
        </div>
    </div>
	
	<!-- _______________________________________FORM________________________________________________ -->
	
	<div class="footer">
        <footer>
            <div class="social"><a href="https://www.instagram.com/jkpaperindia/" target=”_blank”><i class="fa fa-instagram"></i></a>
                                <a href="https://www.linkedin.com/company/jk-paper-ltd.?trk=extra_biz_viewers_viewed" target=”_blank”><i class="fa fa-linkedin"></i></a>
                                <a href="https://twitter.com/jkpaperindia" target=”_blank”><i class="fa fa-twitter"></i></a>
                                <a href="https://www.facebook.com/#!/pages/JK-Paper-Ltd/165369376861315" target=”_blank”><i class="fa fa-facebook"></i></a>
                                <a href="https://www.youtube.com/channel/UCWproPZLnSSk7jQwewqpoNA" target=”_blank”><i class="fa fa-youtube"></i></a>
            </div>
            <ul class="list-inline">
                <li class="list-inline-item"><a href="h">Home</a> </li>
                <li class="list-inline-item"><a href="https://www.jkpaper.com/corporate/about-us.html" target=”_blank”>About Us</a></li>
                <li class="list-inline-item"><a href="http://www.jkorg.in/index.php/papri">R&D</a></li>
                <li class="list-inline-item"><a href="https://www.jkpaper.com/contact-us.html" target=”_blank">Contact Us</a></li>
            </ul>
            <p class="copyright"> 2022 JK Paper - All Rights Reserved </p>
        </footer>
    </div>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
	
	<!-- _______________________________________FOOTER________________________________________________ -->

<style>
*, body 
{
   font-family: 'Abel', sans-serif;
    font-weight: 400;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    -moz-osx-font-smoothing: grayscale;
}

body,html 
{
  background: #2397F5;
}

.circles
{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    overflow: hidden;
    
}

.circles li
{
    position: absolute;
    display: block;
    list-style: none;
    width: 20px;
    height: 20px;
    background: rgba(255, 255, 255, 0.2);
    animation: animate 25s linear infinite;
    bottom: -150px;   
}

.circles li:nth-child(1){
    left: 25%;
    width: 80px;
    height: 80px;
    animation-delay: 0s;
}


.circles li:nth-child(2){
    left: 10%;
    width: 30px;
    height: 30px;
    animation-delay: 2s;
    animation-duration: 12s;
}

.circles li:nth-child(3){
    left: 70%;
    width: 25px;
    height: 25px;
    animation-delay: 4s;
}

.circles li:nth-child(4){
    left: 40%;
    width: 60px;
    height: 60px;
    animation-delay: 0s;
    animation-duration: 18s;
}

.circles li:nth-child(5){
    left: 65%;
    width: 40px;
    height: 40px;
    animation-delay: 0s;
}

.circles li:nth-child(6){
    left: 75%;
    width: 110px;
    height: 110px;
    animation-delay: 3s;
}

.circles li:nth-child(7){
    left: 35%;
    width: 150px;
    height: 150px;
    animation-delay: 7s;
}

.circles li:nth-child(8){
    left: 50%;
    width: 25px;
    height: 25px;
    animation-delay: 15s;
    animation-duration: 45s;
}

.circles li:nth-child(9){
    left: 20%;
    width: 20px;
    height: 20px;
    animation-delay: 2s;
    animation-duration: 35s;
}

.circles li:nth-child(10){
    left: 85%;
    width: 150px;
    height: 150px;
    animation-delay: 0s;
    animation-duration: 11s;
}
.circles li:nth-child(11){
    left: 25%;
    width: 80px;
    height: 80px;
    animation-delay: 0s;
}


.circles li:nth-child(12){
    left: 10%;
    width: 30px;
    height: 30px;
    animation-delay: 2s;
    animation-duration: 12s;
}

.circles li:nth-child(13){
    left: 70%;
    width: 25px;
    height: 25px;
    animation-delay: 4s;
}

.circles li:nth-child(14){
    left: 40%;
    width: 60px;
    height: 60px;
    animation-delay: 0s;
    animation-duration: 18s;
}

.circles li:nth-child(15){
    left: 65%;
    width: 40px;
    height: 40px;
    animation-delay: 0s;
}

.circles li:nth-child(16){
    left: 75%;
    width: 110px;
    height: 110px;
    animation-delay: 3s;
}

.circles li:nth-child(17){
    left: 35%;
    width: 150px;
    height: 150px;
    animation-delay: 7s;
}

.circles li:nth-child(18){
    left: 50%;
    width: 25px;
    height: 25px;
    animation-delay: 15s;
    animation-duration: 45s;
}

.circles li:nth-child(19){
    left: 20%;
    width: 20px;
    height: 20px;
    animation-delay: 2s;
    animation-duration: 35s;
}

.circles li:nth-child(20){
    left: 85%;
    width: 150px;
    height: 150px;
    animation-delay: 0s;
    animation-duration: 11s;
}



@keyframes animate {

    0%{
        transform: translateY(0) rotate(0deg);
        opacity: 1;
        border-radius: 0;
    }

    100%{
        transform: translateY(-1000px) rotate(720deg);
        opacity: 0;
        border-radius: 50%;
    }

}
.form-holder 
{
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
      min-height: 100vh;
}

.form-holder .form-content 
{
    position: relative;
    text-align: center;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 30px;
}

.form-content .form-items 
{
    border: 3px solid #fff;
    padding: 40px;
    display: inline-block;
    width: 100%;
    min-width: 500px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    text-align: left;
    -webkit-transition: all 0.4s ease;
    transition: all 0.4s ease;
}

.form-content h3 
{
    color: #fff;
    text-align: left;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 5px;
}

.form-content h3.form-title 
{
    margin-bottom: 30px;
}

.form-content p {
    color: #fff;
    text-align: left;
    font-size: 17px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}


.form-content label, .was-validated .form-check-input:invalid~.form-check-label, .was-validated .form-check-input:valid~.form-check-label{
    color: #fff;
}

.form-content input[type=text], .form-content input[type=password], .form-content input[type=email], .form-content select {
    width: 100%;
    padding: 9px 20px;
    text-align: left;
    border: 0;
    outline: 0;
    border-radius: 6px;
    background-color: #fff;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    -webkit-transition: all 0.3s ease;
    transition: all 0.3s ease;
    margin-top: 16px;
}


.btn-primary
{
    background-color: #6C757D;
    outline: none;
    border: 0px;
     box-shadow: none;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active
{
    background-color: #495056;
}

.form-content textarea 
{
    position: static !important;
    width: 100%;
    padding: 8px 20px;
    border-radius: 6px;
    text-align: left;
    background-color: #fff;
    border: 0;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    outline: none;
    resize: none;
    height: 80px;
    -webkit-transition: none;
    transition: none;
    margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus 
{
    border: 0;
    background-color: #ebeff8;
    color: #8D8D8D;
}
.notvisible
{
opacity: 0;
}
.errors
{
color: red;
}
.footer
{
  padding:40px 0;
  background-color:#ffffff;
  color:#4b4c4d;
}

.footer ul 
{
  padding:0;
  list-style:none;
  text-align:center;
  font-size:18px;
  line-height:1.6;
  margin-bottom:0;
}

.footer li {
  padding:0 10px;
}

.footer ul a 
{
  text-decoration:none;
  opacity:0.8;
}

.footer ul a:hover {
  opacity:1;
}

.footer .social {
  text-align:center;
  padding-bottom:25px;
  color: #2397F5;
}

.footer .social > a {
  font-size:24px;
  width:40px;
  height:40px;
  line-height:40px;
  display:inline-block;
  text-align:center;
  border-radius:50%;
  border:1px solid #ccc;
  margin:0 8px;
  color:inherit;
  opacity:0.75;
}

.footer .social > a:hover {
  opacity:0.9;
}

.footer .copyright {
  margin-top:15px;
  text-align:center;
  font-size:13px;
  color: #2397F5;
  margin-bottom:0;
}
</style>
</body>
</html>
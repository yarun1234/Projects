<?php include "connection.php"; ?>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>TOT IRIS</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link href="https://netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		 <link rel="stylesheet" href="admin/css/validationEngine.jquery.css" type="text/css">       
		<style>
			html,body
			{
				overflow-x: hidden;
			}
			.container {
    margin-top: 20px;
}
.navbar-inverse {
    background-color: #990134;
    border-color: #990134;
}
/* Carousel Styles */
.carousel-indicators .active {
    background-color: #2980b9;
}

.carousel-inner img {
    width: 100%;
    max-height: 560px
}

.carousel-control {
    width: 0;
}



#footer
{
	padding: 5px;
	background: #990134;
	color: white
}
h3
{
	font-weight: bold;
}
.navbar-inverse .navbar-nav>.active>a, .navbar-inverse .navbar-nav>.active>a:focus, .navbar-inverse .navbar-nav>.active>a:hover {
    color: #fff!important;
    background-color: #990134!important;
}
.navbar-inverse .navbar-nav>li>a,.navbar-inverse .navbar-brand
{
	color:white!important;
}
.project-support li
{
	margin-bottom: 5px!important;
	font-size: 17px;
}
		</style>
	</head>
	<body>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#"><b>TOT IRIS</b></a>
				</div>
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="index.php">Home</a></li>
					<li><a href="registration.php">Student Registration</a></li>
					<li class="active"><a href="./student">Login</a></li>
					<li><a href="contact.php">Contact Us</a></li>
				</ul>
			</div>
		</nav>
	
<?php 
session_start();
if(isset($_GET['action']) && ($_GET['action'] == 'logout'))
{
  session_destroy();
}
include("connection.php");
if(isset($_SESSION["userid"]))
{
   echo '<script>window.top.location = "dashboard.php"</script>';
}

if(isset($_POST["username"]) && isset($_POST["password"]))
{
//  echo "sdfsd". $_POST[uid];
$result = mysql_query("SELECT * FROM studentdetails WHERE studid='$_POST[username]'");
while($row = mysql_fetch_array($result))
{
$pwdmd5 = $row["pass"];
}
if(md5($_POST["password"])==$pwdmd5)
{
  $_SESSION["userid"] = $_POST["username"];
  //$_SESSION["type"]="admin";
  header("Location: dashboard.php");
}
else
{
$log =  'Invalid Credentials';
}
}
?>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Panel - SIMS</title>
  
  
  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>

      <link rel="stylesheet" href="../admin/css/style.css">

  
</head>

<body>
 <h1>Login Panel</h1>
  <div class="login-form">
   <center> <img src="../admin/dist/img/user.png" style="width:60px; height:auto;" alt="Logo"> </center>
   <br>
   <form action="index.php" method="post">
     <div class="form-group ">
       <input type="text" class="form-control" placeholder="Student ID " id="username" name="username" required>
       <i class="fa fa-user"></i>
     </div>
     <div class="form-group log-status">
       <input type="password" class="form-control" placeholder="Password" id="password" name="password" required>
       <i class="fa fa-lock"></i>
     </div>
     <?php
     if(isset($log))
     { 
      ?>
      <small style="color:red"><?php  echo $log; ?></small>
     <?php
     }
     ?>
     <button type="submit" class="log-btn">Log in</button>
    </form>
    <br>
    <a href="../">Go back to site</a>
   </div>
  
 <script src="../admin/plugins/jQuery/jQuery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $('.log-btn').click(function(){
            $('.log-status').addClass('wrong-entry');
           $('.alert').fadeIn(500);
           setTimeout( "$('.alert').fadeOut(1500);",3000 );
        });
        $('.form-control').keypress(function(){
            $('.log-status').removeClass('wrong-entry');
        });

    });
  
</script>
</body>
</html>

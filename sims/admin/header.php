<?php
session_start();
if(!isset($_SESSION["userid"]))
{
  echo '<script>window.top.location = "index.php"</script>';
} 
include "connection.php"; 
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TOT IRIS</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.4 -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
    folder instead of downloading all of them to reduce the load. -->
    <link href="dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="plugins/iCheck/flat/blue.css" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="plugins/morris/morris.css" rel="stylesheet" type="text/css" />
    <!-- DATA TABLES -->
    <link href="plugins/datatables/dataTables.bootstrap.css" rel="stylesheet" type="text/css" />
    <link href="plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />
    <link href="plugins/iCheck/all.css" rel="stylesheet" type="text/css" />
    <link href="plugins/jQueryUI/jquery-ui.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="plugins/jQuerydatetimepicker/jquery.datetimepicker.css" />
    <link rel="stylesheet" href="css/uploadfiles.css" type="text/css">
    <link rel="stylesheet" href="css/validationEngine.jquery.css" type="text/css">
    <link rel="stylesheet" href="plugins/datatables/dataTables.bootstrap.css" type="text/css">
    <!--.php5 Shim and Respond.js IE8 support of.php5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com.php5shiv/3.7.2.php5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .required {
                color: red;

            }
            .dataTables_length .form-control,.dataTables_filter .form-control
            {
                margin-top:0px!important;
            }

        </style>
    </head>

    <body class="skin-blue sidebar-mini">
        <div class="wrapper">
            <header class="main-header">
                <!-- Logo -->
                <a href="dashboard.php" class="logo">
                    <!-- mini logo for sidebar mini 50x50 pixels -->
                    <span class="logo-mini"><b><i class="fa fa-book"></i></b></span>
                    <!-- logo for regular state and mobile devices -->
                    <span class="logo-lg"><b><i class="fa fa-book"></i>&nbsp;&nbsp;&nbsp;&nbsp; SIMS</b></span>
                </a>
                <!-- Header Navbar: style can be found in header.less -->
                <nav class="navbar navbar-static-top" role="navigation">
                    <!-- Sidebar toggle button-->
                    <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                        <span class="sr-only">Toggle navigation</span>
                    </a>
                    <div class="navbar-custom-menu">
                        <ul class="nav navbar-nav">
                            <li>
                                    <a href="index.php?action=logout" class="btn btn-success btn-flat"><i class="fa fa-sign-out"></i> Sign out</a>
                            </li>
                            <!-- Control Sidebar Toggle Button -->
                        <!--
              <li>
                <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
              </li>
          -->
      </ul>
  </div>
</nav>
</header>
<!-- Left side column. contains the logo and sidebar -->
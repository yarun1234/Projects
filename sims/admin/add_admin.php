<?php 
include "header.php"; 
if(isset($_POST['submitcourse']))
{
  $adminname = $_POST['adminname'];
  $address = $_POST['address'];
  $contactno = $_POST['contactno'];
  $password = md5($_POST['password']);
    if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
    {
        $password = (isValidMd5($_POST['password']))?$_POST['password']: md5($_POST['password']);
        $cid = mysql_real_escape_string($_GET['sid']);
        mysql_query("UPDATE administrator SET adminname='$adminname',  address='$address',  contactno='$contactno',password = '$password' WHERE adminid = '{$cid}'");
        $message = "Update Successfull";
    }
    else
    {
        $sql="INSERT INTO administrator (adminname, address,contactno, password) VALUES ('$adminname','$address','$contactno','$password')";
        if (!mysql_query($sql,$con))
          {
          die('Error: ' . mysql_error());
          }
          else
          {
             echo '<script>window.top.location = "admin.php"</script>';
          }
    }
}
if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
{
$cid = mysql_real_escape_string($_GET['sid']);
$query = mysql_query("SELECT * FROM administrator WHERE adminid = '{$cid}'");
$result = mysql_fetch_assoc($query);
$adminname = $result['adminname'];
$address = $result['address'];
$contactno = $result['contactno'];
$password = $result['password'];
}
else
{
$adminname = '';
$address = '';
$contactno = '';
$password = '';
}
?>

<?php include "sidebar.php"; ?>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
         Admin
         <small>Add Admin</small>
     </h1>
     <ol class="breadcrumb">
        <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
        <li class="active"><a href="add_subject.php">Add Admin</a></li>
    </ol>
</section>
<section class="content">
    <div class="row">
        <!-- left column -->
        <div class="col-md-10">
            <!-- general form elements -->
            <div class="box box-primary">
               <?php 
               if(isset($message))
               {
                 display_message($message);
               }
               ?>
                <!-- form start -->
                <form role="form" method="post" action="" enctype="multipart/form-data">
                    <div class="box-body">
                        <div class="form-group">
                            <div class="col-md-4">
                                <label> Username <span class="required">*</span></label>
                            </div>
                            <?php $readonly = (isset($_GET["view"]) && ($_GET["view"] == "edit"))?"readonly":" "; ?>
                            <div class="col-md-8">
                                <input type="text" id="adminname" name="adminname" value="<?php echo $adminname; ?>" class="form-control validate[required]" maxlength="100" <?php echo $readonly; ?>>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label> Address  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" id="address" name="address" value="<?php echo $address; ?>" class="form-control validate[required]" maxlength="100">
                            </div>
                        </div>
                         <div class="form-group">
                            <div class="col-md-4">
                                <label> Contact No  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" id="contactno" name="contactno" value="<?php echo $contactno; ?>" class="form-control validate[required]" maxlength="100">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label> Password  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="password" id="password" name="password" value="<?php echo $password; ?>" class="form-control validate[required]" maxlength="100">
                            </div>
                        </div>
                        
                    <div class="form-group">
                        <div class="col-md-12">
                            <br>
                                <button type="submit" class="btn btn-success" name="submitcourse">
                                  <?php 
                                  $getaction = (isset($_GET["view"]) && ($_GET["view"] == "edit"))?"Update":" Add Admin";
                                  echo $getaction;
                                  ?>  
                                </button>
                           
                        </div>
                    </div>
                    
                </div>
                <!-- /.box-body -->
            </form>
        </div>
        <!-- /.box -->
    </div>
    <!--/.col (left) -->
</div>
<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->


<?php include "footer.php"; ?>
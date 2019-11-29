<?php 
include "header.php"; 
if(isset($_POST['submitcourse']))
{
    $coursename = $_POST['coursename'];
    $comment = $_POST['comment'];
    $coursekey = $_POST['coursekey'];
    if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
    {
        $cid = mysql_real_escape_string($_GET['sid']);
        mysql_query("UPDATE course SET coursename='$coursename',comment='$comment',coursekey='$coursekey' WHERE courseid = '$cid'");
        $message = "Update Successfull";
    }
    else
    {
        $sql="INSERT INTO course (coursename, comment, coursekey) VALUES('{$coursename}','{$comment}','{$coursekey}')";
        if (!mysql_query($sql,$con))
          {
          die('Error: ' . mysql_error());
          }
          else
          {
             echo '<script>window.top.location = "course.php"</script>';
          }
    }
}
if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
{
$cid = mysql_real_escape_string($_GET['sid']);
$query = mysql_query("SELECT * FROM course WHERE courseid = '{$cid}'");
$result = mysql_fetch_assoc($query);
$courseid = $result['courseid'];
$coursename = $result['coursename'];
$comment = $result['comment'];
$coursekey = $result['coursekey'];
}
else
{
$courseid = '';
$coursename = '';
$comment = '';
$coursekey = '';   
}
?>

<?php include "sidebar.php"; ?>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
         Course
         <small>Add course</small>
     </h1>
     <ol class="breadcrumb">
        <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
        <li class="active"><a href="add_course.php">Add course</a></li>
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
                                <label> Course Name <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" id="coursename" name="coursename" value="<?php echo $coursename; ?>" class="form-control validate[required]" maxlength="100">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label> Comment  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" id="comment" name="comment" value="<?php echo $comment; ?>" class="form-control validate[required]" maxlength="100">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label> Course Key  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" id="coursekey" name="coursekey" value="<?php echo $coursekey; ?>" class="form-control validate[required]" maxlength="100">
                            </div>
                        </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <br>
                                <button type="submit" class="btn btn-success" name="submitcourse">
                                  <?php 
                                  $getaction = (isset($_GET["view"]) && ($_GET["view"] == "edit"))?"Update":" Add Course";
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
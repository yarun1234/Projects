<?php 
include "header.php"; 
if(isset($_POST['submitcourse']))
{
  $subjectname = $_POST['subjectname'];
  $comment = $_POST['comment'];
  $course = $_POST['course'];
  $subjecttype = $_POST['subjecttype'];
  $semester = $_POST['semester'];

    if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
    {
        $cid = mysql_real_escape_string($_GET['sid']);
        mysql_query("UPDATE subject SET subname='$subjectname',  comment='$comment',  courseid='$course',subtype='$subjecttype',  semester='$semester' WHERE subid = '{$cid}'");
        $message = "Update Successfull";
    }
    else
    {
        $sql="INSERT INTO subject (subname, comment, courseid,subtype, semester) VALUES ('$subjectname','$comment','$course','$subjecttype','$semester')";
        if (!mysql_query($sql,$con))
          {
          die('Error: ' . mysql_error());
          }
          else
          {
             echo '<script>window.top.location = "subject.php"</script>';
          }
    }
}
if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
{
$cid = mysql_real_escape_string($_GET['sid']);
$query = mysql_query("SELECT * FROM subject WHERE subid = '{$cid}'");
$result = mysql_fetch_assoc($query);
$subjectname = $result['subname'];
$comment = $result['comment'];
$course = $result['courseid'];
$subjecttype = $result['subtype'];
$semester = $result['semester'];
}
else
{
$subjectname = '';
$comment = '';
$course = '';
$coursubjecttypesekey = '';
$semester = '';   
}
?>

<?php include "sidebar.php"; ?>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
         Subject
         <small>Add Subject</small>
     </h1>
     <ol class="breadcrumb">
        <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
        <li class="active"><a href="add_subject.php">Add Subject</a></li>
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
                                <label> Subject Name <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <input type="text" id="subjectname" name="subjectname" value="<?php echo $subjectname; ?>" class="form-control validate[required]" maxlength="100">
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
                                <label> Course  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <select name="course" id="course" class="form-control validate[required]">
                                   <?php
                                    $result1 = mysql_query("SELECT * FROM course");
                                    while($row1 = mysql_fetch_array($result1))
                                    {
                                    if($courseid  == $row1['courseid'])
                                    {
                                      $selvar = "selected";
                                    }
                                    else
                                    {
                                      $selvar = "";
                                    }
                                    echo "<option value='$row1[courseid]' ". $selvar . ">$row1[coursekey]</option>";
                                    $selvar ="";
                                  }
                                  ?>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-4">
                                <label> Subject Type  <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                                <select name="subjecttype" id="subjecttype" class="form-control validate[required]">
                                  <option value="Theory" <?php if($subjecttype  == "theory") echo 'selected'; ?>>Theory</option>
                                  <option value="Lab" <?php if($subjecttype  == "Lab") echo 'selected'; ?>>Lab</option>
                                </select>
                            </div>
                        </div>
                         <div class="form-group">
                            <div class="col-md-4">
                                <label> Semester <span class="required">*</span></label>
                            </div>
                            <div class="col-md-8">
                               <select name="semester" id="semester" class="form-control validate[required]">
                                  <option value="1" <?php if($semester  == "1") echo 'selected'; ?>>First Semester</option>
                                  <option value="2" <?php if($semester  == "2") echo 'selected'; ?>>Second Semester</option>
                                  <option value="3" <?php if($semester  == "3") echo 'selected'; ?>>Third Semester</option>
                                  <option value="4" <?php if($semester  == "4") echo 'selected'; ?>>Fourth Semester</option>
                                  <option value="5" <?php if($semester  == "5") echo 'selected'; ?>>Fifth Semester</option>
                                  <option value="6" <?php if($semester  == "6") echo 'selected'; ?>>Sixth Semester</option>
                                 </select>
                            </div>
                        </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <br>
                                <button type="submit" class="btn btn-success" name="submitcourse">
                                  <?php 
                                  $getaction = (isset($_GET["view"]) && ($_GET["view"] == "edit"))?"Update":" Add Subject";
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
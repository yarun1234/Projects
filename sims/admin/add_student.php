<?php
include "header.php";
if(isset($_POST['submitcourse']))
{
if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
{
$cid = mysql_real_escape_string($_GET['sid']);
$pass = (isValidMd5($_POST['pass']))?$_POST['pass']: md5($_POST['pass']);
mysql_query("UPDATE studentdetails SET studfname='$_POST[studfname]',  studlname='$_POST[studlname]',  fathername='$_POST[fathername]',gender='$_POST[gender]',  address='$_POST[address]',contactno='$_POST[contactno]',courseid='$_POST[courseid]',semester='$_POST[semester]',dob='$_POST[dob]',pass='$pass' WHERE studid = '{$cid}'");
$message = "Update Successfull";
}
}
if(isset($_GET["view"]) && ($_GET["view"] == "edit"))
{
$cid = mysql_real_escape_string($_GET['sid']);
$query = mysql_query("SELECT * FROM studentdetails WHERE studid = '{$cid}'");
$row1 = mysql_fetch_assoc($query);
$studid = $row1["studid"];
$studfname = $row1["studfname"];
$studlname = $row1["studlname"];
$dob = $row1["dob"];
$fathername = $row1["fathername"];
$address = $row1["address"];
$contactno = $row1["contactno"];
$courseid  = $row1["courseid"];
$semester  = $row1["semester"];
$gender= $row1["gender"];
$pass = $row1["pass"];
}
else
{
$studid = '';
$studfname = '';
$studlname = '';
$dob = '';
$fathername = '';
$address = '';
$contactno = '';
$courseid = '';
$semester = '';
$gender = '';
$pass = '';
}
?>
<?php include "sidebar.php"; ?>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <h1>
    Student
    <small>Update Student</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
      <li class="active"><a href="add_student.php">Update Student</a></li>
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
          <form name="form1" method="post" action="">
            <div class="box-body">
              <div class="form-group">
                <div class="col-md-4">
                  <label>
                    First Name (required)
                  </label>
                </div>
                <div class="col-md-8">
                  <input name="studfname" id="studfname" size="22" type="text" value="<?php echo $studfname; ?>" class="validate[required,custom[onlyLetterSp]] form-control">
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-4">
                  <label>
                    Last Name (required)
                  </label>
                </div>
                <div class="col-md-8">
                  <input name="studlname" id="studlname" size="22" type="text" value="<?php echo $studlname; ?>" class="validate[required,custom[onlyLetterSp]] form-control">
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-4">
                  <label>
                    Father's Name (required)
                  </label>
                </div>
                <div class="col-md-8">
                  <input name="fathername" id="fathername" value="<?php echo $fathername; ?>"  size="22" type="text" class="validate[required,custom[onlyLetterSp]] form-control">
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-4">
                  <label for="url">
                    Gender
                  </label>
                </div>
                <div class="col-md-8">
                  <select name="gender" class="form-control" id="gender">
                    <option value="male" <?php if($gender  == "male") echo 'selected'; ?>>Male</option>
                    <option value="female" <?php if($gender  == "female") echo 'selected'; ?>>Female</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-4">
                  <label>Address</label>
                </div>
                <div class="col-md-8">
                  <textarea name="address" id="address" class="validate[required] form-control" cols="50" style="height: 80px"><?php echo $address; ?></textarea>
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-4">
                  <label for="textfield6">Contact No</label>
                </div>
                <div class="col-md-8">
                  <input type="text" value="<?php echo $contactno; ?>" name="contactno" id="contactno" class="validate[required] form-control">
                </div>
              </div>
              <div class="form-group">
                <div class="col-md-4">
                  <label for="textfield7">Course </label>
                </div>
                <div class="col-md-8">
                  <select name="courseid" class="form-control">
                    <option value="">Course Details</option>
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
                  <label for="textfield8">Semester</label>
                </div>
                <div class="col-md-8">
                  <select name="semester" id="select" class="form-control">
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
                <div class="col-md-4">
                  <label for="textfield4">Date of Birth</label>
                </div>
                <div class="col-md-8">
                  <input type="date" value="<?php echo $dob; ?>" name="dob" id="textdob" maxlength="25" size="25" class="validate[required,[date]] form-control text-input">
                </div>
              </div>
               <div class="form-group">
                <div class="col-md-4">
                  <label for="textfield4">Password</label>
                </div>
                <div class="col-md-8">
                  <input type="password" value="<?php echo $pass; ?>" name="pass" id="pass" class="validate[required] form-control text-input">
                </div>
              </div>
              <br>
              <div class="form-group">
                 <div class="col-md-4">
                <input name="submitcourse" id="submit" tabindex="5" type="submit" class="btn btn-success" value="Update">
              </div>
              </div>
              <div class="clear"></div>
            </div>
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
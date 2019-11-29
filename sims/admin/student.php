<?php 
include "header.php"; 
if($_GET["view"] == "delete")
{
mysql_query("DELETE FROM studentdetails WHERE studid = '$_GET[sid]'");
}
?>

<?php include "sidebar.php"; ?>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Students
        </h1>
        <ol class="breadcrumb">
          <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
          <li class="active"><a href="#">Students</a></li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">Students list</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="box-body table-responsive no-padding">
                    <table id="example1" class="table table-bordered  table-striped">
                      <thead>
                       <tr>
                          <th>S No.</th>
                          <th>Student Id</th>
                          <th>Student Name</th>
                          <th>Father Name</th>
                          <th>Gender</th>
                          <th>Address</th>
                          <th>Contact No.</th>
                          <th>Course</th>
                          <th>Semester</th>
                          <th>DOB</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        <?php 
                        $result = mysql_query("SELECT * FROM studentdetails as a INNER JOIN course as b on a.courseid = b.courseid"); 
                        $count = 0;
                        while($row = mysql_fetch_array($result))
                        {
                        ?>
                        <tr id="rowID1">
                          <td><?php echo ++$count; ?></td>
                          <td><?php echo $row['studid']; ?></td>
                          <td><?php echo $row['studfname']." ".$row['studlname']; ?></td>
                          <td><?php echo $row['fathername']; ?></td>
                          <td><?php echo $row['gender']; ?></td>
                          <td><?php echo $row['address']; ?></td>
                          <td><?php echo $row['contactno']; ?></td>
                          <td><?php echo $row['coursename']; ?></td>
                          <td><?php echo $row['semester']; ?></td>
                          <td><?php echo $row['dob']; ?></td>
                          <td>
                            <a data-toggle="tooltip" data-original-title="Edit" href="add_student.php?view=edit&sid=<?php echo $row['studid']; ?>"  class="btn btn-success btn-xs"><i class="fa fa-pencil"></i></a>
                            <a href="student.php?view=delete&sid=<?php echo $row['studid']; ?>" data-toggle="tooltip" data-original-title="Delete"  class="btn btn-success btn-xs"><i class="fa fa-trash"></i></a>
                          </td>
                        </tr>
                      <?php } ?>
                      </tbody>
                    </table>
                  </div>
                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div>
            <input type="hidden" name="max" id="max" value="9">
          </div><!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
  <?php include "footer.php"; ?>
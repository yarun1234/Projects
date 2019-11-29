<?php 
include "header.php"; 
if($_GET["view"] == "delete")
{
mysql_query("DELETE FROM course WHERE courseid ='$_GET[sid]'");
}
?>

<?php include "sidebar.php"; ?>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Course
        </h1>
        <ol class="breadcrumb">
          <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
          <li class="active"><a href="#">Course</a></li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">Course list</h3>
                <div style="float:right">
                  <a href="add_course.php"  data-toggle="tooltip" data-original-title="Add New"  class="btn btn-success btn-sm"><i class="fa fa-plus"></i> Add New</a>  </div>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="box-body table-responsive no-padding">
                    <table id="example1" class="table table-bordered  table-striped">
                      <thead>
                       <tr>
                          <th>S No.</th>
                          <th>Course Name</th>
                          <th>Course Details</th>
                          <th>Course key</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        <?php 
                        $result = mysql_query("SELECT * FROM course"); 
                        $count = 0;
                        while($row = mysql_fetch_array($result))
                        {
                        ?>
                        <tr id="rowID1">
                          <td><?php echo ++$count; ?></td>
                          <td><?php echo $row['coursename']; ?></td>
                          <td><?php echo $row['comment']; ?></td>
                          <td><?php echo $row['coursekey']; ?></td>
                          
                          <td>
                            <a data-toggle="tooltip" data-original-title="Edit" href="add_course.php?view=edit&sid=<?php echo $row['courseid']; ?>"  class="btn btn-success btn-xs"><i class="fa fa-pencil"></i></a>
                            <a href="course.php?view=delete&sid=<?php echo $row['courseid']; ?>" data-toggle="tooltip" data-original-title="Delete"  class="btn btn-success btn-xs"><i class="fa fa-trash"></i></a>
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
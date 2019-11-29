<?php 
include "header.php"; 
if($_GET["view"] == "delete")
{
mysql_query("DELETE FROM subject WHERE subid = '$_GET[sid]'");
}
?>

<?php include "sidebar.php"; ?>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Subject
        </h1>
        <ol class="breadcrumb">
          <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
          <li class="active"><a href="#">Subject</a></li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">Subject list</h3>
                <div style="float:right">
                  <a href="add_subject.php"  data-toggle="tooltip" data-original-title="Add New"  class="btn btn-success btn-sm"><i class="fa fa-plus"></i> Add New</a>  </div>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="box-body table-responsive no-padding">
                    <table id="example1" class="table table-bordered  table-striped">
                      <thead>
                       <tr>
                          <th>S No.</th>
                          <th>Subject ID</th>
                          <th>Subject Name</th>
                          <th>Subject Details</th>
                          <th>Subject Type</th>
                          <th>Semester</th>
                          <th>Course Name</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        <?php 
                        $result = mysql_query("SELECT * FROM subject as a INNER JOIN course as b on a.courseid = b.courseid"); 
                        $count = 0;
                        while($row = mysql_fetch_array($result))
                        {
                        ?>
                        <tr id="rowID1">
                          <td><?php echo ++$count; ?></td>
                          <td><?php echo $row['subid']; ?></td>
                          <td><?php echo $row['subname']; ?></td>
                          <td><?php echo $row['comment']; ?></td>
                          <td><?php echo $row['subtype']; ?></td>
                          <td><?php echo $row['semester']; ?></td>
                          <td><?php echo $row['coursename']; ?></td>
                          <td>
                            <a data-toggle="tooltip" data-original-title="Edit" href="add_subject.php?view=edit&sid=<?php echo $row['subid']; ?>"  class="btn btn-success btn-xs"><i class="fa fa-pencil"></i></a>
                            <a href="subject.php?view=delete&sid=<?php echo $row['subid']; ?>" data-toggle="tooltip" data-original-title="Delete"  class="btn btn-success btn-xs"><i class="fa fa-trash"></i></a>
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
<?php 
include "header.php"; 
if($_GET["view"] == "delete")
{
mysql_query("DELETE FROM examination WHERE examid ='$_GET[sid]'");
}
?>

<?php include "sidebar.php"; ?>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Result
        </h1>
        <ol class="breadcrumb">
          <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
          <li class="active"><a href="#">Result</a></li>
        </ol>
      </section>
      <!-- Main content -->

      <section class="content">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">Upload Result</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="box-body table-responsive no-padding">
                    <div class="container">
            <div class="row">
 
                <form class="form-horizontal" action="importcsv.php" method="post" name="upload_excel" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="col-md-6">
                                <input type="file" name="file" id="file" class="form-control">
                            </div>
                            <div class="col-md-2">
                                <button type="submit" id="submit" name="Import" class="btn btn-primary button-loading form-control" data-loading-text="Loading...">Import</button>
                            </div>
                        </div>
                </form>
 
            </div>
                    <table id="example1" class="table table-bordered  table-striped">
                      <thead>
                       <tr>
                          <th>S No.</th>
                          <th>Student Name</th>
                          <th>Course Name</th>
                          <th>Subject Name</th>
                          <th>Semester</th>
                          <th>Subject Type</th>
                          <th>Scored</th>
                          <th>Maximum Marks</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        <?php 
                       
                        $result = mysql_query("SELECT * FROM examination as a INNER JOIN subject as b on a.subid = b.subid INNER JOIN course as c on a.courseid = c.courseid INNER JOIN studentdetails as d on a.studid = d.studid"); 
                        $count = 0;
                        while($row = mysql_fetch_array($result))
                        {
                        ?>
                        <tr id="rowID1">
                          <td><?php echo ++$count; ?></td>
                          <td><?php echo $row['studfname']." ".$row['studlname']; ?></td>
                          <td><?php echo $row['coursename']; ?></td>
                          <td><?php echo $row['subname']; ?></td>
                          <td><?php echo $row['semester']; ?></td>
                          <td><?php echo $row['internaltype']; ?></td>
                          <td><?php echo $row['scored']; ?></td>
                          <td><?php echo $row['maxmarks']; ?></td>
                          
                          <td>
                            <a href="result.php?view=delete&sid=<?php echo $row['examid']; ?>" data-toggle="tooltip" data-original-title="Delete"  class="btn btn-success btn-xs"><i class="fa fa-trash"></i></a>
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
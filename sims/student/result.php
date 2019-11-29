<?php 
include "header.php"; 

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
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="box-body table-responsive no-padding">
                    <div class="container">
                    <table  class="table table-bordered  table-striped">
                      <thead>
                       <tr>
                          <th>S No.</th>
                          <th>Subject Name</th>
                          <th>Semester</th>
                          <th>Subject Type</th>
                          <th>Scored</th>
                          <th>Maximum Marks</th>
                        </tr>
                      </thead>
                      <tbody>
                        <?php 
                        
                        $result = mysql_query("SELECT * FROM examination as a INNER JOIN subject as b on a.subid = b.subid INNER JOIN course as c on a.courseid = c.courseid INNER JOIN studentdetails as d on a.studid = d.studid WHERE a.studid = '$_SESSION[userid]'"); 
                        $count = 0;
                        $totalmarks = 0;
                        $scoredmarks = 0;
                        while($row = mysql_fetch_array($result))
                        {
                          $totalmarks += $row['maxmarks'];
                          $scoredmarks += $row['scored'];
                        ?>
                        <tr id="rowID1">
                          <td><?php echo ++$count; ?></td>
                          <td><?php echo $row['subname']; ?></td>
                          <td><?php echo $row['semester']; ?></td>
                          <td><?php echo $row['internaltype']; ?></td>
                          <td><?php echo $row['scored']; ?></td>
                          <td><?php echo $row['maxmarks']; ?></td>
                        </tr>
                      <?php } ?>
                      </tbody>
                      <tfoot>
                         <tr>
                          <th colspan="4"></th>
                          <th>Scored Marks</th>
                          <th><?php echo $scoredmarks; ?></th>
                        </tr>
                        <tr>
                          <th colspan="4"></th>
                          <th>Total Marks</th>
                          <th><?php echo $totalmarks; ?></th>
                        </tr>
                      </tfoot>
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
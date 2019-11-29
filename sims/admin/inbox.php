<?php 
include "header.php"; 
if($_GET["view"] == "delete")
{
mysql_query("DELETE FROM contact WHERE contactid = '$_GET[sid]'");
}
?>

<?php include "sidebar.php"; ?>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          Inbox
        </h1>
        <ol class="breadcrumb">
          <li><a href="dashboard.php"><i class="fa fa-dashboard"></i>Dashboard</a></li>
          <li class="active"><a href="#">Inbox</a></li>
        </ol>
      </section>
      <!-- Main content -->
      <section class="content">
        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-header">
                <h3 class="box-title">Message list</h3>
                </div><!-- /.box-header -->
                <div class="box-body">
                  <div class="box-body table-responsive no-padding">
                    <table id="example1" class="table table-bordered  table-striped">
                      <thead>
                       <tr>
                          <th>S No.</th>
                          <th>Name</th>
                          <th>Email ID</th>
                          <th>Contact Number</th>
                          <th>Subject</th>
                          <th>Message</th>
                          <th>Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        <?php 
                        $result = mysql_query("SELECT * FROM contact"); 
                        $count = 0;
                        while($row = mysql_fetch_array($result))
                        {
                        ?>
                        <tr id="rowID1">
                          <td><?php echo ++$count; ?></td>
                          <td><?php echo $row['name']; ?></td>
                          <td><?php echo $row['emailid']; ?></td>
                          <td><?php echo $row['contactno']; ?></td>
                          <td><?php echo $row['subject']; ?></td>
                          <td><?php echo $row['message']; ?></td>
                          <td>
                            <a href="inbox.php?view=delete&sid=<?php echo $row['contactid']; ?>" data-toggle="tooltip" data-original-title="Delete"  class="btn btn-success btn-xs"><i class="fa fa-trash"></i></a>
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
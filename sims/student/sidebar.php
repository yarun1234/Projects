<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <div class="user-panel" style="height:40px;">
        <div class="info">
            <?php
                $sql = mysql_query("SELECT studfname,studlname FROM studentdetails WHERE studid = '{$_SESSION["userid"]}'");
                $result = mysql_fetch_assoc($sql);
            ?>
          <h5 style="font-weight: bold;"><i class="fa fa-user"></i> &nbsp;<?php echo $result['studfname']." ".$result['studlname']; ?></h5>
        </div>
        </div>
        <ul class="sidebar-menu">
            <li>&nbsp;</li>
            <li>
                <a href="dashboard.php">
                    <i class="fa fa-dashboard"></i><span>Dashboard</span>
                </a>
            </li>
            <li>
                <a href="updateprofile.php">
                    <i class="fa fa-user"></i><span>Profile</span>
                </a>
            </li>
            <li>
                <a href="result.php">
                    <i class="fa fa-file-text-o"></i><span>Result</span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
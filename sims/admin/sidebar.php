<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <div class="user-panel" style="height:40px;">
        <div class="info">
          <h5 style="font-weight: bold;"><i class="fa fa-user"></i> &nbsp;<?php echo $_SESSION["userid"]; ?></h5>
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
                <a href="course.php">
                    <i class="fa fa-book"></i><span>Course</span>
                </a>
            </li>
            <li>
                <a href="subject.php">
                    <i class="fa fa-book"></i><span>Subject</span>
                </a>
            </li>
            <li>
                <a href="student.php">
                    <i class="fa fa-users"></i><span>Students</span>
                </a>
            </li>
            <li>
                <a href="result.php">
                    <i class="fa fa-file-text-o"></i><span>Result</span>
                </a>
            </li>
            <li>
                <a href="admin.php">
                    <i class="fa fa-user"></i><span>Admin</span>
                </a>
            </li>
            <li>
                <a href="inbox.php">
                    <i class="fa fa-envelope"></i><span>Inbox </span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
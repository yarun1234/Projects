<?php 
session_start();
if(!isset($_SESSION['username']))
{
?>
<script> window.top.location = 'index.php'; </script>
<?php
}
include "header.php";
include "../connection.php";
if (isset($_GET['id'])) {
		$id = $_GET['id'];
		$query = "DELETE FROM registration WHERE id = '$id'";
		$result = mysqli_query($conn,$query);
}
?>


<div class="container">
	<div class="row">
		<h2 align="center"> Participants </h2>
		<br>
		<div class="col-md-12">
			<table class="table table-hover table-bordered table-striped">
					<thead>
						<tr style="background: black; color: white">
							<td>S.No.</td>
							<td>First Name</td>
							<td>Last Name</td>
							<td>Contact No</td>
							<td>Email ID</td>
							<td>Address</td>
							<td>Pincode</td>
							<td>Age</td>
							<td>Delete</td>
						</tr>
					</thead>
					<tbody>
						<?php
							$count = 1;
							$query = "SELECT * FROM registration";
							$result = mysqli_query($conn,$query);
							while ($data = mysqli_fetch_assoc($result)) {
						?>
						<tr>
							<td><?php echo $count++; ?></td>
							<td><?php echo $data['first_name']; ?></td>
							<td><?php echo $data['last_name']; ?></td>
							<td><?php echo $data['contact_no']; ?></td>
							<td><?php echo $data['email_id']; ?></td>
							<td><?php echo $data['address']; ?></td>
							<td><?php echo $data['pincode']; ?></td>
							<td><?php echo $data['age']; ?></td>
							<td><a href="participants.php?id=<?php echo $data['id']; ?>">Delete</a></td>
						</tr>
						<?php } ?>
					</tbody>
			</table>
		</div>
	</div>
</div>




<?php 
include "../footer.php";
?>
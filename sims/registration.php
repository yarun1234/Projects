<?php
include "header.php";

  if(isset($_POST["submit_register"]))
  {
  $dob = str_replace('-', '/', $_POST['dob']);
  $format_dob = date('Y-m-d',strtotime($dob));
  $pass = md5($_POST['password']);
  $sql="INSERT INTO studentdetails (studfname, studlname, fathername, gender, address,contactno,courseid,semester,dob,pass) VALUES ('$_POST[fname]','$_POST[lname]','$_POST[father_name]','$_POST[gender]','$_POST[address]','$_POST[contact_no]','$_POST[course]','$_POST[semester]','$format_dob','$pass')";
  if (!mysql_query($sql))
  {
  echo display_message(mysql_error());
  }
  else
  {
  $lastid = mysql_insert_id();
  echo display_message("Registration successfull. Your Student Login Id is '{$lastid}'.");
  }
  }
?>
<div class="container">
	<div class="row">
		<h2> Registration </h2>
		<br>
		<div class="row col-md-8">
			<form name="form1" method="post" action="" id="formID">
				<p class="textfield">
					<label>
						First Name (required)
					</label>
					<input name="fname" id="fname" value="" size="22" type="text" class="validate[required,custom[onlyLetterSp]] text-input form-control">
					
				</p>
				<p class="textfield">
					<label>
						Last Name (required)
					</label>
					<input name="lname" id="lname" value="" size="22" type="text" class="validate[required,custom[onlyLetterSp]] text-input form-control">
				</p>
				<p class="textfield">
					<label>
						Father's Name (required)
					</label>
					<input name="father_name" id="father_name" value="" size="22" type="text" class="validate[required,custom[onlyLetterSp]] text-input form-control">
				</p>
				<p class="textfield">
					<label for="url">
						Gender
					</label>
					<select name="gender" class="text-input form-control" id="gender">
						<option value="male">Male</option>
						<option value="female">Female</option>
					</select>
				</p>
				<p>
					<strong>Address</strong>
				:</p>
				<p class="text-area">
					<textarea name="address" id="address" class="validate[required] form-control" cols="50" style="height: 80px"></textarea>
				</p>
				<p class="textfield">
					<label for="textfield6">Contact No</label>
					<input type="text" name="contact_no" id="textfield6" class="validate[required] text-input form-control">
				</p>
				<p class="textfield">
					<label for="textfield7">Course </label>
					<select name="course" class="form-control">
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
					</p>
					<p class="textfield">
						<label for="textfield8">Semester</label>
						<label for="select"></label>
						<select name="semester" id="select" class="form-control">
							<option value="1">First Semester</option>
							<option value="2">Second Semester</option>
							<option value="3">Third Semester</option>
							<option value="4">Fourth Semester</option>
							<option value="5">Fifth Semester</option>
							<option value="6">Sixth Semester</option>
						</select>
					</p>
					<p class="textfield">
						<label for="textfield4">Date of Birth</label>
						<script src="datetimepicker_css.js"></script>
						<input type="date" name="dob" id="textdob" maxlength="25" size="25" class="validate[required,[date]] form-control text-input">
					</p>
					<p class="textfield">
						<label for="textfield6">Password</label>
						<input type="password" name="password" id="password" class="validate[required] text-input form-control">
					</p>
					<p>
						<input name="submit_register" id="submit" tabindex="5" type="submit" class="btn btn-success">
					</p>
					<div class="clear"></div>
				</form>
			</div>
		</div>
	</div>
	<?php
	include "footer.php";
	?>
<?php
$con = mysql_connect("localhost","root","");
if (!$con)
{
die('Could not connect: ' . mysql_error());
}

mysql_select_db("studentinfo", $con);

function display_message($message)
{
	$error_message  = '<div class="alert alert-danger fade in alert-dismissable" style="margin-bottom:0px!important;">';
	$error_message .= '<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>';
	$error_message .= '<strong><center>'.$message.'</center></strong>';
	$error_message .= '</div>';
	echo $error_message;
	//var_dump($error_message); exit();
}

function isValidMd5($md5 ='')
{
    return preg_match('/^[a-f0-9]{32}$/', $md5);
}

/* $image = $_FILES['work_image']['name'];

                // image file directory
                $target = "images_admin/".basename($image);

                if(move_uploaded_file($_FILES['work_image']['tmp_name'], $target)) {
                  $msg = "Image uploaded successfully";
                }else{
                  $msg = "Failed to upload image";
                }
*/
?>

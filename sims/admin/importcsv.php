<?php
 include "connection.php";
 
 if(isset($_POST["Import"])){
		
		$filename=$_FILES["file"]["tmp_name"];		
 
 
		 if($_FILES["file"]["size"] > 0)
		 {
		  	$file = fopen($filename, "r");
		  	$flag = 1;
	        while (($getData = fgetcsv($file, 10000, ",")) !== FALSE)
	         {
	         	if($flag > 1)
	         	{
	         		$sql = "INSERT into examination (studid,subid,courseid,semester,internaltype,maxmarks,scored) 
                   values ($getData[0],$getData[1],$getData[2],$getData[3],'$getData[4]',$getData[5],$getData[6])";
                   $result = mysql_query($sql);
				if(!$result)
				{
					echo "<script type=\"text/javascript\">
							alert(\"Invalid File:Please Upload CSV File.\");
							window.location = \"result.php\"
						  </script>";		
				}
				else {
					  echo "<script type=\"text/javascript\">
						alert(\"CSV File has been successfully Imported.\");
						window.location = \"result.php\"
					</script>";
				}
			}
				$flag++;

	         }
			
	         fclose($file);	
		 }
	}	 
 
 
 ?>
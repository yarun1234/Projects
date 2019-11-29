<?php include "header.php"; ?>
<?php
  if(isset($_POST["submit_register"]))
  {
  $sql="INSERT INTO contact (name, emailid, contactno, subject, message) VALUES ('$_POST[name]','$_POST[email]','$_POST[contact]','$_POST[subject]','$_POST[message]')";
  if (!mysql_query($sql))
  {
  echo display_message(mysql_error());
  }
  else
  {
  echo display_message("Message Sent Successfully");
  }
  }
?>
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <h3>Contact Us</h3>
      <br>
      <form name="form1" method="post" action="" id="formID">
        <p class="textfield">
          <label>Name</label>
          <input name="name" id="name" value="" size="22" type="text" class="validate[required,custom[onlyLetterSp]] text-input form-control">
          <label for="author">
          </label>
        </p>
        <p class="textfield">
            <label>E-Mail</label>
          <input name="email" id="email" value="" size="22" type="text" class="validate[required,custom[email]] text-input form-control">
          <label for="email">
          </label>
        </p>
        <p class="textfield">
            <label>Contact No</label>
          <input name="contact" id="contact" value="" size="22" type="text" class="validate[required,custom[phone]] text-input form-control">
          <label for="url1">
          </label>
        </p>
        <p class="textfield">
            <label>Subject</label>
          <input name="subject" id="subject" value="" size="22" type="text" class="validate[required] text-input form-control">
          <label for="url">
          </label>
        </p>
        <p>
          <label><strong>Message</strong></label>
        :</p>
        <p class="text-area">
          <textarea name="message" id="message" class="validate[required] form-control" cols="50" rows="10"></textarea>
        </p>
        <p>
          <input type="submit" id="submit" name="submit_register" class="btn btn-success">
        </p>
        <div class="clear"></div>
      </form>
    </div>
  </div>
</div>
<?php include "footer.php"; ?>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=iso-8859-1">
<link rel="stylesheet" type="text/css" href="/dbvendor/common/db.2.0.css" />
</head>

<body OnLoad="if(document.forms[0].user.value.length > 0) {document.forms[0].pass.focus();} else {document.forms[0].user.focus();}" class="login">

<form name="login" method="post" action="../j_spring_security_check" ID="login">
<div class="pos">
<div class="out">
<div class="in">
<div class="header"><span></span></div>
<div class="left"></div>

<div class="exist"> 

<div class="userlbl"><label for="user">Username</label></div>
<div class="passlbl">Password</div>
<div class="userbox"><input type="text" name="j_username" value="" maxlength=64 id="user"></div>
<div class="passbox"><input type="password" name="j_password" value="" maxlength=32 id="pass"></div>
<input type="hidden" value="supplier.demandbridge.com" name="j_site" />
<input type="hidden" value="SB" name="j_domain" />
<div class="submit"><input type="submit" name="submit" value="Log In" accesskey="l"></div>

</div>

<div class="right"></div>

</div> <!-- in -->
</div> <!-- out -->
</div> <!-- pos -->

<script language="JavaScript" type="text/javascript">if (document.getElementById('user').length > 0) {document.getElementById('pass').focus();}</script>
</form>
</body>
</html>

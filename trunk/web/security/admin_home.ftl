<#include "../template/header.ftl">
 
  <br class="clear" />
  <div class="header">
    <p>Employee Starter Kit</p>
  </div>
  <style type="text/css">
input[type=text], input[type=password], input.text, input.title, textarea, select {
	margin: 0 0;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	margin-left: 0px;
}

.x-form-field-trigger-wrap{
    position: relative;
    top: -7px;
    width: 73px;
}
.x-form-field-wrap .x-form-trigger{
	position: relative !important;
    top: 7px !important;
}
</style>
 <div class="content">
  	 <div class="breadCrumb"> <a href="AdminHome.dbv">Home</a> <span class="seperator"></span>Dashboard
      </div>
    <br class="clear" />
    <div class="dashboardPanel" style="margin-right: 5px;" id="userManagementGrid"> </div>
    <br class="clear" />
    <div class="dashboardPanel" style="margin-right: 5px;" id="employee-historyList"></div>
	  <br class="clear" />
   
  </div>  
   <script type="text/javascript" src="../security/admin_home.js"></script>   
  
<#include "../template/footer.ftl">
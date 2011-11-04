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
      <div class="topRightButton">
        <input name="Submit" type="submit" class="buttonsBlue  btn-new-draft" title="Create Employee" value="Create User"   onclick="MM_goToURL('parent','CreateNewUser.dbv');return document.MM_returnValue" />
      </div>
    </div>
    
    <div class="on-time-estimate"  style="visibility:hidden;">
    <span>
    	on time estimates <strong>60%</strong>
    	
    	</span> 
    </div>
    
   
   <br class="clear" />
   
    <div id="userManagementGrid"">	 
	</div>    
    
    <br class="clear" />

  
   <script type="text/javascript" src="../security/admin_home.js"></script>   
   </div>
<#include "../template/footer.ftl">
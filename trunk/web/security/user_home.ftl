<#include "../template/header.ftl">
 
  <div class="content">
  
  	 <div class="breadCrumb"> <a href="UserHome.dbv">Home</a> <span class="seperator"></span>Dashboard
      <div class="topRightButton">
        <input name="Submit" type="submit" class="buttonsBlue  btn-new-draft" title="Create Employee" value="Create Employee"   onclick="MM_goToURL('parent','CreateNewEmployee.dbv');return document.MM_returnValue" />
      </div>
    </div>
    
    <div class="on-time-estimate"  style="visibility:hidden;">
    <span>
    	on time estimates <strong>60%</strong>
    	
    	</span> 
    </div>
    
   
   <br class="clear" />
   
    <div id="employee-historyList">	 
	</div>    
    
    <br class="clear" />

  </div>
     <script type="text/javascript" src="../security/user_home.js"></script>  
<#include "../template/footer.ftl">
 <link rel="stylesheet" type="text/css" href="../resources/style/extjs_custom.css"/>
  <div class="headerTop"> <a class="" href=" " title="Ekit"></a>
    <div class="utility-menu">
     <a href="../security/Logout.dbv"> Logout</a> </div>
    <br class="clear" />
  </div>
  
    <div class="topMenu">
     <a href="../security/UserList.dbv" <#if PageLink=='User'>class="selectedItem"</#if>>
     User</a> 
 
       <span class="seperator">&nbsp;</span> 
     
     <a href="../security/EmployeeList.dbv" <#if PageLink=='Employee'>class="selectedItem"</#if>>
     Employee</a> 
            
     <br class="clear" />
  </div>
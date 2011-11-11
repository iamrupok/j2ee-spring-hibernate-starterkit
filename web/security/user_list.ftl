<#include "../template/header.ftl">
 <#include "../template/navigator_admin.ftl">
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
    <div class="breadCrumb"> 
    <a href="AdminHome.dbv">Home</a> <span class="seperator"> </span>${PageLink} 
    </div>
    <br class="clear" />
    <div id="user-List">	 
	</div>    
    <br class="clear" />
  </div>
     <script type="text/javascript" src="../security/user_list.js"></script>   
<#include "../template/footer.ftl">
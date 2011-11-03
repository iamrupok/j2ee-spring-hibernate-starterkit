<#include "/customheader.ftl"/>

	
			<table width="99%" cellspacing="2" cellpadding="2" border="0"
				align="center">
				<tbody>
		<#if type == 'User '>
					<tr>
						<td align="center" class="TitleLevel03" colspan="2">Login Error</td>
					</tr>
		<#else>
		
					<tr>
						<td align="center" class="TitleLevel03" colspan="2"> Error</td>
					</tr>
		
		</#if>
					
					<tr align="center">
						<td align="center" colspan="2">
						<table width="50%" cellspacing="0" cellpadding="0" border="0">
							<tbody>
								<tr>
									<td><img src="/dbvendor/images/SearchTopLeft.gif" /></td>
									<td width="100%" background="/dbvendor/images/SearchMiddleTop.gif"><img
										height="1" width="1" src="/dbvendor/images/TransparentPixel.gif" /></td>
									<td><img src="/dbvendor/images/SearchTopRight.gif" /></td>
								</tr>
			
		
								
								<#if type == 'User'>


								<tr>
									<td background="/dbvendor/images/SearchMiddleLeft.gif"><img
										height="1" width="1" src="/dbvendor/images/TransparentPixel.gif" /></td>
									<td width="100%">
									<div align="center"><span class="SmallInstruction"> ${type} There was a problem with your login.  Please contact support.
									<br />
									</span>
									</div>
									</td>
									<td background="/dbvendor/images/SearchMiddleRight.gif"><img
										height="1" width="1" src="/dbvendor/images/TransparentPixel.gif" /></td>
								</tr>
						<#else>
						<tr>
									<td background="/dbvendor/images/SearchMiddleLeft.gif"><img
										height="1" width="1" src="/dbvendor/images/TransparentPixel.gif" /></td>
									<td width="100%">
									<div align="center"><span class="SmallInstruction"> ${user}   Please contact support.
									<br />
									<a href="ErrorHome.dbv">Home</a>
									</span>
									</div>
									</td>
									<td background="/dbvendor/images/SearchMiddleRight.gif"><img
										height="1" width="1" src="/dbvendor/images/TransparentPixel.gif" /></td>
								</tr>
								
							</#if>  								
								<tr>
									<td><img src="/dbvendor/images/SearchBottomLeft.gif" /></td>
									<td width="100%" background="/dbvendor/images/SearchMiddleBottom.gif"><img
										height="1" width="1" src="/dbvendor/images/TransparentPixel.gif" /></td>
									<td><img src="/dbvendor/images/SearchBottomRight.gif" /></td>
								</tr>
								
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>


<#include "/footer.ftl"/>
var _LIST_PAGE_HEIGHT_GLOBAL=350;
function setCookie(cookieName,cookieValue,expiredays)
{
	var exdate=new Date();
	exdate.setDate(exdate.getDate()+expiredays);
	document.cookie=cookieName+ "=" +escape(cookieValue)+((expiredays==null) ? "" : ";expires="+exdate.toUTCString());
}
function setCookieAndRedirect(url, values)
{
	var valueArray = values.split("&");
	for(i=0;i<valueArray.length;i++)
	{
		var nameValue = valueArray[i].split("=");
		setCookie(nameValue[0], nameValue[1], 1);
	}
	window.location = url;
}
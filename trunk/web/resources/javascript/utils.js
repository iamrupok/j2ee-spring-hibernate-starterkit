function MM_goToURL() { //v3.0
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

function toggleArrow(divid,arrowid) {
	
    if (divid == "item") {
        myToggle(arrowid);
    }
    else if (divid == "vendor") {
        myToggle(arrowid);
    }
    else if (divid == "refine") {
        myToggle(arrowid);
    }

}

function myToggle(arrowid) {
	
    if (document.getElementById(arrowid).className == "open")
        document.getElementById(arrowid).className = "closed";
    else
        document.getElementById(arrowid).className = "open";
}

function checkZipCode(zipcode){
var re5digit=/^\d{5}$/ //regular expression defining a 5 digit number
if (zipcode.search(re5digit)==-1) //if match failed
return false;
else
return true;
}


function is_int(value){
  if((parseFloat(value) == parseInt(value)) && !isNaN(value)){
      return true;
  } else {
      return false;
  }
}		

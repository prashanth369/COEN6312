function naming(){
	var fname = document.getElementsByName("firstName")[0].value;
	var lname = document.getElementsByName("lastName")[0].value;
	var addre = document.getElementsByName("address")[0].value;
	var phNum = document.getElementsByName("phNum")[0].value;
	var username = document.getElementsByName("userName")[0].value;
	var password = document.getElementsByName("password")[0].value;
    var tem = 0;

	 if(fname == ""){
          	 document.getElementById("er1").innerHTML = "firstname cannot be a null value";
          	 tem ++;
	 }
	 if(lname == ""){
      	 document.getElementById("er2").innerHTML = "lastname cannot be a null value";
      	 tem ++;
 }
	 if(addre == ""){
      	 document.getElementById("er3").innerHTML = "Address cannot be a null value";
      	 tem ++;
 }
	 if(phNum == ""){
		
      	 document.getElementById("er4").innerHTML = "Phone number cannot be a null value";
      	 tem ++;
		 
     }
	 if(isNaN(phNum)){
		 document.getElementById("er4").innerHTML = "Please enter a valid Phone number";
	  	 tem ++;
	 }
	 if(!isNaN(phNum)){
		 if(phNum.length !=10){
			 document.getElementById("er4").innerHTML = "Please enter a valid Phone number";
		  	 tem ++;
		 }
	 }
	 
	 if(username == ""){
      	 document.getElementById("er5").innerHTML = "username cannot be a null value";
      	 tem ++;
 }
	 if(password == ""){
      	 document.getElementById("er6").innerHTML = "password cannot be a null value";
      	 tem ++;
 }
	 if(password.length < 8){
		 document.getElementById("er6").innerHTML = "password should contain atleast 9 characters";
      	 tem ++;
	 }
	 
	 if(tem >0){
		 return false;
	 }
	 else{
		
		 return true;
	 }
}
function validateEmain(email){
	 var expression = /(?!.*\.{2})^([a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+(\.[a-z\d!#$%&'*+\-\/=?^_`{|}~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]+)*|"((([ \t]*\r\n)?[ \t]+)?([\x01-\x08\x0b\x0c\x0e-\x1f\x7f\x21\x23-\x5b\x5d-\x7e\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|\\[\x01-\x09\x0b\x0c\x0d-\x7f\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))*(([ \t]*\r\n)?[ \t]+)?")@(([a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\d\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.)+([a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]|[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF][a-z\d\-._~\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]*[a-z\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])\.?$/i;
	 return expression.test(String(email).toLowerCase());
}

function register() {
	var name = $("#username").val();
	var pass = $("#password").val();
	var passC = $("#passwordC").val();
	
	var user = {
			name: name,
        	password: pass
        };
	
	if(name==""){
		alert("Username field can't be empty!");
	}else if(pass != passC || pass==""){
		alert("Shure that passwords fields are equal and not empty!");
	}else{
	    $.ajax({
	        cache: false,
	        timeout: 15000,
	    	url: context+"/createUser/",
	        method: 'POST',
	        data: JSON.stringify(user),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json"
	    }).done(function (data) {
	    	//alert('success');
	    	document.getElementsByClassName("okBox")[0].style.display = "block";
	    	document.getElementsByClassName("okBox")[0].style.backgroundColor = "#00FF00";
	    	document.getElementsByClassName("okBox")[0].style.width = "30%";
	    	setTimeout(redirect, 1000);
	    	function redirect() { document.location.href = context+'/login'; }
	    }).fail(function (error) {
	    	//alert(error+"ERROR");
	    	document.getElementsByClassName("alertBox")[0].style.display = "block";
	    	document.getElementsByClassName("alertBox")[0].style.backgroundColor = "#F08080";
	    	document.getElementsByClassName("alertBox")[0].style.width = "30%";
	    });
	}
	
}
function rate(film){
	
	var value = document.getElementById("input").value;
	
	var rating = {
			filmId : film,
			rating : value
		};
	
	if(value>0){
		$.ajax({
	        cache: false,
	        timeout: 15000,
	    	url: context+"/rateFilm/",
	        method: 'POST',
	        data: JSON.stringify(rating),
	        contentType: "application/json; charset=utf-8",
	        dataType: "json"
	    }).done(function (data) {
	    	location.reload();
	    }).fail(function (error) {
	    	alert(error+"ERROR");
	    });
	}else{
		alert("Rating must be between 1 and 5 stars!");
	}
}
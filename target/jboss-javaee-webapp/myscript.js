$("#searchform").submit(function(e){
	e.preventDefault();
	
	var query=$("lastName").val();
	// validate data...
	$.get("localhost:8080/webservice/rest/member","&lastName="+query,function(d){
		// validate result...
		var strHTML="";
		$.each(d,function(i,v){
			strHTML+="<tr><td>"+v.memberId+"</td><td>"+v.firstName+"</td></tr>"+v.lastName+"</td><td>"
		});
		
		$("#resultbody").html(strHTML);
	},"JSON");
});
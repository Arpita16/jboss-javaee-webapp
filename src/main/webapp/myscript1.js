$("#searchform").submit(function(e){
	e.preventDefault();
	//var type=$("#typefield").val();
	var query=$("#title").val();
	// validate data...
	$.get("localhost:8080/jboss-javaee-webapp/rest/book","&title="+query,function(d){
		// validate result...
		var strHTML="";
		$.each(d,function(i,v){
			strHTML+="<tr><td>"+v.title+"</td><td>"+v.author+"</td></tr>"
		});
		$("#resultbody").html(strHTML);
	},"JSON");
});



$.get("files/lates.xml").done(data => {
	data = $(data).find("assignment");					
	let onTime = data.find("submission date[lateness=0]");
	let late   = data.find("submission date[lateness!=0]");
	
	$("main")
	.html(() =>					
		"<h2>" + data.find("course").attr("name") + "</h2>"	
			+ "Due: " + data.find("due date").text() 
			+ " at " + data.find("due time").text())
	.append("<br /><br /><div style='display: flex;'>On time: " + (() => {
		let retVal = "<ul style='margin-top: 0;'>";
		$(onTime).each((key, el) => {
			retVal += "<li>" + $($(el).parent()).attr("studentid") + "</li>";
		});
		
		return retVal + "</ul></div>";
	})())
	.append(() => {
		let retVal = "<table><tr><td>Student ID</td>"
			+ "<td>Days late</td><td>Date Submitted</td>"
			+ "<td>Time Submitted</td></tr>";
		$(late).each((key, el) => {
			retVal += "<tr><td>" + $($(el).parent()).attr("studentid") + "</td>" 
				+ "<td>" + $(el).attr("lateness") + "</td>"
				+ "<td>" + $(el).text() + "</td>" 
				+ "<td>" + $(el).next().text() + "</td></tr>";
		});
		
		return retVal + "</table>";
	})
	.append("<br />" + (() => {
		return "Total Number of Students: " + (onTime.length + late.length) + 
			"<br />Number who sumbitted on time: " + onTime.length + 
			"<br />Number who sumbitted on late: " + late.length;
	})());				
});
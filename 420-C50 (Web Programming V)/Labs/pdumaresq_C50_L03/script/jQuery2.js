$.get({
	url: "files/users.xml"
}).done(data => {			
	let cont = document.createElement("div");
	$(data).find("users user").each((key, user) => {
		let first = $(user).find("name firstName").text();
		let last  = $(user).find("name lastName").text();
		let city  = $(user).find("city").text();
		let country = $(user).find("country").text();
		let email = $(user).find("email").text();
		let pet   = $(user).find("pet").text();
		let petColour = $(user).find("petColour").text();
		let sex = $(user).find("gender").text().charAt(0);					
		
		let div = document.createElement("div");					
		div.innerHTML = first + " " + last + "<br />" +
			city + ", " + country + "<br />" + 
			((email != "" && email != null) ? email + "<br />" : "") + 
			((sex == "M") ? "He" : "She") + " has a " 
			+ petColour + " " + pet;
			
		$(div).css("border", "thin solid black")
			.css("margin-bottom", "1%")
			.css("padding", "1%");
		$(cont).append(div);
	});
	
	$("main").append(cont).slideDown(3000);
});	
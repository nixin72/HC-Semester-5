$(document).ready(() => {
	$.get("files/users.json").done(data => {
		let cont = document.createElement("div");
		data.users.user.forEach(user => {
			let div = document.createElement("div");					
			div.innerHTML = 
				user.name.firstName + " " + user.name.lastName + "<br />" 
				+ user.city + ", " + user.country + "<br />" + 
				((user.email != "" && user.email != null) 
					? user.email + "<br />" : "") + 
				((user.gender.charAt(0) == "M") ? "He" : "She") 
				+ " has a " + user.petColour + " " + user.pet;
				
			$(div).css("border", "thin solid black")
				.css("margin-bottom", "1%")
				.css("padding", "1%");
			$(cont).append(div);
		});
		
		$("main").append(cont).slideDown(3000);
	});
});
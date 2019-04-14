$(document).ready(() => {
	const atBottom = () => $(window).scrollTop() + $(window).height() == $(document).height();
	const atTop = () => $(window).scrollTop() == 0;
		
	function getReq(url, callback) {
		try {
			let req = new XMLHttpRequest();
			if (req) {
				req.onreadystatechange = () => 
					callback(req.readyState === 4 ? req.responseXML : -1);
				
				req.open("GET", url);
				req.send();	
			}				
		}
		catch(err) { 
			console.log(err); 
		}
	}
	
	(function s(sr, c, dir, first) {
		if (dir != 0) $('html, body').animate({scrollTop: ($("#scrollHere").offset().top - (dir > 0 ? 0 : $(window).height()))}, 0);
		
		getReq("getUsers.php?sr=" + sr + "&c=" + c, data => {
			if (data == -1) return;
			data = data.querySelectorAll("user");
			
			let div = document.createElement("div");
			Object.keys(data).map(x => data[x]).forEach(el => {
				div.innerHTML += "<div class='user'>" +
					`<h2 class='h' style=''>` + 
						($(el).find("firstName").text() == "" ? "" : $(el).find("firstName").text() + " ") +
						($(el).find("lastName").text() == "" ? "" : $(el).find("lastName").text() + "<br />") +
					`</h2>
					<div class='info' style=''>
						<div class='lbls' style=''>
							<label>Location:</label><br />
							<label>Email:</label>
						</div>
						<div class='data'>` + 
							($(el).find("city").text() == "" ? "" : $(el).find("city").text() + ", ") + 
							($(el).find("country").text() == "" ? "" : $(el).find("country").text() + "<br />") + 
							($(el).find("email").text() == "" ? "N/A" : $(el).find("email").text() + "<br />") + `
						</div>
					</div>
					<h3 class='h'>Pet Information: </h3>
					<div class='info'>
						<div class='lbls'>
							<label>Gender:</label><br />
							<label>Breed:</label><br />
							<label>Colour:</label>
						</div>
						<div class='data'>` + 
							($(el).find("gender").text() == "" ? "" : $(el).find("gender").text() + "<br />") + 				
							($(el).find("pet").text() == "" ? "" : $(el).find("pet").text() + "<br />") + 
							($(el).find("petColour").text() == "" ? "" : $(el).find("petColour").text()) +
						`</div>
					</	div>
					<hr class='break'/>`;
			});
			
			if (dir < 0)
				$("#ds1").html($("#ds2").html()) && $("#ds2").html(div.innerHTML);					
			if (dir > 0 || dir == 0)
				$("#ds2").html($("#ds1").html()) && $("#ds1").html(div.innerHTML);	
			if (first) 
				s(sr+c, c, 0, false);
			
			window.onscroll = e => {
				if (atBottom() && sr <= 1000) 
					s(sr+c, c, -1, false);
				else if (atTop() && sr > 1) 
					s(sr-c, c, 1, false);
			};
		});	
	})(1, 50, 0, true);
});
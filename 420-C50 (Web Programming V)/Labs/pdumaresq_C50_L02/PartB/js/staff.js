try { var req = new XMLHttpRequest(); }
catch (err) { document.getElementById("staffdisplay").innerHTML = "Error"; }

req.addEventListener("readystatechange", function() {
	if (req.readyState === 4) {
		let xml = req.responseXML.children[0].children;
		let staff = Object.keys(xml).map(key => { 
			return ((xml[key].tagName == "info") ? null : 
				xml[key].querySelector("name last").innerHTML 
				+ ", " + xml[key].querySelector("name first").innerHTML);
		});
			
		staff.sort();
		staff.forEach(el => {
			if (el != null) {				
				let opt = document.createElement("option");
				opt.innerHTML = el;
					
				document.getElementById("staffsel").appendChild(opt);	
			}
		});
		
		document.getElementById("staffsel").addEventListener("change", function(event) {
			let selected = event.target.options[event.target.selectedIndex];
			req.responseXML.querySelectorAll("user results").forEach(el => {
				if (el.parentNode != req.responseXML.querySelector("info")) {
					let first = el.querySelector("name first").innerHTML;
					let last = el.querySelector("name last").innerHTML;
					
					if (last + ", " + first == selected.innerHTML) {
						let title = el.querySelector("name title").innerHTML;
						let email = el.querySelector("email").innerHTML;
						let username = el.querySelector("login username").innerHTML;
						let cell = el.querySelector("cell").innerHTML;
						let DoB = el.querySelector("dob").innerHTML;
						let pic = el.querySelector("picture large").innerHTML;
						
						document.getElementById("staffdisplay").innerHTML = (() => {
							var ret = "<div>"
							ret += "<div>Name: <br />Email: <br />Username: <br />Cell Number: <br />Date of Birth: </div>" 
							ret += "<div>"+ title + " " + first + " " + last + "<br />";
							ret += email + "<br />" + username + "<br />" + cell + "<br />" + DoB + "</div>";
							ret += "<span style='margin-left: 5%'><img src='" + pic + "' alt='Profile picture'/></span>";
							
							return ret;
						})();
					}
				}
			});
		});		
	}
});

req.open("GET", "https://randomuser.me/api/?format=xml&results=10");
req.send();


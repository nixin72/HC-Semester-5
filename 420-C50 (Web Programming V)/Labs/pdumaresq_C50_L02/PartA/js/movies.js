try { 
	var xhr = new XMLHttpRequest(); 
}
catch (err) { 
	document.querySelector("body").innerHTML = err;
}

if (xhr)
	xhr.addEventListener("readystatechange", function(event) {
		if (xhr.readyState === 4) {
			let xml = xhr.responseXML.children[0].children;
			console.log(xml);
			
			let movies = Object.keys(xml).map(key => xml[key]);
			movies.sort((a, b) => {
				return (
					a.querySelector("title").innerHTML > b.querySelector("title").innerHTML
					) ? 1 : -1;
			});
			
			movies.forEach(movie => {
				let title = movie.querySelector("title").innerHTML;
				let genre = movie.querySelector("genre").innerHTML;
				let country = movie.querySelector("country").innerHTML;
				let year = movie.querySelector("year").innerHTML;
				
				document.querySelector("body").innerHTML += "<h3>" + title + "</h3>" +
					"<div class='directors'>" + "<p>Directed by: </p>" + 
						"<ul>" + 
							(() => {
								var ul = "";
								movie.querySelectorAll("director").forEach(dir => {
									ul += "<li>" + dir.innerHTML + "</li>";
								});
								
								return ul;
							})() +
						"</ul>" + 
					"</div>" + "Genre: " + genre + "<br />" + country + ", " + year + "<hr />";
			});				
		}
	});

xhr.open("GET", "movies.xml");
xhr.send();		
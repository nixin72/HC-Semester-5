fetch("movies.json").then(data => {
	return data.json();
}).then(data => {
	var json = data.movies;
	var movies = Object.keys(json).map(key => json[key])[0];
	
	movies.sort((a, b) => {
		return (a.title > b.title) ? 1 : -1;
	});
	
	movies.forEach(movie => {
		document.querySelector("body").innerHTML += "<h3>" + movie.title + "</h3>" + 
			"<div class='directors'>" + "<p>Directed by: </p>" + 
				"<ul>" + 
					((typeof movie.director == "string") ? movie.director : (() => {
						var ul = "";
						movie.director.forEach(dir => {
							ul += "<li>" + dir + "</li>";
						});
						
						return ul;
					})()) +
				"</ul>" + 
			"</div>" + "Genre: " + movie.genre + "<br />" + 
				movie.country + ", " + movie.year + "<hr />";
	});
}).catch(err => {
	document.querySelector("body").innerHTML = err;
});
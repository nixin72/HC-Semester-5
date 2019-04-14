$.fn.getAttributes = function() {
	var attributes = {}; 

	if(this.length) 
		$.each(this[0].attributes, function(index, attr) {
			attributes[attr.name] = attr.value;
		}); 

	return attributes;
};

$.get("files/books.xml").done(xml => {			
	let length = $(xml).find("bookstore book").length;
	
	(function showBook(c) {
		let book = $(xml).find("bookstore book:nth-child("+c+")");	
		$("main").html("<div><h2>" + $($(book).find("title")).text() 
			+ " (" + $($(book).find("title")).attr("lang") + ")</h2>" 
			+ (() => {
				let retVal = "Author(s): <ul>";
				$($(book).find("author")).each((key, val) => {
					retVal += "<li>" + $(val).text() + "</li>";
				});
				
				return retVal + "</ul>";
			})() + (() => {
				let retVal = "";
				$.each($($(book).getAttributes())[0], (key, value) => {
					retVal += "<br />" + key + ": " + value;
				});
				
				return retVal;
			})() + "<div>" + $(book).find("year").text() + "<br />$" + 
			$(book).find("price").text() + "</div></div>"
		);				
		
		btnPrevious.disabled = (c == 1);
		btnNext.disabled = (c == length);
		
		btnPrevious.onclick = () => showBook(--c);
		btnNext.onclick = () => showBook(++c);					
	})(1);				
});
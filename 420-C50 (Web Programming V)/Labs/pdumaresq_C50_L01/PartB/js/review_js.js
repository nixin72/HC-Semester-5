document.getElementById("submitButton").addEventListener("click", function (event) {
	document.querySelectorAll("form input[type=text]").forEach((el, key) => {
		if (el.value == "" || el.value == null || el.value == undefined) {
			document.getElementById("errorList").innerHTML += "- Please fill in your " 
				+ (el.id) + ((event.preventDefault()) ? "<br />" : "<br />"); 
			document.getElementsByTagName("form")[0].style.backgroundColor = "#ccc";
		}
	});
});
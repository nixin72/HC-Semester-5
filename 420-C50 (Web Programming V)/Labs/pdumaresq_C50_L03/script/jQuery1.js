$("main").fadeOut(0);
$("button").click(() => {
	$("main").load("files/lorem.txt").fadeIn(3000);
});	
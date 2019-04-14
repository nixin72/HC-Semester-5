$(document).ready(function(){
	
	$(".hasSubMenu").on("click", function(){
		$(".linkItemVisible").toggleClass("linkItemInvisible linkItemVisible");
		$(this).find(".linkItemInvisible").toggleClass("linkItemInvisible linkItemVisible");
		
		$(this).on("mouseleave", function(){
			$(this).off("mouseleave");
			$(this).find(".linkItemVisible").toggleClass("linkItemInvisible linkItemVisible");
		});
	});
	
});
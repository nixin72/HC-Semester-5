$(function() {
	(function displayContent() {
		var url = document.URL;
		var anchor = url.substring(url.indexOf("=")+1);
		anchor = ((anchor == "" || anchor == null || anchor == undefined || anchor == url) ? "index" : anchor);
		$("title").text(function() {
			return "PEA - " + (
				$(".content #" + anchor + " h2:first-child").text() == "Introduction" ? 
				"Home" : $(".content #" + anchor + " h2:first-child").text()
			); 
		});
		$(".content #" + anchor).show();		
		
		$.each(document.querySelectorAll("#banner-bottom * a"), (key, val) => {
			if (val.className == "") 
				val.addEventListener("click", ()=>{ location.reload(); });
		});
	})();
	
	(function() {
		function checkResize() {
			$("#pea").text($(window).width() <= 7668 ? "PEA - ANON" : "Program Exit Assessment");
			
			if ($(window).width() <= 767) {
				$("#banner-navbar").addClass("navbar-fixed-top");				
				imgLogo.height = 25;
				imgLogo.width = 25;
			}
			else {
				$("#banner-navbar").removeClass("navbar-fixed-top");
				imgLogo.height = 50;
				imgLogo.width = 50;
			}
		}
		
		checkResize();
		$(window).resize(() => checkResize());
	})();
	
	$("#imgTop").click(() => $("html, body").animate({ scrollTop: 0 }, "medium")); //window.scroll(0,0);
	
	$(document).scroll(function() {
		if ($("#banner-bottom").is(":visible")) 
			$("#banner-bottom").addClass("navbar-hide") 
				&& document.getElementById("navbar-burger").classList.toggle("change") 
				|| $("#banner-bottom").removeClass("change");
	});
	
	$(".navbar-burger").click(() => {
		document.getElementById("navbar-burger").classList.toggle("change");
		
		if ($("#banner-bottom").is(":visible")) {
			$("#banner-bottom").addClass("navbar-hide").removeClass("change");
		}
		else {
			$("#banner-bottom").removeClass("navbar-hide change").addClass("change");
		}			
	});
});	
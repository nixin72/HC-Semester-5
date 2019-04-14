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
			
		if ($($("#navbar-link-" + anchor).parent()[0]).parent()[0].classList.contains("dropdown-menu")) 
			$($($("#navbar-link-" + anchor).closest(".nested")).children()[0]).addClass("active-page")
				&& $("#navbar-link-" + anchor).addClass("active-page")			
				&& $("." + $("#navbar-link-" + anchor).attr("class").split(' ')[0]).each((key, el) => 
					$(el).hover(() => $($($("#navbar-link-" + anchor).closest(".nested")).children()[0]).removeClass("active-page"), 
						() => $($($("#navbar-link-" + anchor).closest(".nested")).children()[0]).addClass("active-page")));
		else 
			$("#navbar-link-" + anchor).addClass("active-page");
		
		$(".content #" + anchor).show();		
		
		$.each(document.querySelectorAll("#banner-bottom * a"), (key, val) => {
			if (val.className == "") 
				val.addEventListener("click", ()=>{ location.reload(); });
		});
	})();
	
	(function() {
		function checkResize() {
			$("#pea").text($(window).width() <= 768 ? "PEA - Philip Dumaresq" : "Program Exit Assessment");
			
			if ($(window).width() <= 767) {
				$("#banner-navbar").addClass("navbar-fixed-top") 
					&& $("#banner-bottom").addClass("change");
				imgLogo.height = imgLogo.width = 25;
			}
			else {
				$("#banner-navbar").removeClass("navbar-fixed-top") 
					&& $("#banner-bottom").removeClass("change");
				imgLogo.height = imgLogo.width = 50;
			}
		}
		
		checkResize();
		$(window).resize(() => checkResize());
	})();
	
	$("#imgTop").click(() => $("html, body").animate({ scrollTop: 0 }, "medium"));
	
	$(document).scroll(function() {
		if ($("#banner-bottom").is(":visible")) 
			$("#banner-bottom").addClass("navbar-hide") 
				&& document.getElementById("navbar-burger").classList.remove("change") 
				|| $("#banner-bottom").removeClass("change");
	});
	
	$(".navbar-burger").click(() => {
		document.getElementById("navbar-burger").classList.toggle("change");
		
		if ($("#banner-bottom").is(":visible")) {
			$("#banner-bottom").addClass("navbar-hide").removeClass("change");
		}
		else {
			$("#banner-bottom").removeClass("navbar-hide").addClass("change");
		}			
	});
});
"use strict";

//the banner is js fail-safe meaning it still looks and works ok witout javascript
$('head').first().append(
	'<style type="text/css">' +
		'/*js only style*/'+
		'#nav-container > .nav-links > .nav-links-sub {display: none;}'+
		'#nav-container > .nav-links > .nav-sub-container {display: inline-block !important;}'+
		'#nav-container > .nav-links {position: relative;}'+
		'#nav-container > .nav-links > .nav-links-sub {position: absolute;top: 100%; }'+
		'main#main-content {margin-top:0em; position:absolute; z-index: -2; overflow-y: visible;}' +
		'nav#nav-bar {position:fixed;}' +
	'</style>'
);
$("#main-content").attr("style",null);
$('.nav-links-sub').attr("jsenabled","true");

//menu expantion management
let lastMenu;
let lastFocused;
let closeMenu = function() {
	$('main').unbind('click',closeMenu);
	if (lastMenu) {
		lastMenu.stop(true).slideUp('fast')
		lastMenu = null;
	}
	if (lastFocused) {
		lastFocused.focus(focusHandlder).mouseenter(focusHandlder);
		lastFocused = null;
	}
}

let focusHandlder = function(ev) {
	closeMenu();
	$('main').click(closeMenu);
	lastFocused = $(ev.target).unbind("focus",focusHandlder).unbind("mouseenter",focusHandlder);
	lastMenu = $('#nav-sub-menu-' + lastFocused.attr('menu')).stop(true).slideDown('fast');//.mouseleave(mouseLeaveHandler);
};
$(".nav-sub-container").focus(focusHandlder).mouseenter(focusHandlder);

let lastScrollTop = 0;
let scrollHandler = function(ev){
	let st = $(this).scrollTop();
	let head = $('nav#nav-bar');
	if(! head.attr("style")){
			head.attr("style","transform: translateY(0em);");
	}
	head.css("transform",' translateY(' + (Math.max(-2.5,Math.min(0, -parseFloat(head.attr('style').replace(/[^0-9.]/g,"")) - ((st - lastScrollTop)/17.5)))) + "em)");
	lastScrollTop = st;
}
$(document).scroll(scrollHandler);
$('main#main-content').css('top',$('nav#nav-bar').outerHeight()+'px');

$(window).resize(function(ev){
	$('main#main-content').css('top',$('nav#nav-bar').outerHeight()+'px');
});

/**
 * Created by Andrew on 8/26/2017.
 */
$("document").ready(function() {

  // Initialize collapse button
  $(".button-collapse").sideNav();
  // Initialize collapsible (uncomment the line below if you use the dropdown variation)
  $('.collapsible').collapsible();
  $('.button-collapse').sideNav({
    menuWidth: 250,
    edge: 'left', // Choose the horizontal origin
    closeOnClick: true, // Closes side-nav on <a> clicks,
    draggable: true, // Choose whether you can drag to open on touch screens,
    onOpen: function(el) { /* Do Stuff*/ }, // A function to be called when sideNav is opened
    onClose: function(el) { /* Do Stuff*/ }, // A function to be called when sideNav is closed
  });

  //Function in order to change the icon
  $("li ul").click(function(e) {
    var target = $(e.target);
    if (target[0].children.length != 0) {
      var icon = ($(target).find('i').valueOf());
      var iconText = $(e.target).find('i').valueOf()[0].innerHTML;
      var newIconText = "";
      if (iconText == "arrow_drop_down") {
        newIconText = "arrow_drop_up";

      } else
      if (iconText == "arrow_drop_up")
        newIconText = "arrow_drop_down";
      $(e.target).find('i').valueOf()[0].innerHTML = newIconText;
    } else {
      if (target[0].innerHTML == "arrow_drop_up") {
        target[0].innerHTML = "arrow_drop_down";
      } else if (target[0].innerHTML == "arrow_drop_down") {
        target[0].innerHTML = "arrow_drop_up";
      }

    }


  });

  $(window).bind('scroll', function() {
    if ($(window).scrollTop() < 600) {
      $('#scrollTop').fadeOut(300);
    } else {
      $('#scrollTop').fadeIn(300);
      $("#scrollTop").removeClass("hideScroll");
    }


  });
  $('#scrollTop').click(function(){
    $("html, body").animate({ scrollTop: 0 }, 600);
    return false;
});


});

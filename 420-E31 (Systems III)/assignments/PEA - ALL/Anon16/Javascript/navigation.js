$(document).ready(function () {
    if ($(window).width() < 752) {
        $("#navigationBar").addClass("navbar-fixed-top");
        $("#navigationBar").removeClass("navbar-static-top");
    }
    else if ($(window).width() >= 752) {
        $("#navigationBar").removeClass("navbar-fixed-top");
        $("#navigationBar").addClass("navbar-static-top");

    }
    $(window).on('resize', function () {
        var win = $(this);
        if (win.width() < 752) {
            $("#navigationBar").addClass("navbar-fixed-top");
            $("#navigationBar").removeClass("navbar-static-top");

        } else if ($(window).width() >= 752) {
            $("#navigationBar").removeClass("navbar-fixed-top");
            $("#navigationBar").addClass("navbar-static-top");

        }
    });
});


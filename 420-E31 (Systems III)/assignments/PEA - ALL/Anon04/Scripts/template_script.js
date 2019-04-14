 $("#menu-toggle").click(function (e) {
    e.preventDefault();
    $("#wrapper").toggleClass("toggled");
  });


  $('#btnGoUp').on('click', function () {

    $("html, body").animate({ scrollTop: 0 }, 300);
  });

  function scrollMeUp(elem, position) {
    $(elem).scrollTop(position);
    console.log($(elem).scrollTop());
  }

  function detectScrollDirection() {

    var lastScrollTop = 0;
    $(window).scroll(function (event) {
      var st = $(this).scrollTop();
      if (st > lastScrollTop) {
        // downscroll code
        $(".banner").css({ "margin-top": "-100px" });

      } else {
        // upscroll code
        $(".banner").css({ "margin-top": "0px", "transition": "0.3s" });

      }
      lastScrollTop = st;
    });
  }

  
  $(document).ready(function () {

    detectScrollDirection();

  });

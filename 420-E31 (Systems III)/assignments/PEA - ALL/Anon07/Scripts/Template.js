/**
 * Created by 6126385 on 8/28/2017.
 */

$(document).ready(function() {
    $(".listItems").click(
        function(){
            $(".sublists", this).stop(true).slideToggle(400);

            var src = $(".icon", this).stop(true,true).attr("src");

            $(".icon", this).fadeToggle(200, function(){
                if(src == "../Media/Images/expand-button.png"){
                    $(this).attr("src", "../Media/Images/minus-button.png").fadeIn(200);
                }
                if(src == "../Media/Images/minus-button.png"){
                    $(this).attr("src", "../Media/Images/expand-button.png").fadeIn(200);
                }
            });
        }
    );
});
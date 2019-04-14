var ChangeContent = function(index){
    document.getElementById("Content").innerHTML = content[index];
    document.getElementById("Navigation").innerHTML = nav;
};

// var HambergerFunction = function(){
//     var ele = document.getElementById("Hamburger");
//     if (ele.className.indexOf("w3-show") == -1)
//     {
//         ele.className += " w3-show";
//     }
//     else
//     {
//         ele.className = ele.className.replace(" w3-show","");
//     }
//
// };

document.getElementById("Banner").innerHTML = banner;
document.getElementById("Navigation").innerHTML = nav;
document.getElementById("Content").innerHTML = Introduction;
document.getElementById("Footer").innerHTML = footer;

var content = {"Analysis":Analysis,
    "AppliedExperience":AppliedExperience,
    "Communications":Communications,
    "Deployment":Deployment,
    "Design":Design,
    "Implementation":Implementation,
    "Introduction":Introduction,
    "Maintenance":Maintenance,
    "PEAProject":PEAProject,
    "Process":Process,
    "ProjectManagement":ProjectManagement,
    "Requirements":Requirements,
    "TeamEnvironment":TeamEnvironment,
    "Test":Test,
    "Training":Training};



// var ele = document.getElementsByClassName("w3-button");
// for (var i=0; i < ele.length; i++)
// {
//     var myele = ele[i];
//     myele.onclick = myalert(myele.value);
// }


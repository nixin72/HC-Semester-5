function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
    document.body.style.backgroundColor = "#546d6e";
    document.getElementById("content").style.backgroundColor = "#e5e5e8"
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.body.style.backgroundColor = "#A8DADC";
    document.getElementById("content").style.backgroundColor = "#F8F8FF"
}

function opnCon() {
    document.getElementById("ConstructionDrop").classList.toggle("show");
}
function opnIni() {
    document.getElementById("InitiationDrop").classList.toggle("show");
}
function opnRelese() {
    document.getElementById("ReleaseDrop").classList.toggle("show");
}

window.onclick = function (event) {
    if (!event.target.matches('.dropbtn')) {

        var dropdowns = document.getElementsByClassName("dropdown-content");
        var i;
        for (i = 0; i < dropdowns.length; i++) {
            var openDropdown = dropdowns[i];
            if (openDropdown.classList.contains('show')) {
                openDropdown.classList.remove('show');
            }
        }
    }
}
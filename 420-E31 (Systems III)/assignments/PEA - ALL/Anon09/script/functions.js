// JavaScript Document

document.getElementById("burgerIcon").addEventListener("click", function() {
    var x = document.querySelector(".navBar");

    if(x.style.display === 'flex'){
        x.style.display = 'none';
    } else {
        x.style.display = 'flex';
    }
});


document.getElementById("initTopMenu").addEventListener("click", function() {
    var x = document.querySelector(".initSubMenu");

    if(x.style.display === 'unset'){
        x.style.display = 'none';
    } else {
        x.style.display = 'unset';
    }
});

document.getElementById("conTopMenu").addEventListener("click", function() {
    var x = document.querySelector(".conSubMenu");

    if(x.style.display === 'unset'){
        x.style.display = 'none';
    } else {
        x.style.display = 'unset';
    }
});

document.getElementById("relTopMenu").addEventListener("click", function() {
    var x = document.querySelector(".relSubMenu");

    if(x.style.display === 'unset'){
        x.style.display = 'none';
    } else {
        x.style.display = 'unset';
    }
});
//
//
$(function () {
    var today = new Date();

    $("#in_Dates").datepicker({
        dateFormat: "yy-mm-dd",
        altField: "#in_Calendar",
        minDate: today,
        onSelect: function (selectedDate) {
            $("#out_Dates").datepicker("option", "minDate", selectedDate);
        }
    });

    $("#out_Dates").datepicker({
        dateFormat: "yy-mm-dd",
        altField: "#out_Calendar",
        minDate: null,
        beforeShow: function(input, inst) {
            if (!$("#in_Dates").datepicker("getDate")) {
                return false;
            }
        }
    });
});

let slideIndex = 0;
showSlides();

function showSlides() {
    let slides = document.getElementsByClassName("slide");
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}
    slides[slideIndex - 1].style.display = "block";
    setTimeout(showSlides, 10000);
}

function plusSlides(n) {
    let slides = document.getElementsByClassName("slide");
    slideIndex += n;
    if (slideIndex > slides.length) {slideIndex = 1}
    if (slideIndex < 1) {slideIndex = slides.length}
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slides[slideIndex - 1].style.display = "block";
}

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});


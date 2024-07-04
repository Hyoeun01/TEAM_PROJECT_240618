let slideIndex = 0;
showSlides();

function showSlides() {
    let slides = document.getElementsByClassName("slide");
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";  
    }
    slideIndex++;
    if (slideIndex > slides.length) {slideIndex = 1}    
    slides[slideIndex-1].style.display = "block";  
    setTimeout(showSlides, 10000); // Change image every 10 seconds
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

$(document).ready(function() {
    $("#in_Dates").click(function() {
        $("#in_Calendar").toggle();
    });

    $("#in_Calendar").datepicker({
        onSelect: function(dateText, inst) {
            $("#in_Dates").val(dateText);
            $("#in_Calendar").hide();
        }
    });
});

$(document).ready(function() {
    $("#out_Dates").click(function() {
        $("#out_Calendar").toggle();
    });

    $("#out_Calendar").datepicker({
        onSelect: function(dateText, inst) {
            $("#out_Dates").val(dateText);
            $("#out_Calendar").hide();
        }
    });
});
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
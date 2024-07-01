// let slideIndex = 0;
// showSlides();
//
// function showSlides() {
//     let slides = document.getElementsByClassName("slide");
//     for (let i = 0; i < slides.length; i++) {
//         slides[i].style.display = "none";
//     }
//     slideIndex++;
//     if (slideIndex > slides.length) {slideIndex = 1}
//     slides[slideIndex-1].style.display = "block";
//     setTimeout(showSlides, 10000); // Change image every 10 seconds
// }
//
// function plusSlides(n) {
//     let slides = document.getElementsByClassName("slide");
//     slideIndex += n;
//     if (slideIndex > slides.length) {slideIndex = 1}
//     if (slideIndex < 1) {slideIndex = slides.length}
//     for (let i = 0; i < slides.length; i++) {
//         slides[i].style.display = "none";
//     }
//     slides[slideIndex-1].style.display = "block";
// }
//
// $(document).ready(function() {
//     $("#in_Dates").click(function() {
//         $("#in_Calendar").toggle();
//     });
//
//     $("#in_Calendar").datepicker({
//         onSelect: function(dateText, inst) {
//             $("#in_Dates").val(dateText);
//             $("#in_Calendar").hide();
//         }
//     });
// });
//
// $(document).ready(function() {
//     $("#out_Dates").click(function() {
//         $("#out_Calendar").toggle();
//     });
//
//     $("#out_Calendar").datepicker({
//         onSelect: function(dateText, inst) {
//             $("#out_Dates").val(dateText);
//             $("#out_Calendar").hide();
//         }
//     });
// });
//---------------------------------------------------위에는 수정 전
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

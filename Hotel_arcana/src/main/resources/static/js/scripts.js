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
            var selectedDateObj = new Date(selectedDate);
            var nextDay = new Date(selectedDateObj.getTime() + 24 * 60 * 60 * 1000);
            $("#out_Dates").datepicker("option", "minDate", nextDay);
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


function calculateDaysBetweenDates(checkInDate, checkOutDate) {
    // Parse the dates from the input strings
    const checkIn = new Date(checkInDate);
    const checkOut = new Date(checkOutDate);

    // Calculate the difference in time (in milliseconds)
    const timeDifference = checkOut.getTime() - checkIn.getTime();

    // Calculate the difference in days
    const daysDifference = timeDifference / (1000 * 3600 * 24);

    // Return the number of days as an integer
    return Math.round(daysDifference);
}

// Function to update the number of days in the DOM
function updateDaysDifference() {
    const checkInDate = document.getElementById('in_Dates').value;
    const checkOutDate = document.getElementById('out_Dates').value;

    if (checkInDate && checkOutDate) {
        const daysDifference = calculateDaysBetweenDates(checkInDate, checkOutDate);
        document.querySelector('.ROOM_PRICE strong').innerText = `${daysDifference}일/1박`;
    }
}

// Add event listeners to update the days difference when dates are selected
document.getElementById('in_Dates').addEventListener('change', updateDaysDifference);
document.getElementById('out_Dates').addEventListener('change', updateDaysDifference);


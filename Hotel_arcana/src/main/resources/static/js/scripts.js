/*!
* Start Bootstrap - Simple Sidebar v6.0.5 (https://startbootstrap.com/template/simple-sidebar)
* Copyright 2013-2022 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-simple-sidebar/blob/master/LICENSE)
*/
// 
// Scripts
// 

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

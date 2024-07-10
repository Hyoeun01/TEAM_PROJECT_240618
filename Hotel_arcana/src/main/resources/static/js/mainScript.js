
let slideIndex1 = 0;
showSlides1();

function showSlides1() {
    let slides = document.getElementsByClassName("slide2");
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slideIndex1++;
    if (slideIndex1 > slides.length) {slideIndex1 = 1}
    slides[slideIndex1 - 1].style.display = "block";
    setTimeout(showSlides1, 3000);
}

function plusSlides1(n) {
    let slides = document.getElementsByClassName("slide2");
    slideIndex1 += n;
    if (slideIndex1 > slides.length) {slideIndex1 = 1}
    if (slideIndex1 < 1) {slideIndex1 = slides.length}
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    slides[slideIndex1 - 1].style.display = "block";
}

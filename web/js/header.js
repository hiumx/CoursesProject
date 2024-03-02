
const navbarIconElement = document.querySelector('.header__bars__icon');
const navbarElement = document.querySelector('.header__nav');
const navCloseBtn = document.querySelector('.nav__close__icon');

navbarIconElement.onclick = function() {
    navbarElement.style.transform = 'translateX(0)';
};

navCloseBtn.onclick = function() {
    navbarElement.style.transform = 'translateX(-100%)';
};
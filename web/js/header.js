
const navbarIconElement = document.querySelector('.header__bars__icon');
const navbarElement = document.querySelector('.header__nav');
const navCloseBtn = document.querySelector('.nav__close__icon');
const overElement = document.querySelector('#over');

navbarIconElement.onclick = function() {
    navbarElement.style.transform = 'translateX(0)';
    navbarElement.style.opacity = '1';
    overElement.classList.add('overlay');
};

navCloseBtn.onclick = function() {
    navbarElement.style.transform = 'translateX(-100%)';
    navbarElement.style.opacity = '0';
    overElement.classList.remove('overlay');
};

overElement.onclick = function () {
    navbarElement.style.transform = 'translateX(-100%)';
    navbarElement.style.opacity = '0';
    overElement.classList.remove('overlay');
};

const navbarIconElement = document.querySelector('.header__bars__icon');
const navbarElement = document.querySelector('.header__nav');
const navCloseBtn = document.querySelector('.nav__close__icon');
const overElement = document.querySelector('#over');
const userIconElement = document.querySelector('.header__profile__icon');
const userDetailElement = document.querySelector('.header__profile__detail');


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


userIconElement.onclick = function () {
    if(userDetailElement.style.display === 'block') {
        userDetailElement.style.display = '';
    } else if (userDetailElement.style.display === '') {
        userDetailElement.style.display = 'block';
    }
};
//

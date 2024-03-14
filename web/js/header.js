
const navbarIconElement = document.querySelector('.header__bars__icon');
const headerElement = document.querySelector('.header__content__wrapper');
const navbarElement = document.querySelector('.header__nav');
const navCloseBtn = document.querySelector('.nav__close__icon');
const overElement = document.querySelector('#over');
const userIconElement = document.querySelector('.header__profile__icon');
const userDetailElement = document.querySelector('.header__profile__detail');
const profileCoursesElement = document.querySelector('.header__profile__courses');
const profileCoursesDetail = document.querySelector('.header__profile__courses__detail');


navbarIconElement.onclick = function() {
    navbarElement.style.transform = 'translateX(0)';
    navbarElement.style.opacity = '1';
    overElement.classList.add('overlay');
    document.body.style.overflow = 'hidden';
    document.body.style.paddingRight = "17px";
    headerElement.style.marginRight = "17px";
};

navCloseBtn.onclick = function() {
    navbarElement.style.transform = 'translateX(-100%)';
    navbarElement.style.opacity = '0';
    overElement.classList.remove('overlay');
     document.body.style.overflow = 'auto';
    document.body.style.paddingRight = "0";
    headerElement.style.marginRight = "0";
};

overElement.onclick = function () {
    navbarElement.style.transform = 'translateX(-100%)';
    navbarElement.style.opacity = '0';
    overElement.classList.remove('overlay');
     document.body.style.overflow = 'auto';
    document.body.style.paddingRight = "0";
    headerElement.style.marginRight = "0";
};


userIconElement.onclick = function () {
    if(userDetailElement.style.display === 'block') {
        userDetailElement.style.display = '';
    } else if (userDetailElement.style.display === '') {
        userDetailElement.style.display = 'block';
    }
};

profileCoursesElement.onclick = function () {
    if(profileCoursesDetail.style.display === 'block') {
        profileCoursesDetail.style.display = '';
    } else if (profileCoursesDetail.style.display === '') {
        profileCoursesDetail.style.display = 'block';
    }
};

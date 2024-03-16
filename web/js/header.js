
const navbarIconElement = document.querySelector('.header__bars__icon');
const headerElement = document.querySelector('.header__content__wrapper');
const navbarElement = document.querySelector('.header__nav');
const navCloseBtn = document.querySelector('.nav__close__icon');
const overElement = document.querySelector('#over');
const userIconElement = document.querySelector('.header__profile__icon');
const userDetailElement = document.querySelector('.header__profile__detail');
const profileCoursesElement = document.querySelector('.header__profile__courses');
const profileCoursesDetail = document.querySelector('.header__profile__courses__detail');
const headerSearchInput = document.querySelector('.header__search');
const headerResultSearch = document.querySelector('.header__search__result');
const listResultSearch = document.querySelector('.header__search__result__list');
const textSearch = document.querySelector('.header__search__keyword');
const searchInput = document.getElementById("header__search");


navbarIconElement.onclick = function () {
    navbarElement.style.transform = 'translateX(0)';
    navbarElement.style.opacity = '1';
    overElement.classList.add('overlay');
    document.body.style.overflow = 'hidden';
    document.body.style.paddingRight = "17px";
    headerElement.style.marginRight = "17px";
};

navCloseBtn.onclick = function () {
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

function search() {
    var keyword = searchInput.value;
    if (keyword.length > 0) {
        headerResultSearch.style.display = 'block';
        textSearch.innerHTML = `<span>Kết quả cho "${keyword}"</span>`;
    } else if (keyword.length === 0) {
        headerResultSearch.style.display = 'none';
    }
    $.ajax({
        type: "GET",
        url: '/courses/search-courses',
        data: {term: keyword},
        success: function (response) {
            const {listCoursesItem, listBlogsItem} = splitStringbyLiTag(response);
            if (listCoursesItem.length === 0) {
                $('#search-result-courses').html("<p class=\"header__search__not__found\">Không tìm thấy khóa học phù hợp.</p>");
            } else {
                $('#search-result-courses').html(listCoursesItem);
            }
            if (listBlogsItem.length === 0) {
                $('#search-result-blogs').html("<p class=\"header__search__not__found\">Không tìm thấy bài viết phù hợp.</p>");
            } else {
                $('#search-result-blogs').html(listBlogsItem);
            }
        }
    });
}

const splitStringbyLiTag = string => {
    const listItems = string.split("<li ");
    const listCoursesItem = [];
    const listBlogsItem = [];
    for (var i = 0; i < listItems.length; i++) {
        if (listItems[i].includes('courses')) {
            listCoursesItem.push(`<li ${listItems[i]}`);
        } else if (listItems[i].includes('blogs')) {
            listBlogsItem.push(`<li ${listItems[i]}`);
        }
    }
    return {
        listCoursesItem,
        listBlogsItem
    };
};
//
const handleClickOutsideElement = (e1, e2) => {
    document.addEventListener('click', e => {
        if (!e1.contains(e.target)) 
            e1.style.display = 'none';
        if (e2.contains(e.target)) {
            e1.style.display = 'block';
        } else if (e2.contains(e.target)) {
            e1.style.display = 'none';
        }
    });
};

handleClickOutsideElement(profileCoursesDetail, profileCoursesElement);
handleClickOutsideElement(userDetailElement, userIconElement);


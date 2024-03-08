const addNewUserElement = document.querySelector('.add-new-user-btn');

addNewUserElement.onclick = () => {
    window.location = '/management/users/add-user';
};

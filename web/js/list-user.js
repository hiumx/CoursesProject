const addNewUserElement = document.querySelector('.add-new-user-btn');

addNewUserElement.onclick = () => {
    console.log('hi');
    window.location = '/management/users/add-user';
};
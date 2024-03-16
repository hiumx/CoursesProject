const passwordInput = document.querySelector('#password');
const confirmPasswordInput = document.querySelector('#confirm-password');
const handleShowPassword = () => {
    if (passwordInput.type === 'password')
        passwordInput.type = 'text';
    else
        passwordInput.type = 'password';
};
const addNewBlogBtn = document.querySelector('.add-new-blog-btn');
const allBlogBtn = document.querySelector('.all-blog-btn');
const pendingBlogBtn = document.querySelector('.pending-blog-btn');
const listConfirmedBlogBtn = document.querySelector('.confirmed-blog-btn');

addNewBlogBtn.onclick = () => {
    window.location = '/management/blogs/add-blog';
};

allBlogBtn.onclick = () => {
    window.location = '/management?type=blog';
};

pendingBlogBtn.onclick = () => {
    window.location = '/management?type=blog&status=pending';
};

listConfirmedBlogBtn.onclick = () => {
    window.location = '/management?type=blog&status=confirmed';
};
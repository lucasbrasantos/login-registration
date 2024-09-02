


const submitButton = document.querySelector('#b1');
submitButton.addEventListener('click', function(event) {

    const username = document.querySelector('#username').value;
    const email = document.querySelector('#email').value;
    const password = document.querySelector('#password').value;
    const confirmPassword = document.querySelector('#confirmPassword').value;

    const data = {
        username: username,
        email: email,
        password: password,
    };

    if (password == confirmPassword) {
        fetch('/signup', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
        .then(response => response.json())
        .then(data => {
            console.log(data);
        })
        .catch(error => {
            console.error(error);
        });
    }else{
        alert("Passwords do not match");
    }
});
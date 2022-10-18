function login() {
    if (email.value.length > 0 && senha.value.length > 0) {

        let credenciais = {
            "username": document.querySelector("#email").value,
            "password": document.querySelector("#senha").value,
        }

        const options = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' }
        };

        options.body = JSON.stringify(credenciais);

        fetch("https://patrimoniomongo.herokuapp.com/login", options)
        .then(resp => resp.status)
        .then(resp => {
                if (resp == 200) {
                    window.location.href = "./home.html";
                }
                else {
                    document.querySelector(".trataErro").classList.remove("model")    
                }
        });
    };
};
function login() {
    let usuario = document.querySelector("#user");
    let senha = document.querySelector("#password");
    if (usuario.value.length > 0 && senha.value.length > 0) {
        let achou = false;
        fetch("https://jsonplaceholder.typicode.com/users").then((response) => {
        return response.json();
        }).then((usuarios) => {
                usuarios.forEach(user => {
                    if (user.email == usuario.value && user.username == senha.value) {
                        achou = true;

                        let infoUser = {
                                "id":user.id,
                                "name":user.name
                                };

                        window.localStorage.setItem("userData", JSON.stringify(infoUser));
                        window.location.href = "../exercicio/post.html?usuario=" + user.name;
                    }
                });
                if (!achou) {
                    document.querySelector(".trataErro").classList.remove("model")    
                }
        });
    };
};
function login() {
    let usuario = document.querySelector("#user");
    let senha = document.querySelector("#password");
    if (usuario.value.length > 0 && senha.value.length > 0) {
        let achou = false;
        fetch("https://jsonplaceholder.typicode.com/users").then((response) => {
        return response.json();
        }).then((data) => {
                data.forEach(users => {
                    if (users.email == usuario.value && users.username == senha.value) {
                        achou = true;
                        
                        let infoUser = JSON.stringify(
                            [   
                                {
                                    "id":users.id,
                                    "name":users.name
                                }
                             ]);
                        window.localStorage.setItem("userData", infoUser);
                        window.location.href = "./post.html?usuario=" + users.name;
                    };
                });
                if (!achou) {
                    document.querySelector(".trataErro").classList.remove("model")    
                }
        });
    };
};

function load() {
    let nomeU = document.querySelector("#nameU");
    let info = window.localStorage.getItem("userData");
    let convertJSON = JSON.parse(info);

    fetch("https://jsonplaceholder.typicode.com/posts").then((response) => {
    return response.json();
    }).then((data) => {
    data.forEach(posts => {
        nomeU.append(convertJSON.name);
        let novoCard = document.querySelector(".card-post").cloneNode(true);
        novoCard.classList.remove("model");
    
        novoCard.querySelector("#title").append(posts.title);
        novoCard.querySelector("#body").append(posts.body);

        document.querySelector(".container").appendChild(novoCard);
        })
    });
}
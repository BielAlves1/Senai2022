const usuarios = [
    {
        "usuario":"shrekão",
        "senha":"123",
        "imagem":"../img/shrek.png"
    },
    {
        "usuario":"SeilaMano",
        "senha":"777",
        "imagem":""
    },
    {
        "usuario":"Mike",
        "senha":"666",
        "imagem":""
    }
]

const produtos = [
    {
        nome: "Vestido Sodré",
        preco: "R$ 16,00",
        imagem: "../img/naosei.png"
    },
    {
        nome: "Vestido Longo Vinho",
        preco: "R$ 29,90",
        imagem: "../img/naosei.png"
    },
    {
        nome: "Vestido Amy Back to Black",
        preco: "R$ 20,00",
        imagem: "../img/naosei.png"
    },
    {
        nome: "Vestido Midi Linho Assimétrico Com Fenda",
        preco: "R$ 10,95",
        imagem: "../img/naosei.png"
    },
    {
        nome: "Vestido Festa Longo Ondas Brilho",
        preco: "R$ 25,00",
        imagem: "../img/naosei.png"
    },
    {
        nome: "Vestido Longo Marinho Uruguai",
        preco: "R$ 23,00",
        imagem: "../img/naosei.png"
    }
]

function login() {
    let username = document.querySelector("#user");
    let senha = document.querySelector("#password");
    if (username.value.length > 0 && senha.value.length > 0) {
        let achou = false
        usuarios.forEach(u => {
            if (u.usuario == username.value && u.senha == senha.value) {
                window.location.href = "./home.html?usuario=" + u.username;
                achou = true;
            };
        });
        if (!achou) {
            document.querySelector(".trata").classList.remove("model")    
        }
        
    };
};

function load() {
    if (window.location.search.length > 0) {
        produtos.forEach(prod => {
            let novoProduto = document.querySelector(".modelo").cloneNode(true);

            novoProduto.querySelector(".prod-card-image").style.backgroundImage = "url(" + prod.imagem + ")";
            novoProduto.querySelector("#nomeP").innerHTML = prod.nome;
            novoProduto.querySelector("#precoP").innerHTML = prod.preco;
            novoProduto.classList.remove("modelo");
    
            document.querySelector(".container").appendChild(novoProduto);
        });

        var url = new URLSearchParams(window.location.search);
        usuarios.forEach(user => {
            if (user.username == url.get('username')) {
                document.querySelector(".nomeUser").innerHTML = user.usuario;
                document.querySelector(".fotoUser").style.backgroundImage = "url(" + user.imagem + ")";
            }
        });

        

    } else {
        window.location = "../index.html";
    }
}
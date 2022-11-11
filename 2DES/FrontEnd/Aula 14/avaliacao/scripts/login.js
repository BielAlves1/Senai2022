const nome = document.querySelector("#nome").value;
const senha = document.querySelector("#senha").value;

function login() {
    let credenciais = {
        "nome": nome,
        "senha": senha,
    }

    const options = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' }
    };

    options.body = JSON.stringify(credenciais);

    fetch("http://10.87.207.2:3000/login", options)
        .then(resp => resp.status)
        .then(resp => {
            if (resp == 200) {
                if(resp.erro === undefined) {
                    localStorage.setItem("info", JSON.stringify({"nome":resp.nome, "senha":resp.senha}));
        
                    window.location.href = "./home.html";
                }
            }
            else {
                document.querySelector(".trataErro").classList.remove("model")
            }
        });
};
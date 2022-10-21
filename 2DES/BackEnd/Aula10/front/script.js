const uri = 'http://localhost:5000/usuarios';
var dados = [];

function load() {
    const options = { method: 'GET' };
    fetch(uri, options)
        .then(resp => resp.json())
        .then(resp => {
            dados = resp;
            montarCards();
        })
        .catch(err => alert("Erro ao carregar dados do BD:" + err));
}

function montarCards() {
    dados.forEach(e => {
        let card = document.querySelector(".item-user").cloneNode(true);
        card.classList.remove('model');

        card.querySelector("#nome").innerHTML += e.nome;
        card.querySelector("#login").innerHTML += e.login;
        card.querySelector("#nascimento").innerHTML += e.nascimento;
        card.querySelector("#telefone").innerHTML += e.telefone;
        card.querySelector("#imgUser").src = montaImg(e.avatar);
        card.querySelector("#excluir").innerHTML = `<img onClick='excluirReceita(${e.id})' />`;

        document.querySelector(".container").appendChild(card);
    });
}

function montaImg(img) {
    if (img != null) {
        return `data:image/png;base64,${img}`;
    } else
        return `./default.png`;
}

function excluirUser(login) {
    if (confirm("Confirma a exclusão do Usuário: " + login)) {
        const body = {
            "id": login
        }
        const options = {
            method: 'DELETE',
            headers: { 'Content-Type': 'application/json' },
        };
        options.body = JSON.stringify(body);
        fetch(uri, options)
            .then(resp => resp.status)
            .then(resp => {
                if (resp == 200) {
                    window.location.reload();
                }
            })
            .catch(err => alert("Erro ao enviar dados, Erro:" + err));
    }
}
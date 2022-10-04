const uri = 'http://localhost:3000/patrimonio/itens/';
var itens = [];

function carregar() {
    const options = {method: 'GET'};
    fetch(uri, options)
        .then(res => res.json())
        .then(res => {
            itens = res;
            preencherTela();
        })
        .catch(err => console.error(err));
}

function preencherTela(){
    itens.forEach(e => {
        let card = document.querySelector(".card").cloneNode(true);
        card.classList.remove("model");

        card.querySelector("#ni").innerHTML += e.ni;
        card.querySelector("#aquisicao").innerHTML += e.aquisicao;
        card.querySelector("#denominacao").innerHTML += e.denominacao;
        card.querySelector("#valor").innerHTML += e.valor;
        card.querySelector("#img").src = '../docs/assets/' + e.img;

        document.querySelector("main").appendChild(card);
    });
}

function del() {
    const options = {method: 'DELETE'};
    fetch(uri, options)
        .then(res => res.json())
        .then(res => {
            itens = res;
            preencherTela();
        })
        .catch(err => console.error(err));
}

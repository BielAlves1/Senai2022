const uri = 'http://localhost:5000/estacionamento/vagas';
const lista = document.querySelector("#lista");
var data = [];



function carregar() {
    const options = { method: 'GET' };

    fetch(uri, options)
        .then(resp => resp.json())
        .then(resp => {
            data = resp;
            preecherTabela();
        })
        .catch(err => console.error(err));
}

function preecherTabela() {
    
    data.forEach(e => {
        let l = document.createElement("tr");
        let id_vaga = document.createElement("td");
        let status_vaga = document.createElement("td");
        let descricao = document.createElement("td");
        let valor_hora = document.createElement("td");
        id_vaga.innerHTML = e.id_vaga;
        status_vaga.innerHTML = (e.status_vaga == 1) ? "Disponível" : "Indisponível";
        descricao.innerHTML = e.descricao;
        valor_hora.innerHTML = e.valor_hora;
        l.appendChild(id_vaga);
        l.appendChild(status_vaga);
        l.appendChild(descricao);
        l.appendChild(valor_hora);
        lista.appendChild(l);
    });
}
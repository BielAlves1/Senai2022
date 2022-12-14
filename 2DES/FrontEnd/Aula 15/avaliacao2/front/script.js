const uri = 'http://localhost:3000';
const invisivel = document.querySelector(".invisivel");
const desc = document.querySelector("#desc");
const mExcluir = document.querySelector("#modalExcluir");
const rb1 = document.querySelector("#rb1").value;
const rb2 = document.querySelector("#rb2").value;
const rb3 = document.querySelector("#rb3").value;
const rb4 = document.querySelector("#rb4").value;
const rb5 = document.querySelector("#rb5").value;
const rb6 = document.querySelector("#rb6").value;
const rb7 = document.querySelector("#rb7").value;
const rb8 = document.querySelector("#rb8").value;
const rb9 = document.querySelector("#rb9").value;

function load() {
    fetch(uri + '/read')
        .then((resp) => { return resp.json() })
        .then((data) => {
            data.forEach(chamado => {
                let linha = document.createElement("tr");
                let id = document.createElement("td");
                let tipo = document.createElement("td");
                let severidade = document.createElement("td");
                let descricao = document.createElement("td");
                let data = document.createElement("td");
                let horaChama = document.createElement("td");
                let horaI = document.createElement("td");
                let horaF = document.createElement("td");
                let destino = document.createElement("td");
                let editar = document.createElement("td");
                let excluir = document.createElement("td");

                id.innerHTML = chamado.id;
                tipo.innerHTML = chamado.tipo;
                severidade.innerHTML = (chamado.severidade == 1)? "Urgente" : 2? "Grave" : "Nomral";
                descricao.innerHTML = chamado.descricao;
                data.innerHTML = chamado.data;
                horaChama.innerHTML = chamado.hora;
                horaI.innerHTML = chamado.hora_inicio;
                horaF.innerHTML = chamado.hora_fim;
                destino.innerHTML = chamado.destino;
                editar.innerHTML = `<img onClick = "preparaEdit(${chamado.id})" src='./assets/editar.png' width='40px' height='40px' />`
                excluir.innerHTML = `<img onClick = "preparaExclusao(${chamado.id})" src='./assets/excluir.png' width='40px' height='40px' />`;

                linha.appendChild(id);
                linha.appendChild(tipo);
                linha.appendChild(severidade);
                linha.appendChild(descricao);
                linha.appendChild(data);
                linha.appendChild(horaI);
                linha.appendChild(horaF);
                linha.appendChild(destino);
                linha.appendChild(editar);
                linha.appendChild(excluir);

                document.querySelector('tbody').appendChild(linha);
            })
        });
}

function showModal() {
    document.querySelector(".modal").classList.remove("model")
}
function fecharModal() {
    document.querySelector(".modal").classList.add("model")
}

function preparaExclusao(id) {
    mExcluir.setAttribute('style', 'display:flex');
    invisivel.innerHTML = id;
}


function excluir(id) {
    let options = { method: 'DELETE' };

    fetch('http://localhost:3000/delete/' + id, options)
        .then(resp => resp.status)
        .then(resp => {
            if (resp == 204) {
                window.location.reload();
            } else {
                alert("Erro ao excluir: + " + resp)
            }
        });
}

function cadastrarChamado() {

    let chamado = {
        "tipo": rb1.checked == true ? rb1 : rb2.checked == true ? rb2 : rb3,
        "severidade": rb4.checked == true ? rb4 : rb5.checked == true ? rb5 : rb6,
        "descricao": desc.value,
        "destino": rb7.checked == true ? rb7 : rb8.checked == true ? rb8 : rb9,
    };
    console.log(chamado);

    fetch('http://localhost:3000/create', {
        "method":"POST",
        "headers": {
            "Content-Type": "application/json"
        },
        "body": JSON.stringify(chamado)
    })
    .then(res => {return res.json()})
    .then(resp => {
        if(resp !== undefined){
            alert("Chamado cadastrado com sucesso!");
            window.location.reload();
        }else {
            alert("Falha ao cadastrar chamado!");
        }
     });
}
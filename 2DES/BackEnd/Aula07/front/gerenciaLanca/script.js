const info = document.querySelector(".info");
const tbody = document.querySelector("#tbody1");
const tbody2 = document.querySelector("#tbody2");
const modal = document.querySelector(".modal");
const descricao = document.querySelector("#descricao");
const tipo = document.querySelector("#selectTipo");
const valor = document.querySelector("#valor");
const datasLanca = document.querySelector("#data").value;
const saldoTotal = document.querySelector("#saldoTotal");

var selectD = [];
var saldo = 0;

function loadLanca(){
    fetch("http://localhost:5000/lancamentos")
        .then(res => { return res.json() })
        .then(lancamentos => {
            selectD[0] = lancamentos[0].data.slice(0,10);
            let i = 1;
            lancamentos.forEach(lancamento => {
                if(lancamento.tipo == "D"){
                    let linha = info.cloneNode(true);

                    linha.classList.remove("model");

                    let colunas = linha.querySelectorAll("td");
                    colunas[0].innerHTML = lancamento.n_lanca;
                    colunas[1].innerHTML = lancamento.data.slice(0,10);
                    colunas[2].innerHTML = lancamento.descricao;
                    colunas[3].innerHTML = "R$ " + lancamento.valor;
                    colunas[4].innerHTML = "Saída";

                    tbody.appendChild(linha);
                    calcTotal(-lancamento.valor);
                }else {
                    let linha = info.cloneNode(true);

                    linha.classList.remove("model");

                    let colunas = linha.querySelectorAll("td");
                    colunas[0].innerHTML = lancamento.n_lanca;
                    colunas[1].innerHTML = lancamento.data.slice(0,10);
                    colunas[2].innerHTML = lancamento.descricao;
                    colunas[3].innerHTML = "R$ " + lancamento.valor;
                    colunas[4].innerHTML = "Entrada";

                    tbody2.appendChild(linha);
                    calcTotal(lancamento.valor);
                }

                if(lancamento.data.slice(0,10) != selectD[i-1]){
                    selectD[i] = lancamento.data.slice(0,10);
                    i++;
                }
            });
            saldoTotal.innerHTML = saldo.toLocaleString('pt-BR');
        });
}

function cadastrarLancamento() {
    let lancamento = {
        "descricao": descricao.value,
        "valor": valor.value,
        "tipo": tipo.value
    };
    console.log(tipo.value);

    fetch('http://localhost:5000/lancamento', {
        "method":"POST",
        "headers": {
            "Content-Type": "application/json"
        },
        "body": JSON.stringify(lancamento)
    })
    .then(res => {return res.json()})
    .then(resp => {
        if(resp !== undefined){
            alert("Lançamento cadastrado com sucesso!");
            window.location.reload();
        }else {
            alert("Falha ao cadastrar lançamento!");
        }
     });
}

function showModal() {
    modal.classList.remove("model");
}

function fecharModal(){
    modal.classList.add("model");
}

function opcoes() {
    selectD.forEach((outraData) => {
        let option = document.querySelector("#selected-data").cloneNode();
        
        option.innerHTML = outraData;
        document.querySelector("#data").appendChild(option);
    });
}

function mudar() {
    tbody.querySelectorAll('tr');
    tbody2.querySelectorAll('tr');

    for(let i = tbody2.length; i > 2; i-- ){
        document.querySelector("#tbody2").deleteRow(i-1)
    }
    for(let i = tbody.length; i > 2; i--){
        document.querySelector("#tbody1").deleteRow(i-1)
    }
    filtrar();
}

function filtrar(){
    saldo = 0;
    fetch(`http://localhost:5000/lancamentos/${datasLanca}`)
    .then(res => {return res.json()})
    .then(lancamentos => {
        lancamentos.forEach(lancamento => {
            if(lancamento.tipo == "D"){
                let linha = info.cloneNode(true);

                linha.classList.remove("model");

                let colunas = linha.querySelectorAll("td");
                colunas[0].innerHTML = lancamento.n_lanca;
                colunas[1].innerHTML = lancamento.data.slice(0,10);
                colunas[2].innerHTML = lancamento.descricao;
                colunas[3].innerHTML = "R$ " + lancamento.valor;
                colunas[4].innerHTML = "Saída";

                tbody.appendChild(linha);
                calcTotal(-lancamento.valor);
            }else {
                let linha = info.cloneNode(true);

                linha.classList.remove("model");

                let colunas = linha.querySelectorAll("td");
                colunas[0].innerHTML = lancamento.n_lanca;
                colunas[1].innerHTML = lancamento.data.slice(0,10);
                colunas[2].innerHTML = lancamento.descricao;
                colunas[3].innerHTML = "R$ " + lancamento.valor;
                colunas[4].innerHTML = "Entrada";

                tbody2.appendChild(linha);
                calcTotal(lancamento.valor);
            }
        });
        saldoTotal.innerHTML = saldo.toLocaleString('pt-BR');
    });
}

function calcTotal(valor) {
    saldo += valor;
}

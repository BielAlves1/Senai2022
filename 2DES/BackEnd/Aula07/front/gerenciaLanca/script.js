const info = document.querySelector(".info");
const tbody = document.querySelector("#tbody1");
const tbody2 = document.querySelector("#tbody2");

function loadLanca(){
    fetch("http://localhost:5000/lancamentos")
        .then(res => { return res.json() })
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
                }
            });
        });
};

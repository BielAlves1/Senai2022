const info = document.querySelector(".info");
const tbody = document.querySelector("#tbody");

function loadItens(){
    fetch("https://patrimoniomongo.herokuapp.com/read/")
        .then(res => { return res.json() })
        .then(item => {
            let linha = info.cloneNode(true);
            linha.classList.remove("model");

            let colunas = linha.querySelectorAll("td");
            colunas[0].src = item.items.img;
            colunas[1].innerHTML = item._id;
            colunas[2].innerHTML = item.ni;
            colunas[3].innerHTML = item.aquisicao;
            colunas[4].innerHTML = item.denominacao;
            colunas[5].innerHTML = "R$ " + item.valor;

            tbody.appendChild(linha);
              
    });
}

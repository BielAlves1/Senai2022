

function load() {
    fetch("http://10.87.207.2:3000/salgados")
    .then((response) => {return response.json()})
    .then((data) => {
        data.forEach(salgas => {
            let novoCard = document.querySelector(".card").cloneNode(true);
            novoCard.classList.remove("model");

            novoCard.querySelector("#imgExcluir").addEventListener("click", () => { excluir(salgas.id); })
            novoCard.querySelector("#id").innerHTML = "Id: " + salgas.id;
            novoCard.querySelector("#nome").innerHTML = "Nome: " + salgas.nome;
            novoCard.querySelector("#descricao").innerHTML = "Descrição: " + salgas.descricao;
            novoCard.querySelector("#imgSalgas").src = "../assets/" + salgas.foto;

            document.querySelector(".container").appendChild(novoCard);
        })
    });
}

function excluir(id) {
    const options = {method: 'DELETE'};

fetch('http://10.87.207.2:3000/salgado/' + id, options)
  .then(resp => resp.json())
  .then(resp => {
    window.location.reload();
  })
  
}
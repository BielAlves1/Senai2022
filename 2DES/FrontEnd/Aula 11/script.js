function alunos(){
    fetch("http://localhost:5000/academia/alunos").then((response) => {
    return response.json();
}).then((data) => {
    data.forEach(aluno => {
        let novoCard = document.querySelector(".card").cloneNode(true);
        novoCard.classList.remove("model");

        novoCard.querySelector("#idAluno").append(aluno.id_aluno);
        novoCard.querySelector("#nome").append(aluno.nome);
        novoCard.querySelector("#nascimento").append(aluno.nascimento);
        novoCard.querySelector("#sexo").append(aluno.sexo);
        novoCard.querySelector("#peso").append(aluno.peso);
        novoCard.querySelector("#telefone").append(aluno.telefone);

        document.querySelector(".container").appendChild(novoCard);
    })
});
}

function treinos(){
    fetch("http://localhost:5000/academia/treinos").then((response) => {
    return response.json();
}).then((data) => {
    data.forEach(treino => {
        let novoCard = document.querySelector(".card").cloneNode(true);
        novoCard.classList.remove("model");

        novoCard.querySelector("#idEx").append(treino.id_exercicio);
        novoCard.querySelector("#descricao").append(treino.descricao);
        novoCard.querySelector("#grupo-muscular").append(treino.grupo_muscular);
        novoCard.querySelector("#idAp").append(treino.id_aparelho);
        novoCard.querySelector("#nomeAp").append(treino.nome);

        document.querySelector(".container").appendChild(novoCard);
    })
});
}
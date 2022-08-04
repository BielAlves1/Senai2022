function cadastrar(){
    let nome = document.querySelector("#nome");
    let cargo = document.querySelector("#cargo");
    let salario = document.querySelector("#salario");

    let linha = document.createElement("tr");
    let colun = document.createElement("td");
    colun.append(nome.value);
    let colun2 = document.createElement("td");
    colun2.append(cargo.value);
    let colun3 = document.createElement("td");
    colun3.append("R$ ", salario.value);

    document.querySelector("tbody").appendChild(linha);
    linha.appendChild(colun);
    linha.appendChild(colun2);
    linha.appendChild(colun3);

    nome.value = null;
    cargo.value = null;
    salario.value = null;
}
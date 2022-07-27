
var cpf = document.querySelector("#cpf");
var quantTel = document.querySelector("#quantTel");
var quantCPF = document.querySelector("#quantCPF");

//
var btPlaca = document.querySelector("#btPlaca");
btPlaca.addEventListener("click", validarPlaca);
function validarPlaca(placa){
    placa = document.querySelector("#placa");
    let validando = false;
    let textArea = document.querySelector("#placaRes");
    const regexPlacaAntiga = /^[a-zA-Z]{3}[0-9]{4}$/;
    const regexPlacaNova = /^[a-zA-Z]{3}[0-9]{1}[a-zA-Z]{1}[0-9]{2}$/;

    if(regexPlacaAntiga.test(placa.value)){
        textArea.innerHTML = (validando = true);
    }else if(regexPlacaNova.test(placa.value)){
        textArea.innerHTML = (validando = true);
    }else{
        textArea.innerHTML = (validando = false);
    }
}
//Exercício 1
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

//Exercício 2
var btCPF = document.querySelector("#btCPF");
btCPF.addEventListener("click", validarCPF);
function validarCPF(cpf){
    cpf = document.querySelector("#cpf");
    let textArea = document.querySelector("#cpfRes");

    cpf = cpf.value.replace(/\D/g, '');
    if(cpf.toString().length != 11 || /^(\d)\1{10}$/.test(cpf)) return false;
    var validando = true;
    [9,10].forEach(function(j){
        var soma = 0, r;
        cpf.split(/(?=)/).splice(0,j).forEach(function(e, i){
            soma += parseInt(e) * ((j+2)-(i+1));
        });
        r = soma % 11;
        r = (r <2)?0:11-r;
        if(r != cpf.substring(j, j+1)) validando = false;
    });
    if(validando == true ){
        textArea.innerHTML = true;
    }else{
        textArea.innerHTML = false;
    }
}

//Exercício 3
var btTel = document.querySelector("#btTel");
btTel.addEventListener("click", gerarTel);
function gerarTel(DDD, quant){
    quant = document.querySelector("#quantTel");
    let textArea = document.querySelector("#telefones");
    DDD = 19;

    let i = 0;
    while(i < quant.value){
        let tel = `(${DDD})${Math.floor(Math.random() * (99999 - 11111 + 1)) + 111111}-${Math.floor(Math.random() * (9999 - 1111 + 1)) + 1111}          `;
        textArea.innerHTML += tel;
        i++
    }
}

//Exercício 4
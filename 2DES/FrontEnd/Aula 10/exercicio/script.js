var cep = document.querySelector("#cep");
var logra = document.querySelector("#logra");
var complemento = document.querySelector("#complemento");
var bairro = document.querySelector("#bairro");
var cidade = document.querySelector("#cidade");
var estado = document.querySelector("#estado");

function validandoCEP() {
    let validando = false;
    validaCEP = /^[0-9]{8}$/;

    if (cep.value === validaCEP) {
        fetch(`https://viacep.com.br/ws/${cep.value}/json/`).then((response) => {
            return response.json();
        }).then((infoCEP) => {
                logra.innerHTML = logra.value = infoCEP.logradouro;
                complemento.innerHTML = complemento.value = infoCEP.complemento;
                bairro.innerHTML = bairro.value = infoCEP.bairro;
                cidade.innerHTML = cidade.value = infoCEP.localidade;
                estado.innerHTML = estado.value = infoCEP.uf;  
            });
    }else {
        logra.innerHTML = "";
        complemento.innerHTML = "";
        bairro.innerHTML = "";
        cidade.innerHTML = "";
        estado.innerHTML = "";

    }
}
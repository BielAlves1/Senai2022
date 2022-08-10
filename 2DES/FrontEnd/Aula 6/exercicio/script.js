var funcionario = [
	{
		"funcionario":"Sancho Cedraz",
		"cargo":{
			"nome":"Analista",
			"nível":2
		},
		"autorizado":true
	},		
	{
		"funcionario":"Ionara Pederneiras",
		"cargo":{
			"nome":"Técnico",
			"nível":2
		},
		"autorizado":true
	},
	{
		"funcionario":"Filipe Castanho",
		"cargo":{
			"nome":"Desenvolvedor",
			"nível":1
		},
		"autorizado":false
	},
	{
		"funcionario":"Lívia Bicalho",
		"cargo":{
			"nome":"Analista",
			"nível":3
		},
		"autorizado":true
	},
	{
		"funcionario":"Mauro Varanda",
		"cargo":{
			"nome":"Desenvolvedor",
			"nível":3
		},
		"autorizado":false
	},	
	{
		"funcionario":"Sandro Rosário",
		"cargo":{
			"nome":"Técnico",
			"nível":3
		},
		"autorizado":true
	},
];

var infoFuncionario = document.querySelector(".info-funcionario");


function load(){
    funcionario.forEach(info => {
        let novoFuncionario = infoFuncionario.cloneNode(true);
		let btRemover = novoFuncionario.querySelector(".btRemover");
		let adm = novoFuncionario.querySelector(".adm");
		adm.style = "color: rgb(9, 212, 9);"
		let leitor = novoFuncionario.querySelector(".leitor");
		leitor.style = "color: aqua;";

        novoFuncionario.classList.remove("model");
        
        novoFuncionario.querySelector("#nome-funcionario").innerHTML = info.funcionario;
        novoFuncionario.querySelector("#cargo").innerHTML = info.cargo.nome;
        novoFuncionario.querySelector("#nivel").innerHTML = info.cargo.nível;
		if(info.autorizado == true){
			novoFuncionario.querySelector("#autoriza").innerHTML = "Autorizado(a)";
		}else{
			novoFuncionario.querySelector("#autoriza").innerHTML = "Não Autorizado(a)";
		}

        document.querySelector(".funcionario").appendChild(novoFuncionario);

		if(info.cargo.nível != 3){
			btRemover.classList.remove("model");
		}
		if((info.cargo.nome) == 'Analista' || (info.cargo.nome) == 'Desenvolvedor'){
			if(info.cargo.nível == 3){
				adm.classList.remove("model");
			}else {
				leitor.classList.remove("model");
			}
		}
    });
}

function removerFuncionario(e) {
    e.parentNode.remove();
}
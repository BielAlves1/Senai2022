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
	}
]

var infoFuncionario = document.querySelector(".info-funcionario");


function carregar(){
    funcionario.forEach(info => {
        let novoFuncionario = infoFuncionario.cloneNode(true);

        novoFuncionario.classList.remove("model");
        
        novoFuncionario.querySelector("#nome-funcionario").innerHTML = info.funcionario;
        novoFuncionario.querySelector("#cargo").appendChild("#cargo-funcionario").value = info.cargo.nome;
        novoFuncionario.querySelector("#cargo").appendChild("#nivel-funcionario").value = info.cargo.nivel;
        novoFuncionario.querySelector("#autoriza").value = info.autorizado;
        document.querySelector(".funcionario").appendChild(novoFuncionario);
    });
}

function removerItem(e) {
    e.parentNode.remove();
}
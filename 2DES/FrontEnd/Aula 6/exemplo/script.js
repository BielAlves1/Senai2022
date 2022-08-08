var model = document.querySelector(".model");

function duplicar(){
    let novo = model.cloneNode(true);   

    novo.classList.remove("modelo");

    novo.querySelector("#img").src = "kkk.png";
    
    novo.querySelector("#algum").value ="Olá Guei";

    // novo.querySelector("#btRemover").addEventListener("click", ()=> {
    //     novo.remove();
    // });

    document.querySelector("body").appendChild(novo);
}

function remover(element){
    element.parentNode.remove();
}
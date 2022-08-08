var carrinho = [
    {
        "img":"http://images2.memedroid.com/images/UPLOADED36/51aa980571a06.jpeg",
        "nome":"Tênis Mike Air Jordão",
        "quant":2
    },
    {
        "img":"https://http2.mlstatic.com/D_NQ_NP_770363-MLB49937539000_052022-V.jpg",
        "nome":"Chinelo Ardidas",
        "quant":1
    },
    {
        "img":"https://ae01.alicdn.com/kf/HTB13IDMKh1YBuNjy1zcq6zNcXXaY/Shorts-dos-homens-bermuda-2018-ver-o-praia-shorts-homem-pumba-carta-impress-o-masculina-marca.jpg_Q90.jpg_.webp",
        "nome":"Bermuda Pumba",
        "quant":3
    },
    {
        "img":"https://t1.uc.ltmcdn.com/pt/posts/6/8/4/como_saber_se_lacoste_e_original_16486_600_square.jpg",
        "nome":"Camisa Jaré",
        "quant":5
    },
];

var itemCarrinho = document.querySelector(".item-carrinho");


function carregar(){
    carrinho.forEach(item => {
        let novoItem = itemCarrinho.cloneNode(true);

        novoItem.classList.remove("model");
        
        novoItem.querySelector("#img-item").src = item.img;
        novoItem.querySelector("#nome-item").innerHTML = item.nome;
        novoItem.querySelector("#qnt-item").value = item.quant;

        document.querySelector(".carrinho").appendChild(novoItem);
    });
}

function removerItem(e) {
    e.parentNode.remove();
}
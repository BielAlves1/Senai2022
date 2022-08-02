function criarElement(){
    let itemLista = document.createElement("div");
    itemLista.className = "item-lista";

    let thumbnail = document.createElement("img");
    thumbnail.src = "./img/butecao.jpg";
    thumbnail.id = "thumb";
    thumbnail.alt = "Foto Restaurante";

    let like = document.createElement("img");
    like.src = "./img/icon_like2.png";
    like.id = "like";
    like.alt = "Icone Corazaum";

    let avaliacao = document.createElement("img");
    avaliacao.src = "./img/star.png";
    avaliacao.id = "avaliacao";
    avaliacao.alt = "Avaliação";

    let info = document.createElement("div");
    info.id = "info";

    let nomeRes = document.createElement("p");
    nomeRes.innerHTML = "Xurumelas Bar 2.0KKK";

    let textoAvaliacao = document.createElement("p");
    textoAvaliacao.appendChild(avaliacao);
    textoAvaliacao.append("4.9");

    info.appendChild(nomeRes);
    info.appendChild(textoAvaliacao);

    itemLista.appendChild(thumbnail);
    itemLista.appendChild(info);
    itemLista.appendChild(like);

document.querySelector(".lista").appendChild(itemLista);
}
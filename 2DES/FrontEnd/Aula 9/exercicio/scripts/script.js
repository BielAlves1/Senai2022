const usuario = JSON.parse(window.localStorage.getItem("userData"));


let nomeU = document.querySelector("#nameU").innerHTML = usuario.name;
fetch("https://jsonplaceholder.typicode.com/posts").then((response) => {
return response.json();
}).then((data) => {
data.forEach(posts => {
    let novoCard = document.querySelector(".card-post").cloneNode(true);
    novoCard.classList.remove("model");
    
    novoCard.querySelector("#title").append(posts.title);
    novoCard.querySelector("#body").append(posts.body);

    document.querySelector(".container").appendChild(novoCard);
    document.querySelector(".navBar").appendChild(nomeU);
    })
});
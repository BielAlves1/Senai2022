
fetch("http://localhost:3000/clientes").then((response) => {
    return response.json();
}).then((data) => {
    data.forEach(cliente => {
        let title = document.createElement("h1");
        title.innerHTML = cliente.nome;
        document.querySelector("body").appendChild(title);
    })
});
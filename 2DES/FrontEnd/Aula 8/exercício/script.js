
fetch("https://jsonplaceholder.typicode.com/todos").then((response) => {
    return response.json();
}).then((data) => {
    data.forEach(cliente => {
        let novoCard = document.querySelector(".info-card").cloneNode(true);

        novoProduto.querySelector("#idU").innerHTML = cliente.userId;
        novoProduto.querySelector("#title").innerHTML = cliente.title;
        novoProduto.querySelector("#check").innerHTML = cliente.completed;
        novoProduto.classList.remove("modelo");

        if(cliente.completed === true) {
            check.checked = true;
            document.querySelector(".info-cliente").appendChild(check);
        }else {
            document.querySelector(".info-cliente").appendChild(check);
        }

        document.querySelector(".info-cliente").appendChild(userID);
        document.querySelector(".info-cliente").appendChild(title);
    })
});
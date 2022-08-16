
fetch("https://jsonplaceholder.typicode.com/todos").then((response) => {
    return response.json();
}).then((data) => {
    data.forEach(cliente => {
        let novoCard = document.querySelector(".info-card").cloneNode(true);
        novoCard.classList.remove("model");

        novoCard.querySelector("#idU").append(cliente.userId);
        novoCard.querySelector("#title").append(cliente.title);

        let check = novoCard.querySelector("#check");
        if(cliente.completed === true) {
            check.append(cliente.completed);
            check.checked = true;
        }else {
            check.append(cliente.completed);
            check.checked = false;
        }

        document.querySelector(".container").appendChild(novoCard);
    })
});
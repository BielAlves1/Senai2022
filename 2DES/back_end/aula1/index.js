const express = require('express');
const app = express();

app.use(express.json());

app.get('/aula-1', (req, res) => {
    res.json("Alô guei");
});

app.listen(3000, () => {
    console.log("Respondendo na porta 3000")
});
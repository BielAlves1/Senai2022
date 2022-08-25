const express = require('express');
const mysql = require('mysql');
const cors = require('cors');

const app = express();

const conenect = mysql.createConnection({
    user: 'root',
    host: 'localhost',
    database: 'clientes',
});

app.get('/clientes', (req, res) => {
    let string = "select * from vw_clientes";
    conenect.query(string,(erro, result) =>{
        if(erro != null){
            res.json(result);
        }
    })
});

app.listen(5000, () => {
    console.log("Respondendo na porta 5000");
});


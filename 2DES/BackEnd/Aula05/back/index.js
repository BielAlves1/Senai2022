const express = require('express');
const cors = require('cors');
const mysql = require('mysql');

const connect = mysql.createConnection({
    user: 'root',
    host: 'localhost',
    database: 'lojinha'
});
const app = express();
app.use(express.json());
app.use(cors());

app.get("/produtos", (req, res) => {
    let query = "select * from produtos";
    connect.query(query, (erro, result) => {
        if(erro == null) {
            res.json(result).status(200).end();
        }else {
            res.json(erro).status(402).end();
        }
    })
});

app.get("/produtos/:cod", (req, res) => {
    let query = `Select * from produtos where cod='${req.params.cod}'`;
    connect.query(query, (erro, result) => {
        if(erro == null) {
            res.json(result).status(200).end();
        }else {
            res.json(erro).status(402).end();
        }
    })
});

app.post("/produtos", (req, res) => {
    //req.query => http://localhost:5000/produtos?cod=abc1234&nome=teste
    //req.params => /produtos/:cod/:nome  => http://localhost:5000/produtos?cod=abc1234&nome=teste

    let query = `insert into produtos values (default, '${req.body.cod}', '${req.body.nome}', ${req.body.qntd}, ${req.body.preco})`;
    
    connect.query(query, (erro, result) => {
        if(erro == null) {
            res.status(201).json(req.body).end();
        }else {
           res.status(400).json(erro).end();
        }
    });
});

app.listen(5000, () => {
    console.log("Alô Corno");
});

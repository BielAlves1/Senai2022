const mysql = require('mysql');

const connect = mysql.createConnection({
    "host": "localhost",
    "user": "root",
    "database": "lojaJapa"
});

function listarLancamentos(req, res) {
    let query = "SELECT * FROM lancamentos";

    connect.query(query, (err, result) => {
        if(err == null) {
            res.json(result).status(200).end();
        }else {
            res.json(err).status(400).end();
        }
    })
};

function listaLancamento(req, res) {
    let query = `SELECT * FROM lancamentos WHERE data = '${req.params.data}'`;
    
    connect.query(query, (err, result) => {
        if(err == null) {
            res.status(200).json(result).end();
        }else {
            res.status(400).json(err).end();
        }
    })
};

function cadastrarLancamento(req, res) {
    let query = `INSERT INTO lancamentos VALUES (DEFAULT, DEFAULT, '${req.body.descricao}', ${req.body.valor}, '${req.body.tipo}')`;

    connect.query(query, (err, result) => {
        if(err == null) {
            res.status(201).json(req.body).end();
        }else {
            res.status(400).json(err).end();
        }
    });
};


module.exports = {
    listarLancamentos,
    listaLancamento,
    cadastrarLancamento
}
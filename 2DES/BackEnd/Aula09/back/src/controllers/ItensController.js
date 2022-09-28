const mysql = require('mysql');

const connect = mysql.createConnection({
    "host": "localhost",
    "user": "root",
    "database": "Patrimonio"
});

function listarItens(req, res) {
    let query = "SELECT * FROM itens";

    connect.query(query, (err, result) => {
        if(err == null) {
            res.json(result).status(200).end();
        }else {
            res.json(err).status(400).end();
        }
    })
};

function listarItem(req, res) {
    let query = `SELECT FROM itens WHERE ni = ${req.params.ni}`;

    connect.query(query, (err, result) => {
        if(err == null) {
            res.json(result).status(200).end();
        }else {
            res.json(err).status(400).end();
        }
    })
};

function cadastrarItem(req, res) {
    let query = `INSERT INTO itens VALUES (${req.body.ni}, curdate(), '${req.body.denominacao}', ${req.body.valor}, '${req.body.img}')`;

    connect.query(query, (err, result) => {
        if(err == null) {
            res.status(201).json(req.body).end();
        }else {
            res.status(400).json(err).end();
        }
    });
};

function excluirItem(req, res) {
    let query = `DELETE FROM itens WHERE ni = ${req.body.ni}`;

    conDB.query(query, (err, result) => {
        if(err == null) {
            res.status(200).json(req.body).end();
        }else {
            res.status(400).json(err).end();
        }
    });
};

module.exports = {
    listarItens,
    listarItem,
    cadastrarItem,
    excluirItem
}
const mysql = require('mysql');

const connect = mysql.createConnection({
    "host": "localhost",
    "user": "root",
    "database": "locadora"
});

function listarClientes(req, res) {
    let query = "SELECT * FROM clientes";

    connect.query(query, (err, result) => {
        if(err == null) {
            res.json(result).status(200).end();
        }else {
            res.json(err).status(400).end();
        }
    })
};

function listaCliente(req, res) {
    let query = `SELECT * FROM clientes WHERE cod_cli = '${req.params.cod_cli}'`;
    
    connect.query(query, (err, result) => {
        if(err == null) {
            res.status(200).json(result).end();
        }else {
            res.status(400).json(err).end();
        }
    })
};

function cadastrarCliente(req, res) {
    let query = `INSERT INTO clientes VALUES (DEFAULT, '${req.body.nome}', '${req.body.endereco}', '${req.body.telefone}')`;

    connect.query(query, (err, result) => {
        if(err == null) {
            res.status(201).json(req.body).end();
        }else {
            res.status(400).json(err).end();
        }
    });
};


module.exports = {
    listarClientes,
    listaCliente,
    cadastrarCliente
}
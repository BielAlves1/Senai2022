const mysql = require('mysql');

const connect = mysql.createConnection({
    "host": "localhost",
    "user": "root",
    "database": "locadora"
});

function listarLocacoes(req, res) {
    let query = "SELECT * FROM locacoes";

    connect.query(query, (err, result) => {
        if(err == null) {
            res.json(result).status(200).end();
        }else {
            res.json(err).status(400).end();
        }
    })
};

function listaLocacao(req, res) {
    let query = `SELECT * FROM locacoes WHERE data = '${req.params.NULL}'`;
    
    connect.query(query, (err, result) => {
        if(err == null) {
            res.status(200).json(result).end();
        }else {
            res.status(400).json(err).end();
        }
    })
};


module.exports = {
    listarLocacoes,
    listaLocacao
}
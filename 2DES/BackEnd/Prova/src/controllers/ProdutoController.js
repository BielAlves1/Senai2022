const Prod = require('../models/Produto.js');
const con = require('../models/SolicitacoesDAO');

const criarProd = (req, res) => {
    con.query(Prod.toCreate(req.body), (err, result) => {
        if (err == null)
            res.status(201).end();
        else
            if (err.sqlState == 23000)//Se o ni já está cadastrado
                res.status(406).json(err).end();
            else
                res.status(500).json(err).end();
    });
}

const listarProds = (req, res) => {
    con.query(Prod.toReadAll(), (err, result) => {
        if (err == null)
            res.json(result).end();
        else
            res.status(500).end();
    });
}

module.exports = {
    criarProd,
    listarProds
}
const Item = require('../models/ItemSol');
const con = require('../models/SolicitacoesDAO');

const criarItemSol = (req, res) => {
    con.query(Item.toCreate(req.body), (err, result) => {
        if (err == null)
            res.status(201).end();
        else
            if (err.sqlState == 23000)
                res.status(406).json(err).end();
            else
                res.status(500).json(err).end();
    });
}

const listarItensSol = (req, res) => {
    con.query(Item.toReadAll(), (err, result) => {
        if (err == null)
            res.json(result).end();
        else
            res.status(500).end();
    });
}

const listarProdDepto = (req, res) => {
    con.query(Item.toReadProdDepto(), (err, result) => {
        if (err == null)
            res.json(result).end();
        else
            res.status(500).end();
    });
}

module.exports = {
    criarItemSol,
    listarItensSol,
    listarProdDepto
}
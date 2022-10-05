const Item = require('../models/ItemSol');
const con = require('../models/SolicitacoesDAO');

const criarItemSol = (req, res) => {
    con.query(Item.toCreate(req.body), (err, result) => {
        if (err == null){
            if (result[1].affectedRow == 0)
                res.status(400).end();
            else
                res.status(201).end();
        }
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

module.exports = {
    criarItemSol,
    listarItensSol
}
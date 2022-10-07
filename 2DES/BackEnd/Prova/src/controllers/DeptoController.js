const Depto = require('../models/Departamento.js');
const con = require('../models/SolicitacoesDAO');

const criarDepto = (req, res) => {
    con.query(Depto.toCreate(req.body), (err, result) => {
        if (err == null)
            res.status(201).end();
        else
            if (err.sqlState == 23000)
                res.status(406).json(err).end();
            else
                res.status(500).json(err).end();
    });
}

const listarDeptos = (req, res) => {
    con.query(Depto.toReadAll(), (err, result) => {
        if (err == null)
            res.json(result).end();
        else
            res.status(500).end();
    });
}

const excluirDepto = (req, res) => {
    con.query(Depto.toDelete(req.params), (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(204).end();
            else
                res.status(404).end();
        else
            res.status(400).json(err).end();
    });
}

module.exports = {
    criarDepto,
    listarDeptos,
    excluirDepto
}
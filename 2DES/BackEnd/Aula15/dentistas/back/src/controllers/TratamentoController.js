const con = require('../dao/dentistaDAO.js');
const Tratamento = require('../models/Tratamento.js');


const listarTratamento = (req, res) => {
    con.query(Tratamento.toRead(req.params), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const cadastrarTratamento = (req, res) => {
    con.query(Tratamento.toCreate(req.body), (err, result) => {
        if (err == null) {
            res.status(201).json(req.body).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const alterarTratamento = (req, res) => {
    con.query(Tratamento.toUpdate(req.body), (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(200).end();
            else
                res.status(404).end();
        else
            res.status(500).json(err).end();
    });
}

const excluirTratamento = (req, res) => {
    con.query(Tratamento.toDelete(req.params), (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(204).json(req.params).end();
            else
                res.status(404).end();
        else
            res.status(400).json(err).end();
    })
}

module.exports = {
    listarTratamento,
    cadastrarTratamento,
    alterarTratamento,
    excluirTratamento
}
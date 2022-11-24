const con = require('../dao/dentistaDAO.js');
const Profissional = require('../models/Profissional.js');

const listarGeral = (req, res) => {
    con.query(Profissional.toReadAll(), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end()
        }else {
            res.status(400).json(err).end();
        }
    })
}

const listarProfissional = (req, res) => {
    con.query(Profissional.toRead(req.params), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const cadastrarCliente = (req, res) => {
    con.query(Profissional.toCreate(req.body), (err, result) => {
        if (err == null) {
            res.status(201).json(req.body).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const excluirCliente = (req, res) => {
    con.query(Profissional.toDelete(req.params), (err, result) => {
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
    listarGeral,
    listarProfissional
}
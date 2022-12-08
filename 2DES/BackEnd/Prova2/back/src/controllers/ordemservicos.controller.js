const con = require('../OrdemServicoDAO.js');
const OrdemServico = require('../models/OrdemServico.model');


const listarOrdemServicos = (req, res) => {
    con.query(OrdemServico.toReadAll(), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const listarOrdemServico = (req, res) => {
    con.query(OrdemServico.toRead(req.params), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const cadastrarOrdemServico = (req, res) => {
    con.query(OrdemServico.toCreate(req.body), (err, result) => {
        if (err == null) {
            res.status(201).json(req.body).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const alterarOrdemServico = (req, res) => {
    con.query(OrdemServico.toUpdate(req.body), (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(200).end();
            else
                res.status(404).end();
        else
            res.status(500).json(err).end();
    });
}

const excluirOrdemServico = (req, res) => {
    con.query(OrdemServico.toDelete(req.params), (err, result) => {
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
    listarOrdemServicos,
    listarOrdemServico,
    cadastrarOrdemServico,
    alterarOrdemServico,
    excluirOrdemServico
}
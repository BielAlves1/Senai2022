const con = require('../OrdemServicoDAO.js');
const Funcionario = require('../models/Funcionario.model');


const listarFuncionarios = (req, res) => {
    con.query(Funcionario.toReadAll(), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const listarFuncionario = (req, res) => {
    con.query(Funcionario.toRead(req.params), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const cadastrarFuncionario = (req, res) => {
    con.query(Funcionario.toCreate(req.body), (err, result) => {
        if (err == null) {
            res.status(201).json(req.body).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

const alterarFuncionario = (req, res) => {
    con.query(Funcionario.toUpdate(req.body), (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(200).end();
            else
                res.status(404).end();
        else
            res.status(500).json(err).end();
    });
}

const excluirFuncionario = (req, res) => {
    con.query(Funcionario.toDelete(req.params), (err, result) => {
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
    listarFuncionarios,
    listarFuncionario,
    cadastrarFuncionario,
    alterarFuncionario,
    excluirFuncionario
}
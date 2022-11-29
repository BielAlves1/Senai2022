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

module.exports = {
    listarGeral,
    listarProfissional
}
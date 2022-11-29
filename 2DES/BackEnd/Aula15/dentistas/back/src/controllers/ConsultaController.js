const con = require('../dao/dentistaDAO.js');
const Consulta = require('../models/Consulta.js');


const listarConsulta = (req, res) => {
    con.query(Consulta.toRead(req.params), (err, result) => {
        if (err == null) {
            res.status(200).json(result).end();
        }else{
            res.status(400).json(err).end();
        }
    })
}

module.exports = {
    listarConsulta
}
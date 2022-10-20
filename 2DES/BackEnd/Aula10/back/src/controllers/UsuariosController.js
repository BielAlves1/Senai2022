const Usuario = require('../models/Usuario.js');
const con = require('../dao/dbUsuarios');
const multer = require('multer');
const upload = multer().single('avatar')

const listarUsuarios = (req, res) => {
    let string = Usuario.toReadAll();
    con.query(string, (err, result) => {
        if (err == null) {
            res.json(Usuario.toAscii(result)).end();
        }
    });
}

const cadastrarUsuario = async (req, res) => {
    upload(req, res, (err) => {
        if (err)
            res.status(500).json({ error: 1, payload: err }).end();
        else {
            let string = Usuario.toCreate(req.body, req.file);
            con.query(string, (err, result) => {
                if (err == null) {
                    //res.status(201).json(dados).end();
                    res.redirect('http://127.0.0.1:5500/front/usuarios.html');
                } else {
                    res.status(500).json(err).end();
                }
            });
        }
    });
}

const alterarUsuario = (req, res) => {
    let string = Usuario.toUpdate(req.body);
    con.query(string, (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(200).end();
            else
                res.status(404).end();
        else
            res.status(400).json(err).end();
    });
}

const excluirUsuario = (req, res) => {
    let string = Usuario.toDel(req.body);
    con.query(string, (err, result) => {
        if (err == null)
            if (result.affectedRows > 0)
                res.status(200).end();
            else
                res.status(404).end();
        else
            res.status(400).json(err).end();
    });
}

module.exports = {
    listarUsuarios,
    cadastrarUsuario,
    alterarUsuario,
    excluirUsuario
}
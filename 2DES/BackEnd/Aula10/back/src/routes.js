const express = require('express');
const router = express.Router();

const Usuario = require("./controllers/UsuariosController");

router.get("/usuarios", Usuario.listarUsuarios);
router.post("/usuario", Usuario.cadastrarUsuario);
router.put("/usuario", Usuario.alterarUsuario);
router.delete("/usuario", Usuario.excluirUsuario);

module.exports = router;
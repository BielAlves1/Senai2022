const express = require('express');
const router = express.Router();

const Depto = require("../controllers/DeptoController");

router.get("/solicitacoes/departamentos", Depto.listarDeptos);
router.post("/solicitacoes/departamento", Depto.criarDepto);
router.delete("/solicitacoes/departamento/:Cod_Depto", Depto.excluirDepto);

module.exports = router;
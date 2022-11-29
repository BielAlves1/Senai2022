const express = require('express');
const router = express.Router();

const Tratamento = require("../controllers/TratamentoController");

router.get("/tratamentos/read", Tratamento.listarTratamento);
router.post("/tratamentos/create", Tratamento.cadastrarTratamento);
router.put("/tratamentos/update", Tratamento.alterarTratamento);
router.delete("/tratamentos/delete/:id_trata", Tratamento.excluirTratamento);

module.exports = router;
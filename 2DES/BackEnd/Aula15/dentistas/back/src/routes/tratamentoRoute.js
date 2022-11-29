const express = require('express');
const router = express.Router();

const Tratamento = require("../controllers/TratamentoController");

router.get("/dentista/tratamento", Tratamento.listarTratamento);
router.post("/dentista/tratamento", Tratamento.cadastrarTratamento);
router.put("/dentista/tratamento", Tratamento.alterarTratamento);
router.delete("/dentista/tratamento/:id_trata", Tratamento.excluirTratamento);

module.exports = router;
const express = require('express');
const router = express.Router();

const OrdemServico = require("../controllers/ordemservicos.controller");

router.get("/ordemservicos/readAll", OrdemServico.listarOrdemServicos);
router.get("/ordemservicos/readid/:id_Os", OrdemServico.listarOrdemServico);
router.post("/ordemservicos/create", OrdemServico.cadastrarOrdemServico);
router.put("/ordemservicos/update", OrdemServico.alterarOrdemServico);
router.delete("/ordemservicos/delete/:id_Os", OrdemServico.excluirOrdemServico);

module.exports = router;
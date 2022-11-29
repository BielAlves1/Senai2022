const express = require('express');
const router = express.Router();

const Profissional = require("../controllers/ProfissionalController");

router.get("/profissionais/read", Profissional.listarGeral);
router.get("/profissionais/read/:id_prof", Profissional.listarProfissional);

module.exports = router;
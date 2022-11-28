const express = require('express');
const router = express.Router();

const Profissional = require("../controllers/ProfissionalController");

router.get("/dentista/profissional", Profissional.listarGeral);
router.get("/dentista/profissional/:id_prof", Profissional.listarProfissional);

module.exports = router;
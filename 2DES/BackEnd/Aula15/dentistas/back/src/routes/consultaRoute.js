const express = require('express');
const router = express.Router();

const Consulta = require("../controllers/ConsultaController");

router.get("/dentista/consulta", Consulta.listarConsulta);

module.exports = router;
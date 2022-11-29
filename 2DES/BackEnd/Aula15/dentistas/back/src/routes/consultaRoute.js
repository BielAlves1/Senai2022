const express = require('express');
const router = express.Router();

const Consulta = require("../controllers/ConsultaController");

router.get("/consultas/read", Consulta.listarConsulta);

module.exports = router;
const express = require('express');
const router = express.Router();

const Funcionario = require("../controllers/funcionarios.controller");

router.get("/funcionarios/readAll", Funcionario.listarFuncionarios);
router.get("/funcionarios/readid/:id_func", Funcionario.listarFuncionario);
router.post("/funcionarios/create", Funcionario.cadastrarFuncionario);
router.put("/funcionarios/update", Funcionario.alterarFuncionario);
router.delete("/funcionarios/delete/:id_func", Funcionario.excluirFuncionario);

module.exports = router;
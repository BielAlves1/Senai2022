const Express = require('express');

const router = Express.Router();

const ClientesController = require("./controllers/ClientesController");
const LocacoesController = require("./controllers/LocacoesController");

router.get("/lancamentos", ClientesController.listarClientes);
router.get("/lancamento/:data", ClientesController.listaCliente);
router.post("/lancamento", ClientesController.cadastrarCliente);

router.get("/lancamentos", LocacoesController.listarLocacoes);
router.get("/lancamento/:data", LocacoesController.listaLocacao);
// router.post("/lancamento", LocacoesController.cadastrarlocacoes);

module.exports = router;
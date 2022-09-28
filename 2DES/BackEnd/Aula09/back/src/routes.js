const Express = require('express');

const router = Express.Router();

const ItensController = require("./controllers/ItensController");

router.get("/patrimonio/itens", ItensController.listarItens);
router.get("/patrimonio/item/:ni", ItensController.listarItem);
router.post("/patrimonio/item", ItensController.cadastrarItem);
router.delete("/patrimonio/item/:ni", ItensController.excluirItem);

module.exports = router;

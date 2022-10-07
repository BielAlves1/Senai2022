const express = require('express');
const router = express.Router();

const Prod = require("../controllers/ProdutoController");

router.get("/solicitacoes/produtos", Prod.listarProds);
router.post("/solicitacoes/produto", Prod.criarProd);

module.exports = router;
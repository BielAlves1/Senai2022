const PORT = process.env.PORT || 5000
const express = require('express');
const cors = require('cors');

const funcionarioR = require('./src/routes/funcionarios.route');
const ordemServico = require('./src/routes/ordemservicos.route');

const app = express();
app.use(express.json());
app.use(cors());
app.use(funcionarioR);
app.use(ordemServico);

app.listen(5000, () => {
    console.log("Alô Alô, tamo on na porta: " + PORT);
});
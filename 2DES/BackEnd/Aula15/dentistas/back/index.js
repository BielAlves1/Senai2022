const PORT = process.env.PORT || 5000
const express = require('express');
const cors = require('cors');

const profissionalR = require('./src/routes/profissionalRoute.js');
const consultaR = require('./src/routes/consultaRoute.js');
const tratamentoR = require('./src/routes/tratamentoRoute.js');

const app = express();
app.use(express.json());
app.use(cors());
app.use(profissionalR);
app.use(consultaR);
app.use(tratamentoR);

app.listen(5000, () => {
    console.log("Alô Alô, tamo on na porta: " + PORT);
});
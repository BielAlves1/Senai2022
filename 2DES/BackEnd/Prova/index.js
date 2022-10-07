const express = require('express');
const cors = require('cors');

const listaSol = require('./src/routes/itensSolRoute.js');
const Prod = require('./src/routes/ProdRoute.js');
const Depto = require('./src/routes/deptoRoute.js');

const app = express();
app.use(express.json());
app.use(cors());
app.use(listaSol);
app.use(Prod);
app.use(Depto);

app.listen(5000, () => {
    console.log("Alô Alô");
});
const express = require('express');
const cors = require('cors');

const listaSol = require('./src/routes/itensSolRoute.js');

const app = express();
app.use(express.json());
app.use(cors());
app.use(listaSol);

app.listen(5000, () => {
    console.log("Alô Alô");
});
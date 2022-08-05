const express = require('express');
const mysql = require('mysql');
const app = express();

const connect = mysql.createConnection({
    user : 'root',
    host : 'localhost',
    database : 'pedidos'
});

app.use(express.json());

app.get('/pedidos',(req, res)=>{
    let nome = req.query.nome;
    let sobrenome = req.query.sobrenome;
    let endereco = req.query.endereco;
    let string = `insert into clientes value(null,'${nome}','${sobrenome})','${endereco}')`;
    connect.query(string,(erro, result) => {
        if(erro == null){
            res.json("Dados recebidos com sucesso no nosso Banco de Dados!");
        } else{
            res.json("Dados recebidos com sucesso, porém não conseguimos enviar para o banco de dados!");
        }
    });
});

app.listen(3000,()=>{
    console.log("Respondendo na porta: 3000");
});
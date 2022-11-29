const toCreate = (model) => {
    return `INSERT INTO tratamentos VALUES (default,'${model.id_consu}','${model.tratamento}',${model.valor})`;
}

const toRead = (model) => {
    return 'SELECT * FROM tratamentos';
}

const toUpdate = (model) => {
    return `UPDATE tratamentos SET 
    tratamento = '${model.tratamento}', 
    valor = ${model.valor} 
    WHERE id_trata = '${model.id_trata}'`;
}

const toDelete = (model) => {
    return `DELETE FROM tratamentos WHERE id_trata = '${model.id_trata}'`;
}

module.exports = {
    toCreate,
    toRead,
    toUpdate,
    toDelete
}
const toCreate = (model) => {
    return `INSERT INTO funcionarios VALUES (default, '${model.nome}', '${model.especialidade}')`;
}

const toReadAll = () => {
    return 'SELECT * FROM funcionarios';
}

const toRead = (model) => {
    return `SELECT * FROM funcionarios WHERE id_func = '${model.id_func}'`;
}

const toUpdate = (model) => {
    return `UPDATE funcionarios SET 
    especialidade = '${model.especialidade}' 
    WHERE id_func = '${model.id_func}'`;
}

const toDelete = (model) => {
    return `DELETE FROM funcionarios WHERE id_func = '${model.id_func}'`;
}

module.exports = {
    toCreate,
    toReadAll,
    toRead,
    toUpdate,
    toDelete
}
const toCreate = (model) => {
    return `INSERT INTO os VALUES (default, '${model.id_func}', '${model.descricao}', ${model.custo})`;
}

const toReadAll = () => {
    return 'SELECT * FROM os';
}

const toRead = (model) => {
    return `SELECT * FROM os WHERE id_Os = '${model.id_Os}'`;
}

const toUpdate = (model) => {
    return `UPDATE os SET 
    descricao = '${model.descricao}', 
    custo = ${model.custo}
    WHERE id_Os = '${model.id_Os}'`;
}

const toDelete = (model) => {
    return `DELETE FROM os WHERE id_Os = '${model.id_Os}'`;
}

module.exports = {
    toCreate,
    toReadAll,
    toRead,
    toUpdate,
    toDelete
}
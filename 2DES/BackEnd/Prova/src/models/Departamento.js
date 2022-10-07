const toCreate = (model) => {
    return `INSERT INTO Departamentos values(${model.Cod_Depto}, '${model.Nome_Depto}')`;
}

const toReadAll = (model) => {
    return `SELECT * FROM Departamentos`;
}

const toDelete = (model) => {
    return `DELETE FROM Departamentos WHERE Cod_Depto = ${model.Cod_Depto}`;
}

module.exports = {
    toCreate,
    toReadAll,
    toDelete
}
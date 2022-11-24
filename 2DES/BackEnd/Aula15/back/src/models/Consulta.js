const toRead = (model) => {
    return `SELECT * FROM consultas WHERE id_consu = '${model.id_consu}'`;
}

module.exports = {
    toRead
}
const toCreate = (model) => {
    return `INSERT INTO Produtos values (${model.Cod_Produto}, '${model.Nome_produto}')`;
}
const toReadAll = () => {
    return "SELECT * FROM Produtos";
}

module.exports = {
    toCreate,
    toReadAll
}
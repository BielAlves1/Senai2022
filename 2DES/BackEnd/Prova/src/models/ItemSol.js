const toCreate = (model) => {
    return `call solicita_um_item(${model.n_sol}, ${model.depto}, ${model.func}, ${model.prod}, ${model.qtd}, ${model.total})`;
}
const toReadAll = () => {
    return "SELECT * FROM vw_solicitacoes";
}

const toReadProdDepto = (model) => {
    return `select d.Nome_Depto, p.Nome_produto from Departamentos d
    join Solicitacoes s
    on d.Cod_Depto = s.Cod_Depto
    join Itens_Solicitacao it
    on s.Num_Sol = it.Num_Sol
    join Produtos p
    on it.Cod_Produto = p.Cod_Produto
    where Nome_produto like '%${model.Nome_produto}%'`
}

module.exports = {
    toCreate,
    toReadAll,
    toReadProdDepto
}
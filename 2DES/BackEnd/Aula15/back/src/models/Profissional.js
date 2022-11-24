const toReadAll = () => {
    return "SELECT * FROM vw_geral";
}

const toRead = (model) => {
    return `SELECT * FROM profissionais WHERE id_prof = '${model.id_prof}'`;
}

module.exports = {
    toReadAll,
    toRead
}
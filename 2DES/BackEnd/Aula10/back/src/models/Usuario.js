const toCreate = (dados,file) =>{
    if (file != null){
        dados.avatar = file.buffer.toString('base64');
        return `insert into usuarios values ('${dados.login}','${dados.nome}','${dados.nascimento}','${dados.telefone}','${dados.avatar}')`;
    }else
        return `insert into usuarios values ('${dados.login}','${dados.nome}','${dados.nascimento}','${dados.telefone}', null)`;
}

const toReadAll = ()=>{
    return "select * from usuarios";
}

const toUpdate = (dados)=>{
    dados.avatar = file.buffer.toString('base64');
    return `UPDATE usuarios SET 
                nome = '${dados.nome}',
                nascimento = ${dados.nascimento},
                telefone = ${dados.telefone},
                avatar = '${dados.avatar}'
                WHERE login = '${dados.login}'`;
}

const toDel = (dados)=>{
    return `delete from usuarios where login = ${dados.login}`
}

const toAscii = (dados)=>{
    dados.forEach(d => {
        if(d.avatar != null) d.avatar = d.avatar.toString('ascii');
    });
    return dados;
}

module.exports = {
    toCreate,
    toReadAll,
    toDel,
    toAscii
}
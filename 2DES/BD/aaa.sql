drop procedure if exists insere_pedidos;
delimiter //
create procedure insere_pedidos()
	begin
	declare erro_sql tinyint default false;
	declare continue handler for sqlexception set erro_sql = true;
	start transaction;
		
        insert into Pedidos(cliente_id, data, hora) values(105,DATE_SUB(curdate(),INTERVAL 2 DAY),"09:48:00");
        insert into Itens_Pedido(pedido_id, pizza_id, quantidade, valor) values(27,9,3, (select valor from Pizzas where pizza_id = 9));
        insert into Itens_Pedido(pedido_id, pizza_id, quantidade, valor) values(27,3,2, (select valor from Pizzas where pizza_id = 3));
        insert into Itens_Pedido(pedido_id, pizza_id, quantidade, valor) values(27,10,1, (select valor from Pizzas where pizza_id = 10));
        update Pedidos set valor=(select sum(quantidade * valor) from Itens_Pedido where pedido_id = 27) where pedido_id = 27;

		if erro_sql = false then
			commit;
			select 'Transação efetivada com sucesso' as Resultado;
		else
			rollback;
			select 'Erro na transação' as Resultado;
		end if;
end//
delimiter ;

call insere_pedidos();

select * from Itens_Pedido;
select * from Pedidos;
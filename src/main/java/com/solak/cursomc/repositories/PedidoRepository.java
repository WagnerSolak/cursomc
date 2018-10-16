package com.solak.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solak.cursomc.domain.Pedido;



@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
		//acessar bd e fazer operações de acesso a dados referente ao obj categoria
}

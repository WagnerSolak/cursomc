package com.solak.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solak.cursomc.domain.Pagamento;

//Repository é apenas da superclasse, ela abrange todas!

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
		//acessar bd e fazer operações de acesso a dados referente ao obj categoria
}

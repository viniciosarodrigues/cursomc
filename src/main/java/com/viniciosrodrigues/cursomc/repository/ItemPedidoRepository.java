package com.viniciosrodrigues.cursomc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viniciosrodrigues.cursomc.domain.ItemPedido;
import com.viniciosrodrigues.cursomc.domain.ItemPedidoPk;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPk> {

}

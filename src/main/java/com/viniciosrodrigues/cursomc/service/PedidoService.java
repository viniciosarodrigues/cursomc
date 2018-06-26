package com.viniciosrodrigues.cursomc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciosrodrigues.cursomc.domain.Pedido;
import com.viniciosrodrigues.cursomc.exception.ObjectNotFoundException;
import com.viniciosrodrigues.cursomc.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public List<Pedido> getListAll() {
		return pedidoRepository.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> categoriaSalva = pedidoRepository.findById(id);
		return categoriaSalva.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", tipo: " + Pedido.class.getName()));

	}
}

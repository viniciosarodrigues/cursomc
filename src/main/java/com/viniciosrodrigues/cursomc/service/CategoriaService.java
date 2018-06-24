package com.viniciosrodrigues.cursomc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viniciosrodrigues.cursomc.domain.Categoria;
import com.viniciosrodrigues.cursomc.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Categoria> getListAll() {
		return categoriaRepository.findAll();
	}

	public Categoria findById(Long id) {
		return categoriaRepository.getOne(id);
	}
}

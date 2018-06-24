package com.viniciosrodrigues.cursomc.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciosrodrigues.cursomc.domain.Categoria;
import com.viniciosrodrigues.cursomc.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping
	public ResponseEntity<List<Categoria>> getListAll() {
		return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getListAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getOnde(@PathVariable Long id) {
		Categoria categoriaEncontrada = categoriaService.findById(id);
		if (categoriaEncontrada != null)
			return ResponseEntity.status(HttpStatus.OK).body(categoriaEncontrada);
		else
			return ResponseEntity.notFound().build();
	}

}

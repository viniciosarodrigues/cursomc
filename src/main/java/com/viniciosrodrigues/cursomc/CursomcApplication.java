package com.viniciosrodrigues.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciosrodrigues.cursomc.domain.Categoria;
import com.viniciosrodrigues.cursomc.domain.Produto;
import com.viniciosrodrigues.cursomc.repository.CategoriaRepository;
import com.viniciosrodrigues.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria catUm = new Categoria();
		catUm.setNome("Informática");

		Categoria catDois = new Categoria();
		catDois.setNome("Escritório");

		Produto produtoUm = new Produto(null, "Computado", 2000D);
		Produto produtoDois = new Produto(null, "Impressora", 800D);
		Produto produtoTres = new Produto(null, "Mouse", 80D);

		catUm.setProdutos(Arrays.asList(produtoUm, produtoDois, produtoTres));
		catDois.setProdutos(Arrays.asList(produtoDois));

		produtoUm.setCategorias(Arrays.asList(catUm));
		produtoDois.setCategorias(Arrays.asList(catUm, catDois));
		produtoTres.setCategorias(Arrays.asList(catUm));

		categoriaRepository.saveAll(Arrays.asList(catUm, catDois));
		produtoRepository.saveAll(Arrays.asList(produtoUm, produtoDois, produtoTres));

	}

}

package com.viniciosrodrigues.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciosrodrigues.cursomc.domain.Categoria;
import com.viniciosrodrigues.cursomc.domain.Cidade;
import com.viniciosrodrigues.cursomc.domain.Estado;
import com.viniciosrodrigues.cursomc.domain.Produto;
import com.viniciosrodrigues.cursomc.repository.CategoriaRepository;
import com.viniciosrodrigues.cursomc.repository.CidadeRepository;
import com.viniciosrodrigues.cursomc.repository.EstadoRepository;
import com.viniciosrodrigues.cursomc.repository.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria catUm = new Categoria();
		catUm.setNome("Informática");

		Categoria catDois = new Categoria();
		catDois.setNome("Escritório");

		Produto produtoUm = new Produto(null, "Computador", 2000D);
		Produto produtoDois = new Produto(null, "Impressora", 800D);
		Produto produtoTres = new Produto(null, "Mouse", 80D);

		catUm.getProdutos().addAll(Arrays.asList(produtoUm, produtoDois, produtoTres));
		catDois.getProdutos().addAll(Arrays.asList(produtoDois));

		produtoUm.getCategorias().addAll(Arrays.asList(catUm));
		produtoDois.getCategorias().addAll(Arrays.asList(catUm, catDois));
		produtoTres.getCategorias().addAll(Arrays.asList(catUm));

		categoriaRepository.saveAll(Arrays.asList(catUm, catDois));
		produtoRepository.saveAll(Arrays.asList(produtoUm, produtoDois, produtoTres));

		Estado estadoUm = new Estado(null, "Minas Gerais");
		Estado estadoDois = new Estado(null, "São Paulo");

		Cidade cidadeUm = new Cidade(null, "Uberlância", estadoUm);
		Cidade cidadeDois = new Cidade(null, "São Paulo", estadoDois);
		Cidade cidadeTres = new Cidade(null, "Campinas", estadoDois);

		estadoUm.getCidades().addAll(Arrays.asList(cidadeUm));
		estadoDois.getCidades().addAll(Arrays.asList(cidadeDois, cidadeTres));

		estadoRepository.saveAll(Arrays.asList(estadoUm, estadoDois));
		cidadeRepository.saveAll(Arrays.asList(cidadeUm, cidadeDois, cidadeTres));

	}

}

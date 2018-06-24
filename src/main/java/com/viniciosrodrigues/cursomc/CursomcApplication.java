package com.viniciosrodrigues.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciosrodrigues.cursomc.domain.Categoria;
import com.viniciosrodrigues.cursomc.repository.CategoriaRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria catUm = new Categoria();
		catUm.setNome("Informática");

		Categoria catDois = new Categoria();
		catDois.setNome("Escritório");

		categoriaRepository.saveAll(Arrays.asList(catUm, catDois));
	}
}

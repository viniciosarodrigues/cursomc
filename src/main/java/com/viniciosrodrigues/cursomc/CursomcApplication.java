package com.viniciosrodrigues.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.viniciosrodrigues.cursomc.domain.Categoria;
import com.viniciosrodrigues.cursomc.domain.Cidade;
import com.viniciosrodrigues.cursomc.domain.Cliente;
import com.viniciosrodrigues.cursomc.domain.Endereco;
import com.viniciosrodrigues.cursomc.domain.Estado;
import com.viniciosrodrigues.cursomc.domain.Pagamento;
import com.viniciosrodrigues.cursomc.domain.PagamentoComBoleto;
import com.viniciosrodrigues.cursomc.domain.PagamentoComCartao;
import com.viniciosrodrigues.cursomc.domain.Pedido;
import com.viniciosrodrigues.cursomc.domain.Produto;
import com.viniciosrodrigues.cursomc.domain.enums.EstadoPagamento;
import com.viniciosrodrigues.cursomc.domain.enums.TipoCliente;
import com.viniciosrodrigues.cursomc.repository.CategoriaRepository;
import com.viniciosrodrigues.cursomc.repository.CidadeRepository;
import com.viniciosrodrigues.cursomc.repository.ClienteRepository;
import com.viniciosrodrigues.cursomc.repository.EnderecoRepository;
import com.viniciosrodrigues.cursomc.repository.EstadoRepository;
import com.viniciosrodrigues.cursomc.repository.PagamentoRepository;
import com.viniciosrodrigues.cursomc.repository.PedidoRepository;
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

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Cria as categorias
		Categoria catUm = new Categoria();
		catUm.setNome("Informática");

		Categoria catDois = new Categoria();
		catDois.setNome("Escritório");

		// Cria os produtos
		Produto produtoUm = new Produto(null, "Computador", 2000D);
		Produto produtoDois = new Produto(null, "Impressora", 800D);
		Produto produtoTres = new Produto(null, "Mouse", 80D);

		// Adiciona os produtos às categorias
		catUm.getProdutos().addAll(Arrays.asList(produtoUm, produtoDois, produtoTres));
		catDois.getProdutos().addAll(Arrays.asList(produtoDois));

		// Adiciona as categorias aos produtos
		produtoUm.getCategorias().addAll(Arrays.asList(catUm));
		produtoDois.getCategorias().addAll(Arrays.asList(catUm, catDois));
		produtoTres.getCategorias().addAll(Arrays.asList(catUm));

		// Salva Categorias e Produtos na base de dados
		categoriaRepository.saveAll(Arrays.asList(catUm, catDois));
		produtoRepository.saveAll(Arrays.asList(produtoUm, produtoDois, produtoTres));

		// Cria os Estados
		Estado estadoUm = new Estado(null, "Pernambuco");
		Estado estadoDois = new Estado(null, "São Paulo");

		// Cria as Cidades
		Cidade cidadeUm = new Cidade(null, "Recife", estadoUm);
		Cidade cidadeDois = new Cidade(null, "São Paulo", estadoDois);
		Cidade cidadeTres = new Cidade(null, "Campinas", estadoDois);

		// Adiciona as Cidades aos Estados
		estadoUm.getCidades().addAll(Arrays.asList(cidadeUm));
		estadoDois.getCidades().addAll(Arrays.asList(cidadeDois, cidadeTres));

		// Salva as Cidades e os Estados
		estadoRepository.saveAll(Arrays.asList(estadoUm, estadoDois));
		cidadeRepository.saveAll(Arrays.asList(cidadeUm, cidadeDois, cidadeTres));

		// Cria os Clientes e Endereços dos clientes
		Cliente clienteUm = new Cliente(null, "Vinícios Rodrigues", "viniciosarodrigues@gmail.com", "08911768456",
				TipoCliente.PESSOAFISICA);
		clienteUm.getTelefones().addAll(Arrays.asList("34360275", "999509300"));

		Endereco enderecoUm = new Endereco(null, "Av. Viconde de Suassun", "874", "Apt. 1102", "Santo Amaro",
				"50050540", clienteUm, cidadeUm);
		Endereco enderecoDois = new Endereco(null, "Rua Professor Augusto Lins e Silva", "621", "Apt. 801",
				"Boa Viagem", "51050500", clienteUm, cidadeUm);

		Cliente clienteDois = new Cliente(null, "GymFitSmart", "maria.silva@gfsmart.com", "99490136000194",
				TipoCliente.PESSOAJURIDICA);
		Endereco enderecoTres = new Endereco(null, "Rua do teste", "123", "Sem complemento", "Bairro Tal", "12345678",
				clienteDois, cidadeDois);

		// Adiciona os Endereços aos Clientes
		clienteUm.getEnderecos().addAll(Arrays.asList(enderecoUm, enderecoDois));
		clienteDois.getEnderecos().addAll(Arrays.asList(enderecoTres));

		// Salva os Clientes e Endereços
		clienteRepository.saveAll(Arrays.asList(clienteUm, clienteDois));
		enderecoRepository.saveAll(Arrays.asList(enderecoUm, enderecoDois, enderecoTres));

		// Cria Pedidos
		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido pedUm = new Pedido(null, stf.parse("30/09/2017 10:32"), clienteUm, enderecoUm);
		Pedido pedDois = new Pedido(null, stf.parse("10/10/2017 19:35"), clienteDois, enderecoTres);

		// Cria os pagamentos e adiciona aos pedidos
		Pagamento pagamentoUm = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedUm, 5);
		pedUm.setPagamento(pagamentoUm);
		
		Pagamento pagamentoDois = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedDois,
				stf.parse("24/06/2018 16:31"), null);
		pedDois.setPagamento(pagamentoDois);

		clienteUm.getPedidos().add(pedUm);
		clienteDois.getPedidos().add(pedDois);

		pedidoRepository.saveAll(Arrays.asList(pedUm, pedDois));
		pagamentoRepository.saveAll(Arrays.asList(pagamentoUm, pagamentoDois));

	}

}

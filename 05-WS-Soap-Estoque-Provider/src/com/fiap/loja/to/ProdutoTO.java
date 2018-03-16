package com.fiap.loja.to;

import java.io.Serializable;

/**
 * Transfere os dados do produto para outras camadas da aplicação
 * @author Thiago Yamamoto
 * @version 1.0
 *
 */
public class ProdutoTO implements Serializable {

	/**
	 * Código do produto
	 */
	private int codigo;
	
	/**
	 * Nome do produto
	 */
	private String nome;
	
	/**
	 * Preço do produto
	 */
	private double preco;
	
	/**
	 * Quantidade em estoque
	 */
	private int quantidade;
	
	public ProdutoTO() {
		super();
	}

	public ProdutoTO(int codigo, String nome, double preco, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}

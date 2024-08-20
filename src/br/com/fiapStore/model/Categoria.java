package br.com.fiapStore.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String Nome;
    private int idCategoria;
    private List<Produto> produtos = new ArrayList<Produto>();

    // Constructors

    public Categoria() {
    }

    public Categoria(String nome, int idCategoria) {
        Nome = nome;
        this.idCategoria = idCategoria;
    }

    // Getters and setters

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionaProduto(Produto produto) {
        produtos.add(produto);
    }
}

package br.com.fiapStore.model;

public class Produto {
    private int IdProduto;
    private String Nome;
    private String Descricao;
    private double Preco;
    private int IdCategoria;

    // Constructors

    public Produto() {
    }

    public Produto(int idProduto, String nome, String descricao, double preco, int idCategoria) {
        IdProduto = idProduto;
        Nome = nome;
        Descricao = descricao;
        Preco = preco;
        IdCategoria = idCategoria;
    }

    // Getters and setters

    public int getIdProduto() {
        return IdProduto;
    }

    public void setIdProduto(int idProduto) {
        IdProduto = idProduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        IdCategoria = idCategoria;
    }
}

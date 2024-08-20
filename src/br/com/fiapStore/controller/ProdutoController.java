package br.com.fiapStore.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiapStore.dao.ProdutoDAO;
import br.com.fiapStore.factory.ConnectionFactoryPool;
import br.com.fiapStore.model.Produto;

public class ProdutoController {

    private ProdutoDAO produtoDAO;

    public ProdutoController() throws SQLException {
        Connection connection = ConnectionFactoryPool.getConnection();
        this.produtoDAO = new ProdutoDAO(connection);
    }

    public void salvarComCategoria(Produto produto) {
        this.produtoDAO.salvarComCategoria(produto);
    }

    public List<Produto> listarTodos() {
        return this.produtoDAO.listarTodos();
    }

    public List<Produto> listarPorCategoria(int idCategoria) {
        return this.produtoDAO.listarPorCategoria(idCategoria);
    }

    public void alterar(Produto produto) {
        this.produtoDAO.alterar(produto);
    }

    public void excluir(int idProduto) {
        this.produtoDAO.excluir(idProduto);
    }
}

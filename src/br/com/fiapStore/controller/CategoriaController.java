package br.com.fiapStore.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiapStore.dao.CategoriaDAO;
import br.com.fiapStore.factory.ConnectionFactoryPool;
import br.com.fiapStore.model.Categoria;

public class CategoriaController {

    private CategoriaDAO categoriaDAO;

    public CategoriaController() throws SQLException {
        Connection connection = ConnectionFactoryPool.getConnection();
        categoriaDAO = new CategoriaDAO(connection);
    }

    public List<Categoria> listarTodas() throws SQLException {
        return this.categoriaDAO.listarTodas();
    }

    public List<Categoria> listarComProduto() throws SQLException {
        return this.categoriaDAO.listarComProduto();
    }
}

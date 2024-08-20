package br.com.fiapStore.dao;

import br.com.fiapStore.model.Categoria;
import br.com.fiapStore.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private final Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listarTodas() {
        try {
            List<Categoria> categorias = new ArrayList<Categoria>();
            String sql = "select * from categorias";
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt(1));
                categoria.setNome(rs.getString(2));
                categorias.add(categoria);
            }
            rs.close();
            stmt.close();
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Categoria> listarComProduto() {
        try {
            Categoria categoriaAtual = null;
            List<Categoria> categorias = new ArrayList<Categoria>();
            String sql = "SELECT C.idCategoria, C.nome, P.idProduto, P.nome, P.preco,P.descricao, P.idCategoria FROM CATEGORIAS C INNER JOIN PRODUTOS P ON C.idCategoria = P.idCategoria ORDER BY C.idCategoria";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                if (categoriaAtual == null || !categoriaAtual.getNome().equals(rs.getString(2))) {
                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(rs.getInt(1));
                    categoria.setNome(rs.getString(2));
                    categorias.add(categoria);
                    categoriaAtual = categoria;
                }
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt(3));
                produto.setNome(rs.getString(4));
                produto.setPreco(rs.getDouble(5));
                produto.setDescricao(rs.getString(6));
                produto.setIdCategoria(rs.getInt(7));
                categoriaAtual.adicionaProduto(produto);
            }
            rs.close();
            stmt.close();
            return categorias;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Categoria categoria) {
        try {
            String sql = "INSERT INTO CATEGORIAS (NOME, idCategoria) VALUES (?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getIdCategoria());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar(Categoria categoria) {
        try {
            String sql = "UPDATE CATEGORIAS C SET C.nome = ?, C.idCategoria=? WHERE idCategoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) {
        try {
            String sql = "DELETE FROM CATEGORIAS WHERE idCategoria = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package br.com.fiapStore.dao;

import br.com.fiapStore.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;
    public boolean validarUsuario(Usuario usuario) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM TB_USER WHERE EMAIL = ? AND SENHA = ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            rs = stmt.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                rs.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}

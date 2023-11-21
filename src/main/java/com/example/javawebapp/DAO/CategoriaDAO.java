package com.example.javawebapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.example.javawebapp.BD.ConexaoBD;
import com.example.javawebapp.Entity.Categoria;

public class CategoriaDAO {
    public static Categoria buscarPorNome(String nome) {
        String sql = "SELECT * FROM categoria WHERE nome = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, nome);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Categoria(rs.getInt("id"), rs.getString("nome"), rs.getString("imagem"));
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }

        return null;
    }
}

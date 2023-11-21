package com.example.javawebapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.javawebapp.BD.ConexaoBD;
import com.example.javawebapp.Entity.Donor;
import com.example.javawebapp.Entity.Item;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ItemDAO {
    public static Item cadastrar(String nome, String quantidade, Boolean novo_usado, java.util.Date validade, String tamanho, String estado, String observacao, int idCampanha, HttpServletRequest req){
        Item item = null;
        java.sql.Date validadeSQL = new java.sql.Date(validade.getTime());
        HttpSession session = req.getSession();
        Donor user = (Donor) session.getAttribute("Donor");
        String sql = "INSERT INTO Item (nome, quantidade, novo_usado, validade, tamanho, estado, observacao, id_doador, id_campanha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nome);
            statement.setString(2, quantidade);
            statement.setBoolean(3, novo_usado);
            statement.setDate(4, validadeSQL);
            statement.setString(5, tamanho);
            statement.setString(6, estado);
            statement.setString(7, observacao);
            statement.setInt(8, idCampanha);
            statement.setInt(9, user.getId());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                item = new Item(rs.getInt(1), nome, quantidade, novo_usado, validade, tamanho, estado, observacao, idCampanha);
            }

            rs.close();

            return item;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Item> listarTodos() {
        String sql = "SELECT * FROM item;";
        java.util.List<Item> itens = new ArrayList<>();

        try (
            Connection connection = ConexaoBD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                itens.add(
                    new Item(
                        rs.getInt("id"),  
                        rs.getString("nome"),
                        rs.getString("quantidade"),
                        rs.getBoolean("novo_usado"),
                        rs.getDate("validade"),
                        rs.getString("tamanho"),
                        rs.getString("estado"),
                        rs.getString("observacao"),
                        rs.getInt("id_campanha")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return itens;
        } 
        return itens;
    }

    public static Item buscarPorId(Integer id) {
        String sql = "SELECT * FROM item WHERE id = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Item(
                        rs.getInt("id"),  
                        rs.getString("nome"),
                        rs.getString("quantidade"),
                        rs.getBoolean("novo_usado"),
                        rs.getDate("validade"),
                        rs.getString("tamanho"),
                        rs.getString("estado"),
                        rs.getString("observacao"),
                        rs.getInt("id_campanha")
                    );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }
}

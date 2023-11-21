package com.example.javawebapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.javawebapp.BD.ConexaoBD;
import com.example.javawebapp.Entity.Campaign;
import com.example.javawebapp.Entity.Organization;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class CampaignDAO {
    public static Campaign cadastrar(String titulo, java.util.Date vencimento, String descricao, int idOrganizacao, String categoria, Integer meta, String tipo, HttpServletRequest req) {
        Campaign campaign = null;
        java.sql.Date vencimentoSQL = new java.sql.Date(vencimento.getTime());
        HttpSession session = req.getSession();
        Organization user = (Organization) session.getAttribute("Organization");

        String sqlInsertCampanha = "INSERT INTO campaign(titulo, vencimento, descricao, tipo, id_organization, id_deposito) VALUES (?, ?, ?, ?, ?, ?)";
        String sqlInsertCampanhaCategoria = "INSERT INTO campanhacategoria (arrecadacao, meta, id_campanha, id_categoria) VALUES (?, ?, ?, ?)";
    
        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statementCampanha = connection.prepareStatement(sqlInsertCampanha, Statement.RETURN_GENERATED_KEYS);
            PreparedStatement statementCampanhaCategoria = connection.prepareStatement(sqlInsertCampanhaCategoria);
        ) {
            statementCampanha.setString(1, titulo);
            statementCampanha.setDate(2, vencimentoSQL);
            statementCampanha.setString(3, descricao);
            statementCampanha.setString(4, tipo);
            statementCampanha.setInt(5, user.getId());
            statementCampanha.setInt(6, 0);
    
            int affectedRows = statementCampanha.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Falha ao criar a campanha, nenhuma linha afetada.");
            }
    
            ResultSet generatedKeys = statementCampanha.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idCampanha = generatedKeys.getInt(1);
                campaign = new Campaign(idCampanha, titulo, vencimento, descricao);
    
                statementCampanhaCategoria.setInt(1, 0);
                statementCampanhaCategoria.setInt(2, meta); 
                statementCampanhaCategoria.setInt(3, idCampanha); 
                statementCampanhaCategoria.setInt(4, CategoriaDAO.buscarPorNome(categoria).getId());
    
                statementCampanhaCategoria.executeUpdate();
            } else {
                throw new SQLException("Falha ao criar a campanha, nenhum ID retornado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    
        return campaign;
    }

    public static List<Campaign> listarTodos() {
        String sql = "SELECT * FROM campaign;";
        java.util.List<Campaign> campaign = new ArrayList<>();

        try (
            Connection connection = ConexaoBD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                campaign.add(
                    new Campaign(
                        rs.getInt("id"),  
                        rs.getString("titulo"),
                        rs.getDate("vencimento"),
                        rs.getString("descricao")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return campaign;
        } 
        return campaign;
    }

    public static Campaign buscarPorId(Integer id) {
        String sql = "SELECT * FROM campaign WHERE id = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Campaign(
                        rs.getInt("id"),  
                        rs.getString("titulo"),
                        rs.getDate("vencimento"),
                        rs.getString("descricao")
                    );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public static List<Campaign> buscarCampanhas(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Organization user = (Organization) session.getAttribute("Organization");
        Integer id = user.getId();
        java.util.List<Campaign> campaign = new ArrayList<>();
        String sql = "SELECT c.id AS campanha_id, c.titulo, c.vencimento, c.descricao, c.tipo, cc.meta, cat.nome AS nome_categoria "
            + "FROM campaign c JOIN campanhacategoria cc ON c.id = cc.id_campanha "
            + "JOIN categoria cat ON cc.id_categoria = cat.id "
            + "WHERE c.id_organization = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id); // Substitui o '?' pelo valor de 'id'
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                campaign.add(
                    new Campaign(
                        rs.getInt("campanha_id"),
                        rs.getString("titulo"),
                        rs.getDate("vencimento"),
                        rs.getString("descricao"),
                        rs.getString("tipo"),
                        rs.getInt("meta"),
                        rs.getString("nome_categoria")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return campaign;
        }
        return campaign;
    }

    public static List<Campaign> buscarTodasCampanhas(){
        java.util.List<Campaign> campaign = new ArrayList<>();
        String sql = "SELECT c.id AS campanha_id, c.titulo, c.vencimento, c.descricao, c.tipo, cc.meta, cat.nome AS nome_categoria, cat.imagem "
            + "FROM campaign c JOIN campanhacategoria cc ON c.id = cc.id_campanha "
            + "JOIN categoria cat ON cc.id_categoria = cat.id ";

            try (
                Connection connection = ConexaoBD.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
            ) {
                while(rs.next()) {
                    campaign.add(
                        new Campaign(
                            rs.getInt("campanha_id"),  
                            rs.getString("titulo"),
                            rs.getDate("vencimento"),
                            rs.getString("descricao"),
                            rs.getInt("meta"),
                            rs.getString("nome_categoria"),
                            rs.getString("tipo"),
                            rs.getString("imagem")
                        )
                    );
                }
            } catch (Exception e) {
                e.printStackTrace();
                return campaign;
            } 
            return campaign;
        } 

    public static Boolean existeComTitulo(String titulo) {
        return buscarPortitulo(titulo) != null;
    }

    public static Campaign buscarPortitulo(String titulo) {
        String sql = "SELECT * FROM campaign WHERE titulo = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, titulo);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Campaign(
                        rs.getInt("id"),  
                        rs.getString("titulo"),
                        rs.getDate("vencimento"),
                        rs.getString("descricao")
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

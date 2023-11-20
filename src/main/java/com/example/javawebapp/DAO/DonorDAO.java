package com.example.javawebapp.DAO;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;

import com.example.javawebapp.BD.ConexaoBD;
import com.example.javawebapp.Entity.Donor;


// DAO = Data Access Object
public class DonorDAO {
    public static Donor cadastrar(String telefone, String email, String senha, String name, String sobrenome, String cpf, Boolean adm, Date dataNascimento) {
        Donor donor = null;
        String hashSenha = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        java.sql.Date dataNascimentoSQL = new java.sql.Date(dataNascimento.getTime());
        String sql = "INSERT INTO donor (telefone, email, senha, nome, sobrenome, cpf, administrador, data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, telefone);
            statement.setString(2, email);
            statement.setString(3, hashSenha);
            statement.setString(4, name);
            statement.setString(5, sobrenome);
            statement.setString(6, cpf);
            statement.setBoolean(7, adm);
            statement.setDate(8, dataNascimentoSQL);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                donor = new Donor(rs.getInt(1), telefone, email, hashSenha, name, sobrenome, cpf, adm, rs.getDate(1));
            }

            rs.close();

            return donor;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Donor> listarTodos() {
        String sql = "SELECT * FROM Donors;";
        java.util.List<Donor> donors = new ArrayList<>();

        try (
            Connection connection = ConexaoBD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                donors.add(
                    new Donor(
                        rs.getInt("id"),  
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("cpf"),
                        rs.getBoolean("administrador"), 
                        rs.getDate("data_nascimento")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return donors;
        } 
        return donors;
    }

    public static Donor buscarPorId(Integer id) {
        String sql = "SELECT * FROM donor WHERE id = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Donor(
                        rs.getInt("id"),  
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("cpf"),
                        rs.getBoolean("administrador"), 
                        rs.getDate("data_nascimento")
                    );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public static Donor buscarPorEmail(String email) {
        String sql = "SELECT * FROM donor WHERE email = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Donor(
                        rs.getInt("id"),  
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getString("sobrenome"),
                        rs.getString("cpf"),
                        rs.getBoolean("administrador"), 
                        rs.getDate("data_nascimento")
                    );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public static Boolean login(String email, String senha) {
        Donor donor = buscarPorEmail(email);
        if (donor != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(senha.toCharArray(), donor.getSenha());
            return result.verified;
        }
        return false;
    }

    public static Boolean existeComEmail(String email) {
        return buscarPorEmail(email) != null;
    }
}
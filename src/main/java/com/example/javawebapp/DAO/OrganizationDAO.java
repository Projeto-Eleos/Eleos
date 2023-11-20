package com.example.javawebapp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;

import com.example.javawebapp.BD.ConexaoBD;
import com.example.javawebapp.Entity.Organization;


// DAO = Data Access Object
public class OrganizationDAO {
    public static Organization cadastrar(String telefone, String email, String senha, String razaoSocial, String endereco, String cnpj) {
        String hashSenha = BCrypt.withDefaults().hashToString(12, senha.toCharArray());
        Organization organization = null;
        String sql = "INSERT INTO organization (razaosocial, email, endereco, telefone, senha, cnpj) VALUES (?, ?, ?, ?, ?, ?);";

  
        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, razaoSocial);
            statement.setString(2, email);
            statement.setString(3, endereco);
            statement.setString(4, telefone);
            statement.setString(5, hashSenha);
            statement.setString(6, cnpj);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                organization = new Organization(rs.getInt(1), telefone, email, hashSenha, razaoSocial, endereco, cnpj);
            }

            rs.close();

            return organization;  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Organization> listarTodos() {
        String sql = "SELECT * FROM organizations;";
        java.util.List<Organization> Organizations = new ArrayList<>();

        try (
            Connection connection = ConexaoBD.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ) {
            while(rs.next()) {
                Organizations.add(
                    new Organization(
                        rs.getInt("id"),  
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("razaosocial"),
                        rs.getString("endereco"),
                        rs.getString("cnpj")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Organizations;
        } 
        return Organizations;
    }

    public static Organization buscarPorId(Integer id) {
        String sql = "SELECT * FROM organization WHERE id = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Organization(
                        rs.getInt("id"),  
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("razaosocial"),
                        rs.getString("endereco"),
                        rs.getString("cnpj")
                    );
            }

            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return null;
    }

    public static Organization buscarPorEmail(String email) {
        String sql = "SELECT * FROM organization WHERE email = ?;";

        try (
            Connection connection = ConexaoBD.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return new Organization(
                        rs.getInt("id"),  
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("razaosocial"),
                        rs.getString("endereco"),
                        rs.getString("cnpj")
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
        Organization organization = buscarPorEmail(email);
        if (organization != null) {
            BCrypt.Result result = BCrypt.verifyer().verify(senha.toCharArray(), organization.getSenha());
            return result.verified;
        }
        return false;
    }

    public static Boolean existeComEmail(String email) {
        return buscarPorEmail(email) != null;
    }
}
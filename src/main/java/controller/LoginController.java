package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.ConexaoBD;
import model.Usuario;

public class LoginController {

    // Método de autenticação de usuário
    public Usuario authenticate(String cpf, String senha, String tipoUsuario) {
        // Variáveis para armazenar a consulta e o tipo de tabela
        String query = "";

        // Verifica o tipo de usuário e ajusta a consulta SQL
        if (tipoUsuario.equals("Porteiro")) {
            query = "SELECT * FROM Usuario WHERE cpf = ? AND senha = ? and cargo = ?";
        } else if (tipoUsuario.equals("Coped")) {
            query = "SELECT * FROM Usuario WHERE cpf = ? AND senha = ? and cargo = ?";
        }

        try (Connection connection = ConexaoBD.getConection(); 
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Definindo os parâmetros para a consulta SQL
            preparedStatement.setString(1, cpf);
            preparedStatement.setString(2, senha);
            preparedStatement.setString(3, tipoUsuario);

            // Executando a consulta
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Verifica se existe algum registro no banco de dados
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    int idUsuario = resultSet.getInt("id_usuario");
                    String cargo = resultSet.getString("cargo");// Supondo que o campo seja id_usuario

                    // Retorna um objeto Usuario com id_usuario, nome, matricula e senha
                    return new Usuario(idUsuario, nome, cpf, senha,cargo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao autenticar o usuário: " + e.getMessage());
        }

        // Retorna null caso o usuário não seja encontrado
        return null;
    }
}

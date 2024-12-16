package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConexaoBD;
import model.Usuario;

public class UsuarioController {
    
     public boolean cadastroUsuario( Usuario usuario){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Usuario ( nome,cpf,senha, cargo) values (?,?,?,?) ";
     
     try(Connection conection = ConexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,usuario.getNome());
            preparedStatement.setString(2,usuario.getCpf());
            preparedStatement.setString(3,usuario.getSenha());
             preparedStatement.setString(4,usuario.getCargo());
           
           
            
            /*try(ResultSet resultSet = preparedStatement.executeQuery()){
                return resultSet.next();
            }// final do segundo try*/
            // verifica se o insert foi executado
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
            
        }catch(SQLException e){
            // imprimindo erro que deu ao inserir usuário
            System.err.print("Erro ao Inserir Dados!" + e);
            return false;
        }// final do try catch
    
}// fim do método cadastroTurno()
     public List<Usuario> listarUsuario(){
        List<Usuario> lista = new ArrayList<>();
        
        String query = "SELECT id_usuario,nome,cpf,cargo FROM Usuario ;";

        try(Connection connection = ConexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                
                usuario.setId_usuario(resultSet.getInt("id_usuario"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setCargo(resultSet.getString("cargo"));
                
                
                lista.add(usuario);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
     public boolean deletarUsuario(int idUsuario){
         String query = "DELETE FROM Usuario WHERE id_usuario = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = ConexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idUsuario);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
     public List<Usuario> listarUsuarioNome(String nome){
     
     String query = "SELECT id_usuario,nome,cpf,cargo FROM Usuario where nome LIKE ?;";
     
      List<Usuario> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = ConexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Usuario usuario = new Usuario();
                  usuario.setId_usuario(resultset.getInt("id_usuario"));
                  usuario.setNome(resultset.getString("nome"));
                  usuario.setCpf(resultset.getString("cpf"));
                  usuario.setCargo(resultset.getString("cargo"));
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(usuario);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
}
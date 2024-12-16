/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ConexaoBD;
import model.Sala;

/**
 *
 * @author devmat
 */
public class SalaController {
    
    public boolean cadastroSala( Sala sala){
     //criuando uma String que recebe uma comando SQL
     String query = "INSERT INTO Salas ( nome_sala,capacidade_sala ,descricao_sala) values (?,?,?) ";
     
     try(Connection conection = ConexaoBD.getConection();
        PreparedStatement preparedStatement =
                conection.prepareStatement(query)){       
            
            // mandar os dados para dentro do insert
            preparedStatement.setString(1,sala.getNome_sala());
            preparedStatement.setString(2,sala.getCapacidade_sala());
            preparedStatement.setString(3,sala.getDescricao_sala());
           
           
            
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
        
    }// fim do metodo cadastrandoProdutos()
    public List<Sala> listarSala(){
        List<Sala> lista = new ArrayList<>();
        
        String query = "SELECT * FROM Salas ;";

        try(Connection connection = ConexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                Sala sala = new Sala();
                
                sala.setId_sala(resultSet.getInt("id_sala"));
                sala.setNome_sala(resultSet.getString("nome_sala"));
                sala.setCapacidade_sala(resultSet.getString("capacidade_sala"));
                sala.setDescricao_sala(resultSet.getString("descricao_sala"));
                
                
                lista.add(sala);

            }//fim do while
          
             return lista;
            
        }catch(SQLException e){
         System.err.println("Erro listar o usuário "+ e );
         return null;
        }//fim do try
        
    }//fim do método listarClientes()
    
    public boolean deletarSala(int idSala){
         String query = "DELETE FROM Salas WHERE id_sala = ?";
        //Connection - conecta-se ao banco de dados
        //PreparedStatement manda o comando sql para executar no BD
        try (Connection connection = ConexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){//mandar o comando select 
            //mandando idUsuario para dentro do camando sql
            preparedStatement.setInt(1,idSala);
            
                        int resultado = preparedStatement.executeUpdate();
            return resultado > 0;
           
        }catch(SQLException e){
             System.err.print(e+ " Exclusão não realizada  ");
            return false;
        }//fim do 
     }//fim do public boolean
    
    
    public List<Sala> listarSalaNome(String nome){
     
     String query = "SELECT * FROM Salas where nome_sala LIKE ?;";
     
      List<Sala> lista = new ArrayList<>();
        // criando o try catch
        try(Connection conection = ConexaoBD.getConection();
        PreparedStatement preparedStatement = conection.prepareStatement(query)){
            
             preparedStatement.setString(1,'%'+nome+'%');
                
                ResultSet resultset = preparedStatement.executeQuery();
            // passando o valor do select para um objeto produto
            // enquanto resultset for diferente de null
            while(resultset.next()){
                // receba o valor e cadastre em produto
                  Sala sala = new Sala();
                  sala.setId_sala(resultset.getInt("id_sala"));
                  sala.setNome_sala(resultset.getString("nome_sala"));
                  sala.setCapacidade_sala(resultset.getString("capacidade_sala"));
                  sala.setDescricao_sala(resultset.getString("descricao_sala"));
                  
                  
                  // jogando o produto dentro da lista
                  lista.add(sala);
             }// fim do while
            return lista;
         
     }catch(SQLException erro){
         System.err.print("Erro:  " + erro);
            return null;
     }//fim do catch
     
     
 }// fim do método listarProdutorNome
        
    }


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.ConexaoBD;
import model.Reserva;

/**
 *
 * @author Estudo_TI
 */
public class ReservaController {
    public boolean cadastrarReserva(Reserva reserva){
        String query ="INSERT INTO Reservas(id_usuario,id_sala,,turno,data_reserva ) VALUES (?,?,?,?,?,?,?);";
        
        try(Connection connection = ConexaoBD.getConection();//conexão com o banco de dados
     PreparedStatement preparedStatement = connection.prepareStatement(query)){
            
            
            preparedStatement.setInt(1, reserva.getIdUsuario());
             preparedStatement.setInt(2, reserva.getIdSala());          
            preparedStatement.setString(3, reserva.getTurno());
            preparedStatement.setString(4, reserva.getDataReserva());
            
            
            int cadastrou = preparedStatement.executeUpdate();
            return cadastrou>=0;
            
        }catch(Exception e){
         System.err.print("Erro ao Cadastrar Vendas!" + e);
            return false;
        }//fim do try
       
    } //fim do método CadastrarVendas();
    
}

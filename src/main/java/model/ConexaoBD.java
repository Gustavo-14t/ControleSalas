/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Estudo_TI
 */
public class ConexaoBD {
    
 //conectando o SQL SERVER
    /*CRIANDO UMA VARIÁVEL PARA CAPTURAR O ENDEREÇO DE CONEXÃO
    COM O BANCO DE DADOS.
    JDBC:SQLSERVER - É O DRIVER
     */
    
    private static String URL="jdbc:sqlserver://localhost:1433;databaseName=Controle_de_Salas;"
            + "integratedSecurity=true;"
            + "trustServerCertificate=true"; 
    
    public static Connection getConection(){
        // criando um objeto do tipo Connection
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL);
            System.out.println("Conexão bem sucedida!");
        }catch(SQLException e){
            System.out.println("Erro de conexão"+ e);
        }//final do try catch
        return connection;
    }//final do getConnection
          
}    

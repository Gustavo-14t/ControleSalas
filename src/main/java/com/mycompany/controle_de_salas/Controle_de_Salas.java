/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controle_de_salas;

import java.sql.Connection;
import static model.ConexaoBD.getConection;
import view.TelaLogin;

/**
 *
 * @author Estudo_TI
 */
public class Controle_de_Salas {

    public static void main(String[] args) {
        /*Connection conexao =getConection();
       if(conexao!= null){
           System.out.println("Conexão deu certo");
       }else{
           System.out.println("Conexão deu errado");
       }*/
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
    }
}

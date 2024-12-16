/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author devmat
 */
public class Sala {
    
    int id_sala;
    String nome_sala;
    String capacidade_sala;
    String descricao_sala;

    public Sala(int id_sala, String nome_sala, String capacidade_sala, String descricao_sala) {
        this.id_sala = id_sala;
        this.nome_sala = nome_sala;
        this.capacidade_sala = capacidade_sala;
        this.descricao_sala = descricao_sala;
    }

    public Sala(String nome_sala, String capacidade_sala, String descricao_sala) {
        this.nome_sala = nome_sala;
        this.capacidade_sala = capacidade_sala;
        this.descricao_sala = descricao_sala;
    }

    public Sala() {
    }

    public int getId_sala() {
        return id_sala;
    }

    public void setId_sala(int id_sala) {
        this.id_sala = id_sala;
    }

    public String getNome_sala() {
        return nome_sala;
    }

    public void setNome_sala(String nome_sala) {
        this.nome_sala = nome_sala;
    }

    public String getCapacidade_sala() {
        return capacidade_sala;
    }

    public void setCapacidade_sala(String capacidade_sala) {
        this.capacidade_sala = capacidade_sala;
    }

    public String getDescricao_sala() {
        return descricao_sala;
    }

    public void setDescricao_sala(String descricao_sala) {
        this.descricao_sala = descricao_sala;
    }
    
    
    
}

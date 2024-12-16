/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Estudo_TI
 */
public class Reserva {
    int idReserva;
    int idUsuario;
    int idSala;   
    String turno;
    String dataReserva;

    public Reserva(int idReserva, int idUsuario, int idSala, String turno, String dataReserva) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idSala = idSala;
        this.turno = turno;
        this.dataReserva = dataReserva;
    }
    
       public Reserva(int idUsuario, int idSala, String turno, String dataReserva) {
        this.idUsuario = idUsuario;
        this.idSala = idSala;
        this.turno = turno;
        this.dataReserva = dataReserva;
    }

    public Reserva() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
       

}

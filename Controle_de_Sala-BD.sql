CREATE DATABASE Controle_de_Salas
USE Controle_de_Salas



-- Tabela para cadastro de professores e funcion�rios
CREATE TABLE Usuario (
    id_usuario INT PRIMARY KEY IDENTITY(1,1),
    nome  VARCHAR (45) NOT NULL,
    cpf VARCHAR (14)  NOT NULL,
    senha  VARCHAR (45) , 
	cargo VARCHAR (20) NOT NULL
);

insert into  Usuario(nome,cpf,senha,cargo) values ('Roberto','123.456.678.12','senha1234','Coped')
insert into  Usuario(nome,cpf,senha,cargo) values ('Pedro','895.678.456-01','senha123','Porteiro')

drop database Controle_de_Salas
SELECT id_usuario,nome,cpf,cargo FROM Usuario
SELECT * FROM Salas

-- Tabela para cadastro de salas
CREATE TABLE Salas (
    id_sala INT PRIMARY KEY IDENTITY (1,1),
    nome_sala VARCHAR (40) NOT NULL,
    capacidade_sala VARCHAR (40) NOT NULL,
	descricao_sala VARCHAR (200) NOT NULL
);

-- Tabela para cadastro de turnos

-- Tabela para registro de reservas de salas
cREATE TABLE Reservas (
    id_reserva INT PRIMARY KEY IDENTITY (1,1),
    id_usuario INT FOREIGN KEY REFERENCES Usuario (id_usuario) NOT NULL,
    id_sala INT FOREIGN KEY REFERENCES Salas (id_sala) NOT NULL,
    turno VARCHAR(20)NOT NULL,
    data_reserva VARCHAR(20) NOT NULL,
	cargo VARCHAR(20) NOT NULL
    
);
SELECT 
    u.nome AS nome_usuario,      -- Pega o nome do usuário
    u.cargo, 
    s.nome_sala,                -- Pega o nome da sala
    r.turno, 
    r.data_reserva
FROM 
    Reservas r
INNER JOIN 
    Usuario u ON r.id_usuario = u.id_usuario
INNER JOIN 
    Salas s ON r.id_sala = s.id_sala;

-- Tabela para controle de entrega e devolu��o de chaves
CREATE TABLE ControleChaves (
    id_controle INTEGER PRIMARY KEY AUTOINCREMENT,
    id_reserva INTEGER NOT NULL,
    data_hora_entrega DATETIME NOT NULL,
    data_hora_devolucao DATETIME,
    porteiro_entrega VARCHAR NOT NULL,
    porteiro_devolucao VARCHAR,
    FOREIGN KEY (id_reserva) REFERENCES Reservas (id_reserva)
);


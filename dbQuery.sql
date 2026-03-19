-- Facem o baza de date pentru proiectul de automation

CREATE database PracticeSoftwareDB;

USE PracticeSoftwareDB;

CREATE table User(
	idUser int auto_increment not null,
    email varchar(50),
    password varchar(50),
    primary key(idUser)
);
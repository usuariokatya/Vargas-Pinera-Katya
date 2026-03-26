/*
Created: 06/06/2017
Modified: 25/03/2026
Model: Happinness&Co
Database: Oracle 11g Release 2
*/


-- Create tables section -------------------------------------------------

-- Table Usuarios

CREATE TABLE Usuarios(
  id Number(10,0) NOT NULL,
  Nombre Varchar2(30 ) NOT NULL,
  Email Varchar2(30 ) NOT NULL,
  Password Varchar2(30 ) NOT NULL
)
/

-- Add keys for table Usuarios

ALTER TABLE Usuarios ADD CONSTRAINT PK_Usuarios PRIMARY KEY (id)
/

-- Table Favoritos

CREATE TABLE Favoritos(
  id Number(10,0) NOT NULL
)
/

-- Create indexes for table Favoritos

CREATE INDEX IX_Relationship1 ON Favoritos (id)
/

-- Table Eventos

CREATE TABLE Eventos(
  id Number(10,0) NOT NULL,
  Fecha Date NOT NULL,
  Titulo Varchar2(30 ) NOT NULL,
  Ubicación Varchar2(30 ) NOT NULL,
  Descripción Varchar2(30 ) NOT NULL
)
/

CREATE INDEX IX_Relationship2 ON Eventos ()
/

-- Add keys for table Eventos

ALTER TABLE Eventos ADD CONSTRAINT PK_Eventos PRIMARY KEY (id)
/

-- Table Galerías

CREATE TABLE Galerías(
  id Number(10,0) NOT NULL,
  Titulo Varchar2(30 ) NOT NULL,
  Id_evento Number(10,0) NOT NULL
)
/

-- Add keys for table Galerías

ALTER TABLE Galerías ADD CONSTRAINT PK_Galerías PRIMARY KEY (id)
/

-- Table Imagenes_galerías

CREATE TABLE Imagenes_galerías(
  id Number(10,0) NOT NULL,
  Titulo Varchar2(30 ) NOT NULL,
  Imagen Char(20 ) NOT NULL,
  Id_galeria Number(10,0) NOT NULL
)
/

-- Add keys for table Imagenes_galerías

ALTER TABLE Imagenes_galerías ADD CONSTRAINT PK_Imagenes_galerías PRIMARY KEY (id)
/




-- Create foreign keys (relationships) section ------------------------------------------------- 

ALTER TABLE Favoritos ADD CONSTRAINT marca FOREIGN KEY (id) REFERENCES Usuarios (id)
/



ALTER TABLE Eventos ADD CONSTRAINT favde FOREIGN KEY () REFERENCES Favoritos ()
/



ALTER TABLE Galerías ADD CONSTRAINT tiene FOREIGN KEY () REFERENCES Favoritos ()
/



ALTER TABLE Imagenes_galerías ADD CONSTRAINT contiene FOREIGN KEY (id) REFERENCES Galerías (id)
/




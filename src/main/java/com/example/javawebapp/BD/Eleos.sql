DROP DATABASE eleos;
CREATE DATABASE IF NOT EXISTS eleos;
USE eleos;

CREATE TABLE donor (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  sobrenome VARCHAR(255) NOT NULL,
  telefone VARCHAR(13) NOT NULL,
  cpf CHAR(11) NOT NULL,
  email VARCHAR(255) NOT NULL,
  senha CHAR(60) NOT NULL,
  administrador BOOLEAN NOT NULL,
  data_nascimento DATE NOT NULL
);

CREATE TABLE organization (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  razaosocial VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  telefone VARCHAR(13) NOT NULL,
  senha CHAR(60) NOT NULL,
  cnpj VARCHAR(14) NOT NULL
);

CREATE TABLE deposito (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  endereco VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  capacidade VARCHAR(255) NOT NULL
);

CREATE TABLE categoria (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  imagem VARCHAR(255) NOT NULL
);

CREATE TABLE campaign (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  vencimento DATETIME NOT NULL,
  descricao VARCHAR(1020) NOT NULL,
  tipo VARCHAR(255) NOT NULL,
  id_organization INT NOT NULL,
  FOREIGN KEY (id_organization) REFERENCES campaign(id),
  id_deposito INT NOT NULL DEFAULT 0
);

CREATE TABLE item (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  quantidade VARCHAR(255) NOT NULL,
  novo_usado BOOLEAN NOT NULL,
  validade DATETIME NOT NULL,
  tamanho VARCHAR(10) NOT NULL,
  estado VARCHAR(255) NOT NULL,
  observacao VARCHAR(255),
  id_doador INT NOT NULL,
  id_campanha INT NOT NULL,
  FOREIGN KEY (id_doador) REFERENCES donor(id),
  FOREIGN KEY (id_campanha) REFERENCES campaign(id)
);

CREATE TABLE campanhacategoria (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  arrecadacao INT,
  meta INT,
  id_campanha INT NOT NULL,
  FOREIGN KEY (id_campanha) REFERENCES campaign(id),
  id_categoria INT NOT NULL,
  FOREIGN KEY (id_categoria) REFERENCES Categoria(id)
);

INSERT INTO categoria (nome, imagem) VALUES ('Saúde', 'saude.jpeg');
INSERT INTO categoria (nome, imagem) VALUES ('Educação', 'educacao.jpeg');
INSERT INTO categoria (nome, imagem) VALUES ('Assistência Social', 'assistencia-social.jpeg');
INSERT INTO categoria (nome, imagem) VALUES ('Meio Ambiente', 'meio-ambiente.jpeg');
INSERT INTO categoria (nome, imagem) VALUES ('Cultura', 'cultura.jpeg');
INSERT INTO categoria (nome, imagem) VALUES ('Outros', 'outros.jpeg');

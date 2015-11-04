CREATE DATABASE "SistemaVendas"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

CREATE TABLE clientes (
			id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
			nome varchar(40),
			telefone varchar(40),
			endereco varchar(40),
			cidade varchar(40),
			estado varchar(40),
			genero varchar(10),
			email varchar(40)
			);
CREATE TABLE usuarios (
			id int PRIMARY KEY NOT NULL,
			senha varchar(4),
			id_cliente int NOT NULL references clientes(id)
			);
CREATE TABLE produtos (
			id int PRIMARY KEY NOT NULL,
			descricao varchar(40),
			departamento varchar(40),
			unidade varchar(8),
			custo smallint,
			margem smallint			
			);
CREATE TABLE vendas (
			id int PRIMARY KEY NOT NULL,
			id_cliente int NOT NULL references clientes(id),
			id_produto int NOT NULL references produtos(id),
			quantidade int,
			total float,
			totalpago float,
			troco float
			);
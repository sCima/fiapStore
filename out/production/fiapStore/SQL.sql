DROP SEQUENCE produto_sequence;
DROP SEQUENCE categoria_sequence;
DROP TRIGGER tr_insert_id_produto;
DROP TRIGGER tr_insert_id_categoria;
DROP TABLE PRODUTOS;
DROP TABLE CATEGORIAS;
CREATE TABLE CATEGORIAS(
idCategoria integer PRIMARY KEY NOT NULL,
nome varchar(45) NOT NULL
);
CREATE TABLE PRODUTOS (
    idProduto integer PRIMARY KEY NOT NULL,
    nome varchar(45) NOT NULL,
    descricao varchar(200) NOT NULL,
    preco number NOT NULL,
    idCategoria integer NOT NULL,
    CONSTRAINT FK_CATEGORIA FOREIGN KEY (idCategoria) REFERENCES CATEGORIAS (idCategoria)
);
CREATE SEQUENCE produto_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_insert_id_produto
BEFORE INSERT ON PRODUTOS FOR EACH ROW
BEGIN
SELECT produto_sequence.NEXTVAL
INTO :NEW.idProduto
FROM DUAL;
END;
/
CREATE SEQUENCE categoria_sequence START WITH 1 INCREMENT BY 1;
CREATE OR REPLACE TRIGGER tr_insert_id_categoria
BEFORE INSERT ON CATEGORIAS FOR EACH ROW
BEGIN
SELECT categoria_sequence.NEXTVAL
INTO :new.idcategoria
FROM DUAL;
END;
/
INSERT INTO categorias (nome) VALUES ('Eletronicos');
INSERT INTO categorias (nome) VALUES ('Games');
INSERT INTO categorias (nome) VALUES ('Eletrodomesticos');
INSERT INTO categorias (nome) VALUES ('Alimentos');
INSERT INTO categorias (nome) VALUES ('Brinquedos');
COMMIT;
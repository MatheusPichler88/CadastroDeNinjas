-- V2: Criar a tabela tb_cadastro COM foreign key
CREATE TABLE tb_cadastro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    img_url VARCHAR(500),
    idade INT,
    missoes_id BIGINT,
    FOREIGN KEY (missoes_id) REFERENCES tb_missoes(id)
);
-- V1: Criar apenas a tabela tb_missoes
CREATE TABLE tb_missoes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    dificuldade VARCHAR(255)
);
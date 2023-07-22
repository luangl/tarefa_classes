-- Tabela tb_cliente
CREATE TABLE tb_cliente (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cpf BIGINT NOT NULL,
    tel BIGINT NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    numero BIGINT NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    idade INT NOT NULL
);

-- Tabela tb_produto
CREATE TABLE tb_produto (
    id BIGINT PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    valor NUMERIC(10, 2) NOT NULL,
    estoque INT NOT NULL -- Adicionando a coluna "estoque"
);

-- Tabela tb_venda
CREATE TABLE tb_venda (
    id BIGINT PRIMARY KEY,
    codigo VARCHAR(10) NOT NULL,
    id_cliente_fk BIGINT NOT NULL,
    valor_total NUMERIC(10, 2) NOT NULL,
    data_venda TIMESTAMPTZ NOT NULL,
    status_venda VARCHAR(50) NOT NULL,
    CONSTRAINT fk_id_cliente_venda FOREIGN KEY (id_cliente_fk) REFERENCES tb_cliente (id)
);

-- Tabela tb_produto_quantidade
CREATE TABLE tb_produto_quantidade (
    id BIGINT PRIMARY KEY,
    id_produto_fk BIGINT NOT NULL,
    id_venda_fk BIGINT NOT NULL,
    quantidade INT NOT NULL,
    valor_total NUMERIC(10, 2) NOT NULL,
    CONSTRAINT fk_id_prod_venda FOREIGN KEY (id_produto_fk) REFERENCES tb_produto (id),
    CONSTRAINT fk_id_prod_venda_venda FOREIGN KEY (id_venda_fk) REFERENCES tb_venda (id)
);

-- Sequências
CREATE SEQUENCE sq_cliente START 1 INCREMENT 1 OWNED BY tb_cliente.id;
CREATE SEQUENCE sq_produto START 1 INCREMENT 1 OWNED BY tb_produto.id;
CREATE SEQUENCE sq_venda START 1 INCREMENT 1 OWNED BY tb_venda.id;
CREATE SEQUENCE sq_produto_quantidade START 1 INCREMENT 1 OWNED BY tb_produto_quantidade.id;

-- Índices UNIQUE
ALTER TABLE tb_cliente ADD CONSTRAINT UK_CPF_CLIENTE UNIQUE (cpf);
ALTER TABLE tb_produto ADD CONSTRAINT UK_CODIGO_PRODUTO UNIQUE (codigo);
ALTER TABLE tb_venda ADD CONSTRAINT UK_CODIGO_VENDA UNIQUE (codigo);

-- Consultas
SELECT v.id AS id_venda, v.codigo, v.id_cliente_fk, v.valor_total, v.data_venda, v.status_venda,
       c.id AS id_cliente, c.nome, c.cpf, c.tel, c.endereco, c.numero, c.cidade, c.estado, c.idade,
       p.id AS id_prod_qtd, p.quantidade, p.valor_total AS prod_qtd_valor_total
FROM tb_venda v
INNER JOIN tb_cliente c ON v.id_cliente_fk = c.id
INNER JOIN tb_produto_quantidade p ON p.id_venda_fk = v.id
WHERE v.codigo = 'A1';

SELECT pq.id, pq.quantidade, pq.valor_total,
       p.id AS id_produto, p.codigo, p.nome, p.descricao, p.valor
FROM tb_produto_quantidade pq
INNER JOIN tb_produto p ON p.id = pq.id_produto_fk;

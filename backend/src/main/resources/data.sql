INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Danilo', 'silva', 'lilodecorrr@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);


INSERT INTO tb_endereco(cep,bairro,localidade,logradouro,numero,uf)VALUES('13481444','Santina1','Rua Delmiro Jesus Barreto','Limeira','66','SP');
INSERT INTO tb_endereco(cep,bairro,localidade,logradouro,numero,uf)VALUES('13453512','Bairro dos trabalhadores','RUa Antonio de Toledo Melo','Santa Barbara Doeste','134','SP');

INSERT INTO tb_cliente(nome,cpf_cnpj,telefone1,telefone2,endereco_id) VALUES ('Aguinaldo Ronaldo', '39119955841', '19 34455669', '19 34574589',1);
INSERT INTO tb_cliente(nome,cpf_cnpj,telefone1,telefone2,endereco_id) VALUES ('Clodoaldo Roberval', '39119955841', '19 34455669', '19 34574589',1);
INSERT INTO tb_cliente(nome,cpf_cnpj,telefone1,telefone2,endereco_id) VALUES ('Anastacio euclides', '39119955841', '19 34455669', '19 34574589',2);
INSERT INTO tb_cliente(nome,cpf_cnpj,telefone1,telefone2,endereco_id) VALUES ('Romulo afranio', '39119955841', '19 34455669', '19 34574589',2);

INSERT INTO tb_equipamento(nome,valor_da_compra,valor_aluguel_dia,valor_aluguel_quinzena,valor_aluguel_mes) VALUES ('Betoneira 01',8000.00,150.0,500.00,800.00);
INSERT INTO tb_equipamento(nome,valor_da_compra,valor_aluguel_dia,valor_aluguel_quinzena,valor_aluguel_mes) VALUES ('Betoneira 02',8000.00,150.0,500.00,800.00);
INSERT INTO tb_equipamento(nome,valor_da_compra,valor_aluguel_dia,valor_aluguel_quinzena,valor_aluguel_mes) VALUES ('Betoneira 03',8000.00,150.0,500.00,800.00);

INSERT INTO tb_aluguel(data_inicio,data_termino,valor_do_contrato,cliente_id,equipamento_id,endereco_id) VALUES ('2021-08-09','2021-08-09',800.0,1,1,1);
INSERT INTO tb_aluguel(data_inicio,data_termino,valor_do_contrato,cliente_id,equipamento_id,endereco_id) VALUES ('2022-08-09','2022-08-09',800.0,2,2,1);
INSERT INTO tb_aluguel(data_inicio,data_termino,valor_do_contrato,cliente_id,equipamento_id,endereco_id) VALUES ('2023-08-09','2023-08-09',800.0,3,3,2);
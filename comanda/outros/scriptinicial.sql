insert into comanda (id,nome) values (1,'Comanda');
insert into comanda (id,nome) values (2,'Delivery');
insert into comanda (id,nome) values (3,'Fast Sell');

insert into cliente (id, nome, Bairro, cel, cidade, cpfCnpj , dataCadastro, dataNascimento, logradouro, numerocasa,rgie, tel,tipoPessoa) 
             values (1,'Venda ao consumidor', ' ', ' ', ' ', ' ',null, null, ' ', ' ', ' ', ' ', 'f');
		
		cliente.setCel("");
		cliente.setCidade("");
		cliente.setCpfCnpj("");
		cliente.setDataCadastro(new Date());
		cliente.setDataNascimento(new Date());
		cliente.setLogradouro("");
		cliente.setNumeroCasa("");
		cliente.setRgIe("");
		cliente.setTel("");
		cliente.setTipoPessoa('f');
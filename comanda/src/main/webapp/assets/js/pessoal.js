
$(function() {

	
	var $alert = $('.alert');

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);

	}

	$(".btn-grupo")
			.click(
					function() {

						var $id = this.id;
						var $comanda = '${comanda.id}';

						$
								.getJSON(
										window.contextRoot
												+ "/comanda/json/data/listarProdutoPorGrupo/"
												+ $id,
										function(json) {

											var html = '';

											json
													.forEach(function(val) {
														var keys = Object
																.keys(val);
														html += "<div class = 'itemProduto'>";
														html += "<a id='"
																+ val.id
																+ "' class='btn btn-default btn-itemProduto'>";
														html += "<img src='"
																+ window.contextRoot
																+ "/comanda/resources/images/"
																+ val.imagemUrl
																+ "' class='imgItemProduto'>";
														html += "<div class='textoItemProduto'><p><strong>"
																+ val.nome
																+ "</strong></p></div>"

														html += "</a>"
														html += "</div>";
													});

											$(".divGrupoItens").html(html);

										});

					});
	
	

	// removido = href='"+window.contextRoot+"/comanda/adicionar/item/comanda/"
	// +window.comanda+ "/produto/"+val.id+"/quantidade/1'

	$(".divGrupoItens").ready(function() {
		var $comanda = '${comanda.id}';

		$
				.getJSON(
						window.contextRoot
								+ "/comanda/json/data/listarProdutoPorGrupo/1",
						function(json) {

							var html = '';

							json
									.forEach(function(val) {
										var keys = Object
												.keys(val);
										html += "<div class = 'itemProduto'>";
										html += "<a id='"
												+ val.id
												+ "' class='btn btn-default btn-itemProduto'>";
										html += "<img src='"
												+ window.contextRoot
												+ "/comanda/resources/images/"
												+ val.imagemUrl
												+ "' class='imgItemProduto'>";
										html += "<div class='textoItemProduto'><p><strong>"
												+ val.nome
												+ "</strong></p></div>"

										html += "</a>"
										html += "</div>";
									});

							$(".divGrupoItens").html(html);

						});
	});
	
	
	var $tabelaProdutos = $('#tabela-produtos');
	if($tabelaProdutos.length){
		
		var jsonUrl = window.contextRoot+"/comanda/json/data/listarProdutos";
		
		$tabelaProdutos.DataTable({
			lengthMenu: [[3,5,10,-1],['3 itens','5 itens','10 itens','All',]],
			pageLength: 5,
			ajax:{
				url: jsonUrl,
				dataSrc: ''
			},
			columns:[
				{
					data: 'id'
				},
				{
					data: 'codigoBarra'
				},
				{
					data: 'nome'
				},
				{
					data: 'quantidadeEstoque'
				},
				{
					data: 'preco',
					mRender: function(data,type,row){
						var str = "";
						str += "R$ "+ converterFloatReal(data);
						
						return str;
					}
				},
				{
					data: 'localizacao.nome'
				},
				{
					data: 'id',
					mRender: function(data,type,row){

						var str = '';
						str += '<a href="'+window.contextRoot+'/comanda/produto/alterar/'+data+'" class="btn btn-warning">';
						str += '<span class="glyphicon glyphicon-pencil"></span></a>';
						
						return str;
					}
				},
			]
			
		});
		
	}
	
	var $tabelaClientes = $('#tabela-clientes');
	
	if($tabelaClientes.length){
		
		var jsonUrlClientes = window.contextRoot+"/comanda/json/data/listarClientes";
		
		$tabelaClientes.DataTable({
			lengthMenu: [[3,5,10,-1],['3 itens','5 itens','10 itens', 'All',]],
			pageLength: 5,
			ajax:{
				url: jsonUrlClientes,
				dataSrc: ''
			},
			columns:[
				{
					data: 'id'
				},
				{
					data: 'nome'
				},
				{
					data: 'cpfCnpj'
				},
				{
					data: 'rgIe'
				},
				{
					data: 'tel'
				},
				{
					data: 'cel'
				},
				{
					data: 'id',
					mRender: function(data, type, row){
						var str = '';
						str += '<a href="'+window.contextRoot+'/comanda/cliente/alterar/'+data+'" class="btn btn-warning">';
						str += '<span class="glyphicon glyphicon-pencil"></span></a>';
						
						return str;
					}
						
				},
			]
			
		});
		
	}
	
	
});


function converterFloatReal(valor){
	  var inteiro = null, decimal = null, c = null, j = null;
	  var aux = new Array();
	  valor = ""+valor;
	  c = valor.indexOf(".",0);
	  //encontrou o ponto na string
	  if(c > 0){
	     //separa as partes em inteiro e decimal
	     inteiro = valor.substring(0,c);
	     decimal = valor.substring(c+1,valor.length);
	     if(decimal.length === 1) {
	    	 decimal += "0";
	    	 }
	  }else{
	     inteiro = valor;
	  }
	   
	  //pega a parte inteiro de 3 em 3 partes
	  for (j = inteiro.length, c = 0; j > 0; j-=3, c++){
	     aux[c]=inteiro.substring(j-3,j);
	  }
	   
	  //percorre a string acrescentando os pontos
	  inteiro = "";
	  for(c = aux.length-1; c >= 0; c--){
	     inteiro += aux[c]+'.';
	  }
	  //retirando o ultimo ponto e finalizando a parte inteiro
	   
	  inteiro = inteiro.substring(0,inteiro.length-1);
	   
	  decimal = parseInt(decimal);
	  if(isNaN(decimal)){
	     decimal = "00";
	  }else{
	     decimal = ""+decimal;
	     if(decimal.length === 1){
	        decimal = "0"+decimal;
	     }
	  }
	  valor = inteiro+","+decimal;
	  return valor;
	}



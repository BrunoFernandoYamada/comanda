
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
						str += "<fmt:formatNumber value='"+data+"' type='currency' />";
						
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
	
	
});






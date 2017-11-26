
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

});


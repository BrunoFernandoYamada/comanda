$(function(){
	
	var $alert = $('.alert');
	
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow');
		},3000);
		
	}
	
	
	$(".btn-grupo").click(function(){
		
		var $id = this.id;
		
		$.getJSON(window.contextRoot + "/comanda/json/data/listarProdutoPorGrupo/"+ $id, function(json) {
			
			var html = '';
			
			
			json.forEach(function(val) {
				  var keys = Object.keys(val);
				  html += "<div class = 'itemProduto'>";
				  html += "<button type='button' class='btn-itemProduto'>";
				  html += "<img src='"+window.contextRoot + "/comanda/resources/images/"+ val.imagemUrl+"' class='imgItemProduto'>";
				  html += "<div class='textoItemProduto'><h5><strong>"+ val.nome +"</strong></h5></div>"
				  
				  html += "</button>"
				  html += "</div>";
				});
			
			
			$(".divGrupoItens").html(html);
			
		});
		
		//  $('.divGrupoItens').load(window.contextRoot + "/comanda/json/data/listarProdutoPorGrupo/"+ $id);
		
		
		
		
	});

});
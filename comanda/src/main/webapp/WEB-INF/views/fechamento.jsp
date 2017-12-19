<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<div class="row  div-tabela-fechamento">
		<div class="col-xs-12">

			<h4>Mesa: ${comanda.numeroComanda}</h4>

			<table id="table-fx" class="table table-striped table-bordered">

				<c:set var="num" value="1"></c:set>

				<tbody>
					<tr>
						<th>Nº</th>
						<th>Item</th>
						<th class="text-right">Valor</th>
					</tr>
					<c:forEach items="${listaItens}" var="item">

						<tr>
							<th>${num}</th>
							<th><small>${item.produto.nome}</small></th>
							<th class="text-right"><small> ${item.quantidade} X
									<fmt:formatNumber value="${item.produto.preco}" type="currency" />
									= <fmt:formatNumber value="${item.valorToral}" type="currency" />
							</small></th>
							<c:set var="num" value="${num +1}"></c:set>
						</tr>


					</c:forEach>
				</tbody>
				<tfoot>
					<tr>

						<th colspan="2">Total dos itens</th>
						<th class="text-right"><fmt:formatNumber
								value="${comanda.valorTotal}" type="currency" /></th>
					</tr>
				</tfoot>
			</table>


		</div>
	</div>
	<div class="row footer rowFooterFx">

		<div class="col-xs-12 text-right">
			<div class="form-group col-xs-3 text-left">
				<label for="valorDesconto">DESCONTO</label> <input
					id="valorDesconto" class="form-control preco input-lg" type="text"
					onKeyup="atualizaTroco()" 
					value='<fmt:formatNumber value="${comanda.desconto}" type="currency"/>' />

				<label for="valorServico">SERVIÇO</label> <input id="valorServico"
					class="form-control preco input-lg" type="text"
					onKeyup="atualizaTroco()" value="R$ 0,00" />

			</div>

			<div class="form-group col-xs-3 text-left">
				<label for="valorTotal">VL. TOTAL</label> <input id="valorTotal"
					class="form-control preco input-lg" type="text" disabled="disabled"
					value='<fmt:formatNumber value="${comanda.valorTotal}" type="currency" />' />
				<label for="valorPago">VL. PAGO</label> <input id="valorPago"
					class="form-control preco input-lg" type="text" value='R$ 0,00'
					onKeyup="atualizaTroco()" />
			</div>

			<div class="form-group col-xs-3 text-left">

				<label for="troco">TROCO</label> <input id="troco"
					disabled="disabled" class="form-control preco input-lg" type="text"
					value='<fmt:formatNumber value="${comanda.desconto}" type="currency" />' />
				<input id="totalFixo" class="form-control preco input-lg"
					type="hidden" disabled="disabled"
					value='<fmt:formatNumber value="${comanda.valorTotal}" type="currency" />' />
			</div>

			<div class="form-group col-xs-3">
				<a class="btn btn-danger btn-lg btn-fx">Cancelar</a> <a
					class="btn btn-primary btn-lg btn-fx">Finalizar</a>
			</div>
		</div>

	</div>
</div>
<script type="text/javascript">


	window.total = '${comanda.valorTotal}';
	/* Não Utilizado
	function calculaValorPago(){
		var valorTotal = parseFloat(document.getElementById('valorTotal').value.replace('R$', '').replace('.', '').replace(',', ''));
		
		var valorPago = parseFloat(document.getElementById('valorPago').value.replace('R$', '').replace('.', '').replace(',', ''));
		var troco = document.getElementById('troco');
		
		if(valorPago > valorTotal){
	
			troco.value = "R$ " + formatReal(valorPago - valorTotal);
			// outra opção de código
			//$('#troco').val(valorpago - valorTotal);
		}else{
			troco.value = 'R$ 0,00';
		}
	}
	 */
	 
	 
	function atualizaTroco(){
		
		var totalFixo = parseFloat(document.getElementById('totalFixo').value.replace('R$', '').replace('.', '').replace(',', ''));		
		var valorTotal = parseFloat(document.getElementById('valorTotal').value.replace('R$', '').replace('.', '').replace(',', ''));
		var valorPago = parseFloat(document.getElementById('valorPago').value.replace('R$', '').replace('.', '').replace(',', ''));
		var valorDesconto = parseFloat(document.getElementById('valorDesconto').value.replace('R$', '').replace('.', '').replace(',', ''));
		var valorServico = parseFloat(document.getElementById('valorServico').value.replace('R$', '').replace('.', '').replace(',', ''));
		
		var troco = document.getElementById('troco');
		var total = document.getElementById('valorTotal');
		//corrigir valor nulo...
		
		var desconto = document.getElementById('valorDesconto');
		var servico = document.getElementById('valorServico');
		var pago = document.getElementById('valorPago');
		 
		if(isNaN(valorDesconto)){
			valorDesconto = 0;
		}
		if(isNaN(valorServico)){
			valorServico = 0;
		}
		
		// ...
		
		if(valorDesconto < totalFixo + valorServico){
			
			var subTotal = totalFixo + valorServico - valorDesconto;
		
			if(valorPago > subTotal){
				
				troco.value = "R$ " + formatReal(valorPago - subTotal);
				// outra opção de código
				//$('#troco').val(valorpago - valorTotal);
			}else{
				troco.value = 'R$ 0,00';
			}
			
			total.value = "R$ " + formatReal(subTotal);
			
		}else{
			
			alert('O desconto não pode ser maior que o valor Total!!!');
			desconto.value = 'R$ 0,00';
		}
		
		subTotal = 0;
		
		//Corrigir vaor nulo...
		if(valorDesconto == 0){
			desconto.value = 'R$ 0,00';
		}
		if(valorServico == 0){
			servico.value = 'R$ 0,00';
		}
		if(valorPago == 0){
			pago.value = 'R$ 0,00';
		}
		//...
	}
	
	function formatReal( inteiro ){
	        var tmp = inteiro+'';
	        var neg = false;
	        if(tmp.indexOf("-") == 0)
	        {
	            neg = true;
	            tmp = tmp.replace("-","");
	        }

	        if(tmp.length == 1) tmp = "0"+tmp

	        tmp = tmp.replace(/([0-9]{2})$/g, ",$1");
	        if( tmp.length > 6)
	            tmp = tmp.replace(/([0-9]{3}),([0-9]{2}$)/g, ".$1,$2");

	        if( tmp.length > 9)
	            tmp = tmp.replace(/([0-9]{3}).([0-9]{3}),([0-9]{2}$)/g,".$1.$2,$3");

	        if( tmp.length > 12)
	            tmp = tmp.replace(/([0-9]{3}).([0-9]{3}).([0-9]{3}),([0-9]{2}$)/g,".$1.$2.$3,$4");

	        if(tmp.indexOf(".") == 0) tmp = tmp.replace(".","");
	        if(tmp.indexOf(",") == 0) tmp = tmp.replace(",","0,");

	    return (neg ? '-'+tmp : tmp);
	}

</script>
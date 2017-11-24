<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id='content'>
	<div class="row divComandaDados">
		<div class="col-xs-12">
			<div class="col-xs-2 form-group">
				<label for="mesa">Mesa</label> <input id="mesa" name="mesa"
					value="${comanda.numeroComanda}" class="form-control" disabled="disabled">
			</div>
			<div class="col-xs-4 form-group">
				<label for="desconto">Desconto</label> 
				<input id="desconto"
					name="desconto" value="${comanda.desconto}" class="preco form-control" disabled="disabled">
			</div>
			<div class="col-xs-4 form-group">
				<label for="valorTotal">Valor Total</label> <input id="valorTotal"
					name="valorTotal" value="${comanda.valorTotal}"
					class="preco form-control" disabled="disabled">
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-xs-2 divBtnGrupo">

			<c:forEach items="${grupos}" var="grupo">
				<div class="col-xs-12 divBtnGrupoInterna"">
					<a class="btn btn-success btn-grupo" id="${grupo.id}"><h4>${grupo.nome}</h4></a>
				</div>
			</c:forEach>

		</div>
		<div class="col-xs-7 divGrupoItens">

			<!-- Aqui são carregados os Produtos de cada grupo clicado -->

		</div>
		<div class="col-xs-3 divListaItens">

			<div class="col-xs-12">
				<label for="item-qtd">Quantidade</label> <input id="item-qtd"
					type="number" min="1" class="form-control" value="1">
			</div>
			<div class="col-xs-12">

				<table class="table table-striped table-bordered">
					<thead></thead>
					<tbody>
						<c:forEach items="${listaItens}" var="item">
							
							<tr>
								<th><p>item -------------- ${item.produto.nome}<br/>
										Qtd  --------------- ${item.quantidade}   X   ${item.produto.preco}   =   ${item.valorToral}</p></th> 	
							</tr>
							
											
						</c:forEach>
					</tbody>
					<tfoot>
						<tr>
							<th>Total -------------- R$ ${comanda.valorTotal}</th>
						</tr>
					</tfoot>
				</table>
					

			</div>

		</div>


	</div>
</div>
<script>
	window.comanda = '${comanda.id}';
</script>

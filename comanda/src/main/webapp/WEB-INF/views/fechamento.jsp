<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="content">
	<div class="row">
		<div class="col-xs-12">

			<table class="table table-striped table-bordered">
			
				<c:set var="num" value="1"></c:set>
				<thead> <h4>Mesa: ${comanda.numeroComanda}</h4></thead>
				<tbody>
					<tr>
						<th> Nº</th>
						<th> Item</th>
						<th class="text-right"> Valor</th>
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
						
						<th colspan="2">Total</th>
						<th class="text-right"><fmt:formatNumber
								value="${comanda.valorTotal}" type="currency" /></th>
					</tr>
				</tfoot>
			</table>


		</div>
	</div>
</div>
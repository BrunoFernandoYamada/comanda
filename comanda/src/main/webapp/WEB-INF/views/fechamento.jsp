<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-xs-12">

					<table class="table table-striped table-bordered">
						<thead></thead>
						<tbody>
							<c:forEach items="${listaItens}" var="item">

								<tr>
									<th><small>${item.produto.nome}</small></th>
									<th class="text-right"><small> ${item.quantidade}
											X <fmt:formatNumber value="${item.produto.preco}"
												type="currency" /> = <fmt:formatNumber
												value="${item.valorToral}" type="currency" />
									</small></th>
								</tr>


							</c:forEach>
						</tbody>
						<tfoot>
							<tr>
								<th>Total</th>
								<th class="text-right"><fmt:formatNumber
										value="${comanda.valorTotal}" type="currency" /></th>
							</tr>
						</tfoot>
					</table>


				</div>
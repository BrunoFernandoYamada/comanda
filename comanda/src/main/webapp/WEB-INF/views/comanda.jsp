
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='content'>
	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-file-text-o" aria-hidden="true"></i> Gerenciamento de Comandas
			<div class='panel-tools'>
				<div class='btn-group'>
					<a class='btn' href='#'> <i class='icon-refresh'></i> Refresh
						statics
					</a> <a class='btn' data-toggle='toolbar-tooltip' href='#'
						title='Toggle'> <i class='icon-chevron-down'></i>
					</a>
				</div>
			</div>
		</div>

		<!--  Painel Central -->
		<div class='panel-body'>

			<div class="col-lg-12 tabela-mesa">

				<c:forEach items="${comandas}" var="comanda">
					<div class="div-mesa">
						<button type="button" class="btn-mesa">
							<div class="row">
								<h5 class=" numero-mesa"><strong>${comanda.numeroComanda}</strong></h5>
							</div>
							<div class="row">
								<c:if test="${comanda.status == true}">
									<img class="img-responsive" id="mesa_icone" alt="mesa"
										src="${images}/mesa-fechada.png">
								</c:if>
								<c:if test="${comanda.status == false}">
									<img class="img-responsive" id="mesa_icone" alt="mesa"
										src="${images}/mesa.png">
								</c:if>

							</div>
						</button>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>
</div>

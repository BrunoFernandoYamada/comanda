<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='content'>
	<div class="container">
		<div class="row">
			<c:if test="${not empty mensagem}">
				<div class="col-xs-12">
					<div class="alert alert-success alert-dismissible">
						<button type="button" class="close" data-dismiss="alert">&times;</button>
						${mensagem}
					</div>

				</div>

			</c:if>

		</div>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3>Configurações</h3>
				</div>
				<div class="panel-body">
					<div>
						<sf:form action="${contextRoot}/comanda/config" method="POST"
							modelAttribute="config" class="form-horizontal">
							<div class="row">
								<div class="form-group">
									<sf:hidden path="id" />
								</div>
							</div>

							<div class="col-xs-12">
								<div class="form-group col-md-3 row">
									<label for="qunatComanda">Quantidade de Mesas</label>
									<sf:input path="quantComanda" id="quantComanda"
										cssClass="form-control" />
								</div>
							</div>
							<div class="col-xs-12">
								<div class="form-group col-md-3 row">
									<label for="qunatDelivey">Qtd. de Deliverys</label>
									<sf:input path="quantDelivey" id="quantDelivey"
										cssClass="form-control" />
								</div>
							</div>
							<div class="form-group">
								<sf:hidden path="quantFastSell" />
							</div>

							<input type="submit" class="btn btn-success" value="Salvar" />
							<a href="${contextRoot}/comanda" class="btn btn-danger">Cancelar</a>

						</sf:form>
					</div>
				</div>



			</div>
		</div>
	</div>
</div>
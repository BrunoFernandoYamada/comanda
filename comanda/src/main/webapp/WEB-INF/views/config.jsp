<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>Configurações</h3>
			</div>
			<div class="panel-body">
				<div class="">
					<sf:form action="${contextRoot}/comanda/config" method="POST">
						<div class="row">
							<div class="form-group">
								<input type="hidden" id="id" class="form-control"
									value="${config.id}" />
							</div>
						</div>

						<div class="row">
							<div class="form-group col-md-3">
								<label for="qunatComanda">Quantidade de Mesas</label> <input
									type="number" path="quantComanda" name="quantComanda"
									class="form-control" value="${config.quantComanda}" />
							</div>
						</div>

	<div class="row">
						<div class="form-group col-md-3">
							<label for="qunatDelivey">Qtd. de Deliverys</label> <input
								type="number" path="quantDelivey" name="quantDelivey"
								class="form-control" value="${config.quantDelivey}" />

						</div>
</div>
						<div class="form-group">
							<input type="hidden" path="quantComanda" name="quantComanda"
								class="form-control" value="${config.quantFastSell}" />
						</div>
						
						<input type="submit" class="btn btn-success" value="Salvar"/>
						<a href="${contextRoot}/comanda" class="btn btn-danger" >Cancelar</a>
						
					</sf:form>
				</div>
			</div>



		</div>
	</div>
</div>
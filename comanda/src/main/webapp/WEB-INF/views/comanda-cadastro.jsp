<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id='content'>
	<div class="container">
		<div class="row">
			<h1>Comanda Cadastro</h1>

			<div class="row">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="col-xs-12">
							<h3>Abertura de Mesa</h3>
						</div>
					</div>
					<div class="panel-body">
						<div>
							<sf:form action="${contextRoot}/comanda/salvarcomanda"
								method="POST" class="form-horizontal" modelAttribute="comanda">


								<div class="col-xs-12 form-group">
									<div class="col-xs-12">
										<label for="numeroComanda">Mesa</label>
									</div>
									<div class=" col-xs-3">
										<sf:input path="numeroComanda" id="numeroComanda"
											cssClass="form-control"/>
									</div>
								</div>
								
								<div class="col-xs-12">
									<div class="form-group col-xs-3 row">
										<label for="cliente">Cliente</label>
										<sf:select path="cliente" items="${clientes}" itemLabel="nome" cssClass="form-control" itemValue="id"></sf:select>
									</div>
								</div>
								<!-- 
								 
								<div class="col-xs-12">
									<div class="form-group col-md-3 row">
										<label for="atendente">Atendente</label> <input
											name="atendente" id="atendente" class="form-control" />
									</div>
								</div>
								 -->
								<sf:hidden path="id" />
								<sf:hidden path="horaAbertura" />
								<sf:hidden path="horaFechamento" />
								<sf:hidden path="status"/>
								<sf:hidden path="tipo" />
								<sf:hidden path="desconto"/>
								<sf:hidden path="valorTotal"/>
								 
								<div class="col-xs-12">
									<input type="submit" class="btn btn-success" value="Próximo" />
									<a href="${contextRoot}/comanda" class="btn btn-danger">Sair</a>
								</div>
							</sf:form>
						</div>
					</div>



				</div>
			</div>

		</div>
	</div>
</div>
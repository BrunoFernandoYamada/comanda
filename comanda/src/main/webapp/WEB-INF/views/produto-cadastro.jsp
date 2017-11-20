
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id='content'>
	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-product-hunt" aria-hidden="true"></i> <strong>
				Gerenciamento de Produtos</strong>
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

		<sf:form action="${contextRoot}/produto/cadastrar" method="POST"
			modelAttribute="produto" enctype="multpart/form-data">
			
			<!--  Painel Central -->
			<div class='panel-body'>

				<div class="form-group col-xs-8">
					<label for="nome">Nome do Produto</label>
					<sf:input path="nome" id="nome" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="codigoBarra">Código de Barra</label>
					<sf:input path="codigoBarra" id="codigoBarra"
						cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="preco">Preço</label>
					<sf:input path="preco" id="preco" cssClass="form-control moeda" />
				</div>
				
				<div class="form-group col-xs-4">
					<label for="grupo">Grupo</label>
					<sf:select items="${grupos}" itemLabel="nome" itemValue="id"
						path="grupo" id="grupo" cssClass="form-control" />
				</div>
				
				<div class="form-group col-xs-4">
					<label for="localizacao">Localização</label>
					<sf:select items="${localizacoes}" itemLabel="nome" itemValue="id"
						path="localizacao" id="localizacao" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="quantidadeEstoque">Qtd Estoque</label>
					<sf:input path="quantidadeEstoque" id="quantidadeEstoque"
						cssClass="form-control" />
				</div>

				<!-- file element for image upload -->
				<div class="form-group col-xs-4">
					<label for="file">Imagem</label>
					<sf:input type="file" path="file" id="file"
						cssClass="form-control-file" />
				</div>

				<sf:hidden path="id" />
				<sf:hidden path="imagemUrl" />

			</div>

			<div class="panel-footer text-right">
				<input type="submit" id="submit" value="Salvar"
					class="btn btn-success"> <a href="${contextRoot}/comanda"
					class="btn btn-danger">Cancelar</a>
			</div>


		</sf:form>
	</div>
</div>

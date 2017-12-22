<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div id='content'>
	<c:if test="${not empty mensagem}">
		<div class="col-xs-12">
			<div class="alert alert-success alert-dismissible">

				<button type="button" class="close" data-dismiss="alert">&times;</button>

				${mensagem}
			</div>
		</div>
	</c:if>
	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-product-hunt" aria-hidden="true"></i> <strong>
				Cadastro de Produto</strong>
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

		<sf:form action="${contextRoot}/comanda/produto/cadastrar"
			method="POST" modelAttribute="produto" enctype="multipart/form-data">

			<!--  Painel Central -->
			<div class='panel-body'>

				<div class="form-group col-xs-2">
					<label for="codigoBarra">Código de Barra</label>
					<sf:input path="codigoBarra" id="codigoBarra"
						cssClass="form-control" />
				</div>

				<div class="form-group col-xs-6">
					<label for="nome">Nome do Produto</label>
					<sf:input path="nome" id="nome" cssClass="form-control" />
				</div>

				<div class="form-group col-xs-3">
					<label for="preco">Preço</label>
					<sf:input path="preco" id="preco" cssClass="form-control preco"  />
				</div>

				<div class="form-group col-xs-3">
					<label for="grupo">Grupo</label>
					<sf:select items="${grupos}" itemLabel="nome" itemValue="id"
						path="grupo" id="grupo" cssClass="form-control" />
				</div>

				<div class="form-group col-xs-3">
					<label for="localizacao">Localização</label>
					<sf:select items="${localizacoes}" itemLabel="nome" itemValue="id"
						path="localizacao" id="localizacao" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-2">
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

	<!-- Tabela de Produtos -->

	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-product-hunt" aria-hidden="true"></i> <strong>Produtos
				Cadastrados</strong>
		</div>
		<div class='panel-body'>
			<div style="overflow: auto">
				<table id="tabela-produtos"
					class="table table-striped table-bordered col-sm-12">
					<thead>
						<tr>
							<th>Id</th>
							<th>Código de Barra</th>
							<th>Nome</th>
							<th>Quantidade</th>
							<th>Preço</th>
							<th>Localização</th>
							<th>Editar</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<th>Id</th>
							<th>Código de Barra</th>
							<th>Nome</th>
							<th>Quantidade</th>
							<th>Preço</th>
							<th>Localização</th>
							<th>Editar</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>

	</div>

</div>





<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id='content'>
	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-file-text-o" aria-hidden="true"></i> Gerenciamento de
			Cliente
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

			<h1>Cliente</h1>

			<sf:form action="${contextRoot}/cliente/cadastrar" method="POST"
				modelAttribute="cliente" enctype="multpart/form-data">

				<div class="form-group col-xs-12">
					<label for="nome">Nome do Cliente</label>
					<sf:input path="nome" id="nome" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="cpfCnpj">CPF/CNPJ</label>
					<sf:input path="cpfCnpj" id="cpfCnpj"
						cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="rgIe">RG/IE</label>
					<sf:input path="rgIe" id="rgIe"
						cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="tipoPessoa">Localização</label>
					<sf:select path="tipoPessoa" id="tipoPessoa" cssClass="form-control">
						<sf:option value="F">Pessoa Física</sf:option>
						<sf:option value="J">Pessoa Jurídica</sf:option>
					</sf:select>
				</div>
				<div class="form-group col-xs-4">
					<label for="logradouro">Logradouro</label>
					<sf:input path="logradouro" id="logradouro" cssClass="form-control" />
				</div>
				
				<div class="form-group col-xs-4">
					<label for="numeroCasa">Número</label>
					<sf:input path="numeroCasa" id="numeroCasa" cssClass="form-control" />
				</div>
				
				<div class="form-group col-xs-4">
					<label for="bairro">Bairro</label>
					<sf:input path="bairro" id="bairro"
						cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="cidade">Cidade</label>
					<sf:input path="cidade" id="cidade"
						cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="tel">Tel</label>
					<sf:input path="tel" id="tel"
						cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="cel">Cel</label>
					<sf:input path="cel" id="cel"
						cssClass="form-control" />
				</div>

				<sf:hidden path="dataNascimento" />
				<sf:hidden path="dataCadastro" />

				<div class="form-group col-xs-12">
					<input type="submit" id="submit" value="Salvar"
						class="btn btn-success"> <a href="${contextRoot}/comanda"
						class="btn btn-danger">Cancelar</a>
				</div>
			</sf:form>

		</div>
	</div>
</div>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
			<i class="fa fa-user" aria-hidden="true"></i> <strong> Gerenciamento de
			Cliente</strong>
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

		<sf:form action="${contextRoot}/comanda/cliente/cadastrar" method="POST"
			modelAttribute="cliente" enctype="multpart/form-data">

			<!--  Painel Central -->
			<div class='panel-body'>



				<div class="form-group col-xs-8">
					<label for="nome">Nome do Cliente</label>
					<sf:input path="nome" id="nome" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="cpfCnpj">CPF/CNPJ</label>
					<sf:input path="cpfCnpj" id="cpfCnpj" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="rgIe">RG/IE</label>
					<sf:input path="rgIe" id="rgIe" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="tipoPessoa">Tipo Pessoa</label>
					<sf:select path="tipoPessoa" id="tipoPessoa"
						cssClass="form-control">
						<sf:option value="F">Pessoa Física</sf:option>
						<sf:option value="J">Pessoa Jurídica</sf:option>
					</sf:select>
				</div>

				<div class="form-group col-xs-4">
					<label for="dataNascimento">Data de Nascimento</label>
					<sf:input path="dataNascimento" id="dataNascimento"
						cssClass="form-control" onkeypress="mascaraData(this)" />
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
					<sf:input path="bairro" id="bairro" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="cidade">Cidade</label>
					<sf:input path="cidade" id="cidade" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="tel">Tel</label>
					<sf:input path="tel" id="tel" cssClass="form-control" />
				</div>
				<div class="form-group col-xs-4">
					<label for="cel">Cel</label>
					<sf:input path="cel" id="cel" cssClass="form-control" />
				</div>
				<sf:hidden path="dataCadastro" />



			</div>
			<div class="panel-footer text-right">
				
					<input type="submit" id="submit" value="Salvar" class="btn btn-success"> 
					<a href="${contextRoot}/comanda"class="btn btn-danger">Cancelar</a>

			</div>

		</sf:form>
	</div>
	
	<!-- Tabela de Clientes -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<i class="fa fa-user" aria-hidden="true"></i> <strong>Clientes Cadastrados</strong>
		</div>
		<div class="panel-body">

			<table class="table table-striped table-bordered col-sm-12" id="tabela-clientes">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>CPF/CNPJ</th>
						<th>RG/IE</th>
						<th>Telefone</th>
						<th>Celular</th>
						<th>Editar</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Id</th>
						<th>Nome</th>
						<th>CPF/CNPJ</th>
						<th>RG/IE</th>
						<th>Telefone</th>
						<th>Celular</th>
						<th>Editar</th>
					</tr>
				</tbody>
				
			
			</table>
	
		</div>
		
	</div>
	
	
	
</div>

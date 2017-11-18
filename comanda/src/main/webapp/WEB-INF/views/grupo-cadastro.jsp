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
			Grupo</strong>
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

		<sf:form action="${contextRoot}/comanda/grupo/cadastrar" method="POST"
			modelAttribute="grupo">

			<!--  Painel Central -->
			<div class='panel-body'>

				<sf:hidden path="id"/>
				
				<div class="form-group col-xs-8">
					<label for="nome">Nome do Grupo</label>
					<sf:input path="nome" id="nome" cssClass="form-control" />
				</div>

			</div>
			<div class="panel-footer text-right">
				
					<input type="submit" id="submit" value="Salvar" class="btn btn-success"> 
					<a href="${contextRoot}/comanda"class="btn btn-danger">Cancelar</a>

			</div>

		</sf:form>
	</div>
</div>

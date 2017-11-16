
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div id='content'>
	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-file-text-o" aria-hidden="true"></i> Gerenciamento de Produtos
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
		
		<h1>Produto</h1>
		
		<sf:form action="${contextRoot}/produto/cadastrar" method="POST" modelAttribute="produto">
			
			
		</sf:form>

		</div>
	</div>
</div>

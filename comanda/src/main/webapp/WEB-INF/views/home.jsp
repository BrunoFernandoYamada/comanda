
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='content'>
	<div class='panel panel-default'>
		<div class='panel-heading'>
			<i class="fa fa-file-text-o" aria-hidden="true"></i> Comandas
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

			<div class="col-lg-12">

				<c:forEach items="${mesas}" var="mesa">
					<div class="div_mesa col-xs-4 col-md-3 col-md-2 col-lg-1">
						<div class="row">
							<h4>${mesa.id}</h4>
						</div>
						<div class="row">
							<img id="mesa_icone" alt="mesa" src="${images}/mesa.jpg">
						</div>
					</div>
				</c:forEach>

			</div>

		</div>
	</div>
</div>

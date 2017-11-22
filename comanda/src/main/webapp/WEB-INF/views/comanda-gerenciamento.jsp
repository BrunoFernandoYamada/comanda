<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id='content'>
	<div class="row divComandaDados">
		<div class="col-xs-12">
			<div class="col-xs-2 form-group">
				<label for="mesa">Mesa</label> <input id="mesa" name="mesa"
					value="${comanda.numeroComanda}" class="form-control">
			</div>
			<div class="col-xs-4 form-group">
				<label for="desconto">Desconto</label> <input id="desconto"
					name="desconto" value="${comanda.desconto}" class="form-control">
			</div>
			<div class="col-xs-4 form-group">
				<label for="valorTotal">Valor Total</label> <input id="valorTotal"
					name="valorTotal" value="${comanda.valorTotal}"
					class="form-control">
			</div>
		</div>
	</div>
	<div class="row">

		<div class="col-xs-2 divBtnGrupo">

			<c:forEach items="${grupos}" var="grupo">
				<div class="col-xs-12 divBtnGrupoInterna"">
					<a class="btn btn-success btn-grupo" id="${grupo.id}"><h4>${grupo.nome}</h4></a>
				</div>
			</c:forEach>

		</div>
		<div class="col-xs-10 divGrupoItens">
		
		
		</div>

	</div>
</div>

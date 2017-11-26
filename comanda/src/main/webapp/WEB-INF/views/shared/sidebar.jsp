      <section id='sidebar'>
        <i class='icon-align-justify icon-large' id='toggle'></i>
        <ul id='dock'>
          <li class='active launcher'>
            <i class="fa fa-file-text-o" aria-hidden="true"></i>
            <a href="${contextRoot}/comanda">Comandas</a>
          </li>
          <li class='launcher'>
            <i class="fa fa-motorcycle" aria-hidden="true"></i>
            <a href="#">Delivery</a>
          </li>
          <li class='launcher dropdown hover'>
   			<i class="fa fa-credit-card" aria-hidden="true"></i>
            <!--  <i class='icon-flag'></i> -->
            <a href='#'>Fast Shell</a>
            
          </li>
          
          <li class='launcher dropdown hover'>
   			<i class="fa fa-product-hunt" aria-hidden="true"></i>
            <!--  <i class='icon-flag'></i> -->
            <a href='${contextRoot}/comanda/produto/cadastrar'>Gerir Produtos</a>
            
          </li>
           <li class='launcher dropdown hover'>
   			<i class="fa fa-clone" aria-hidden="true"></i>
            <!--  <i class='icon-flag'></i> -->
            <a href='#'>Outros Cadastros</a>
             <ul class='dropdown-menu'>
              <li class='dropdown-header'>Cadastrar</li>
              <li>
                <a href='${contextRoot}/comanda/cliente/cadastrar'>Clientes</a>
              </li>
              <li>
                <a href='${contextRoot}/comanda/grupo/cadastrar'>Grupos</a>
              </li>
              <li>
                <a href='${contextRoot}/comanda/localizacao/cadastrar'>Localizações</a>
              </li>
            </ul>
          </li>
          
          <br/>
          
          <li class='launcher dropdown hover'>
            <i class="fa fa-list-ol" aria-hidden="true"></i>
            <a href='#' class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Relatórios</a>
            <ul class='dropdown-menu'>
              <li class='dropdown-header'>Relatórios</li>
              <li>
                <a href='#'>Vendas por data</a>
              </li>
              <li>
                <a href='#'>Vendas por Produtos</a>
              </li>
              <li>
                <a href='#'>Vendas por tipo</a>
              </li>
            </ul>
          </li>
          
          <li class='launcher'>
            <i class="fa fa-cloud" aria-hidden="true"></i>
            <a href='#'>Backup</a>
          </li>
           <li class='launcher'>
            <i class="fa fa-cog" aria-hidden="true"></i>
            <a href='${contextRoot}/comanda/config'>Config</a>
          </li>
          
        </ul>

      </section>

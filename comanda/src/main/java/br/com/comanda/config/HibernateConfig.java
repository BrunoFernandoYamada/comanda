/**
 * @author Bruno Fernando Yamada
 * 23 de out de 2017
 *	
 */
package br.com.comanda.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.firebirdsql.pool.FBWrappingDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"br.com.comanda.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	
	//Configuração de conexão com Firebird
	private static final String DATABASE_URL = "//localhost:3050/C:\\firebird\\database\\COMANDA.FDB";
	private static final String DATABASE_USERNAME = "SYSDBA";
	private static final String DATABASE_PASSWORD = "masterkey";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.FirebirdDialect";
	
	
	@Bean
	public DataSource getDataSource() {
		
		
		
		/* Configuração Para outros SGBD's
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setAlias(DATABASE_ALIAS);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		*/
	
		//DataSource Modelo Firebird
		FBWrappingDataSource dataSource = new FBWrappingDataSource();
		dataSource.setDatabase(DATABASE_URL);
		dataSource.setUserName(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		/*dataSource.setMaxPoolSize((int) 5);
		dataSource.setMinPoolSize((int) 1);*/
		dataSource.setPooling(true);
		dataSource.setType("TYPE4");
		dataSource.setEncoding("UTF8");
		return dataSource;
		
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("br.com.comanda.dto");
		
		return builder.buildSessionFactory();
		
		
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "create");
		
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
	
	

}

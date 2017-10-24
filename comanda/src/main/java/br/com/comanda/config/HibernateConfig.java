package br.com.comanda.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
@ComponentScan(basePackages={"br.com.comanda.controller"})
public class HibernateConfig {
	
	private static final String DATABASE_URL = "jdbc:firebirdsql://localhost:3050/C:/firebird/database/COMANDA.FDB";
	private static final String DATABASE_DRIVER = "org.firebirdsql.jdbc.FBDriver";
	private static final String DATABASE_USERNAME = "SYSDBA";
	private static final String DATABASE_PASSWORD = "masterkey";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.FirebirdDialect";
	
	
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setUrl(DATABASE_URL);
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.addPackages("br.com.comanda.dto");
		
		return builder.buildSessionFactory();
		
		
	}

	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		
		return properties;
	}
	
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
		
	}
	
	
	

}

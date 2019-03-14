package com.demo.employee;

import java.io.IOException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.*")
@EnableTransactionManagement
//@EnableAspectJAutoProxy
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver myViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

	//for xml view resolver
	public XmlViewResolver getMyXmlViewResolver() {
		XmlViewResolver resolver = new XmlViewResolver();
		resolver.setLocation(new FileSystemResource("/WEB-INF/myview.xml"));
		return resolver;
	}

	// for i18n
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver(){
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		/*
		 * resolver.setDefaultLocale(new Locale("en"));
		 * resolver.setCookieName("myLocaleCookie"); resolver.setCookieMaxAge(4800);
		 */
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	    registry.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("mylocale");
		registry.addInterceptor(interceptor);
		registry.addInterceptor(new MyHandler());
	}
	
	
	//end i18n

	/*
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/api/**") .allowedOrigins("http://domain2.com")
	 * .allowedMethods("PUT", "DELETE") .allowedHeaders("header1", "header2",
	 * "header3") .exposedHeaders("header1", "header2")
	 * .allowCredentials(false).maxAge(3600); }
	 */

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/TestDatabase");
		dataSource.setUsername("SYSTEM");
		dataSource.setPassword("meDA#1989");
		return dataSource;
	}
	@Autowired
	@Bean
	public JdbcTemplate getJdbcTemplate( DriverManagerDataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		return jdbcTemplate;

	}
	/*
	 * @Autowired
	 * 
	 * @Bean public DataSourceTransactionManager
	 * getDataSourceTransactionManager(DriverManagerDataSource dataSource) {
	 * DataSourceTransactionManager dataSourceTransactionManager = new
	 * DataSourceTransactionManager(dataSource); return
	 * dataSourceTransactionManager; }
	 */

	@Bean
	public SimpleMappingExceptionResolver getMappingException() {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		Properties mappings =  new Properties();
		mappings.put("ArithmeticException", "generic_error");
		exceptionResolver.setExceptionMappings(mappings );
		return exceptionResolver;
	}
	
	@Autowired
	@Bean
	public SessionFactory  getSessionFactory(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//localhost:1521/TestDatabase");
		dataSource.setUsername("SYSTEM");
		dataSource.setPassword("meDA#1989");
		
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setPackagesToScan(
			        new String[] { "com" });
		try {
			localSessionFactoryBean.afterPropertiesSet();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("localSessionFactoryBean"+localSessionFactoryBean);
		System.out.println("localSessionFactoryBean"+localSessionFactoryBean.getObject());
		return localSessionFactoryBean.getObject();
	}

	@Autowired
	@Bean
	public HibernateTransactionManager  getHibernateTransactionManager(SessionFactory sessionFactory){
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDataSource());
		localSessionFactoryBean.setAnnotatedClasses(Employee.class);
		System.out.println(sessionFactory+"sessionFactory");
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
	}
	
	 Properties hibernateProperties() {
		 Properties properties = new Properties();
			properties.put(Environment.DIALECT, "org.hibernate.dialect.Oracle10gDialect");
			properties.put(Environment.HBM2DDL_AUTO, "create");
			properties.put(Environment.SHOW_SQL, "true");
		/*
		 * properties.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		 * properties.put(Environment.USE_QUERY_CACHE, "true");
		 * properties.put(Environment.CACHE_REGION_FACTORY,
		 * "org.hibernate.cache.ehcache.EhCacheRegionFactory");
		 */
			return properties;
	   }
	
}

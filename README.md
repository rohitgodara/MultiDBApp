# MultiDBApp

Here we connect to multiple databases using below steps:

1. Define each database properties in application.properties file.

2. Now, create configuration classes for each database.

3. Now, annotate each class with @Configuration, @EnableTransactionManagement, and @EnableJpaRepositories.

4. In @EnableJpaRepositories set these properties (entityManagerFactoryRef = "entityManagerFactory", basePackages = {
		"com.multidb.user.repository" }, transactionManagerRef = "transactionManager").
    
5. Create datasource bean for each datasource configuration. 
   @Primary
	 @Bean(name = "dataSource")
	 @ConfigurationProperties(prefix = "spring.user.datasource")
	 public DataSource dataSource() {
	 	 return DataSourceBuilder.create().build();
	 }

6. Create entityManagerFactory bean.
   @Bean(name = "entityManagerFactory")
	 public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.multidb.user.entity").persistenceUnit("User").build();
	 }

7. Create TransactionManager bean. 
   @Bean(name = "transactionManager")
	 public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {

	  return new JpaTransactionManager(entityManagerFactory);
   }

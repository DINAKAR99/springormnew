package cgg.core.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "cgg.core.dao;")
public class hibernateConfig {

    @Bean
    public DriverManagerDataSource getSource() {

        DriverManagerDataSource source = new DriverManagerDataSource("jdbc:postgresql://localhost:5433/springjdbc",
                "postgres", "dinakar1.");
        source.setDriverClassName("org.postgresql.Driver");

        return source;
    }

    @Bean
    public LocalSessionFactoryBean getFactory() {

        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getSource());

        factory.setHibernateProperties(gettHibeProp());
        factory.setPackagesToScan("cgg.core.entites");

        return factory;
        // factory.setAnnotatedClasses(null);

    }

    @Bean
    public Properties gettHibeProp() {

        Properties p1 = new Properties();

        p1.setProperty("hibernate.hbm2ddl.auto", "update");
        p1.setProperty("hibernate.show_sql", "true");
        p1.setProperty("hibernate.format_sql", "true");

        return p1;
    }

    @Bean
    public HibernateTransactionManager getTransmanage() {
        return new HibernateTransactionManager(getFactory().getObject());

    }
}

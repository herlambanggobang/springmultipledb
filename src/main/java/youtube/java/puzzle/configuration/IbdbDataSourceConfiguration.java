package youtube.java.puzzle.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "youtube.java.puzzle.ibdb.repository",
        entityManagerFactoryRef = "ibdbEntityManagerFactory",
        transactionManagerRef = "ibdbTransactionManager")
public class IbdbDataSourceConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties("ibdb.datasource")
    public DataSourceProperties ibdbDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("ibdb.datasource.configuration")
    public DataSource ibdbDataSource() {
        return ibdbDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean(name = "ibdbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean ibdbEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(ibdbDataSource())
                .packages("youtube.java.puzzle.ibdb.entity")
                .build();
    }

    @Primary
    @Bean(name = "ibdbTransactionManager")
    public PlatformTransactionManager ibdbTransactionManager(
            final @Qualifier("ibdbEntityManagerFactory") LocalContainerEntityManagerFactoryBean ibdbEntityManagerFactory) {
        return new JpaTransactionManager(ibdbEntityManagerFactory.getObject());
    }
}

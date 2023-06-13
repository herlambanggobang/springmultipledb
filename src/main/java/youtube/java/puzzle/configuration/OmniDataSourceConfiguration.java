package youtube.java.puzzle.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "youtube.java.puzzle.omni.repository",
        entityManagerFactoryRef = "omniEntityManagerFactory",
        transactionManagerRef = "omniTransactionManager")
public class OmniDataSourceConfiguration {
    @Bean
    @ConfigurationProperties("omni.datasource")
    public DataSourceProperties omniDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("omni.datasource.configuration")
    public DataSource omniDataSource() {
        return omniDataSourceProperties().initializeDataSourceBuilder()
                .type( HikariDataSource.class).build();
    }

    @Bean(name = "omniEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean omniEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(omniDataSource())
                .packages("youtube.java.puzzle.omni.entity")
                .build();
    }

    @Bean(name = "omniTransactionManager")
    public PlatformTransactionManager omniTransactionManager(
            final @Qualifier("omniEntityManagerFactory") LocalContainerEntityManagerFactoryBean omniEntityManagerFactory) {
        return new JpaTransactionManager(omniEntityManagerFactory.getObject());
    }
}

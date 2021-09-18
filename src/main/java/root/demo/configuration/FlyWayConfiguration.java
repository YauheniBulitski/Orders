package root.demo.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class FlyWayConfiguration {
    @Bean(initMethod = "migrate")
    public Flyway flyway(@Autowired DataSource dataSource) {
        Flyway fly = new Flyway();
        fly.setDataSource(dataSource);
//        fly.setBaselineOnMigrate(true);
        fly.migrate();
        return fly;
    }
}

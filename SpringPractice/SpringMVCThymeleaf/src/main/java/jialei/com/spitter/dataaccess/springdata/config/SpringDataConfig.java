package jialei.com.spitter.dataaccess.springdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "jialei.com.spitter.dataaccess.springdata")
public class SpringDataConfig {
}

package jialei.com.spitter.demodataaccess.springdata.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "jialei.com.spitter.demodataaccess.springdata")
public class SpringDataConfig {
}

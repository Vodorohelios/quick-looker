package quicklooker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.regex.Pattern;

@Configuration
@Import(DataConfig.class)
@EnableJpaRepositories(basePackages="quicklooker.repositories")
@ComponentScan(basePackages={"quicklooker.services", "quicklooker.models", "quicklooker.repositories"})
public class RootConfig {
}

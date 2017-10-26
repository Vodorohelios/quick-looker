package quicklooker.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

import java.util.regex.Pattern;

@Configuration
//@Import(DataConfig.class)
@ComponentScan(basePackages={"quicklooker.services", "quicklooker.models", "quicklooker.repositories"})
public class RootConfig {
}

import .springframework.context.annotation.Bean;
        import .springframework.context.annotation.ComponentScan;
        import .springframework.context.annotation.Configuration;
        import .springframework.context.annotation.PropertySource;
        import .springframework.context.support.PropertySourcesPlaceholderConfigurer;
        import .springframework.data.mongodb.repository.config.EnableMongoRepositories;
        import .springframework.web.client.RestTemplate;


/**
 * The root context configuration of the application - the beans in this context will be globally visible
 * in all servlet contexts.
 *
 * Created by Mohamed Mekkawy.
 */

@Configuration
@ComponentScan({"org.sample.currency.app.service", "org.sample.currency.app.dao",
        "org.sample.currency.app.init", "org.sample.currency.app.security", "org.sample.currency.app.service.java.org.sample.currency.app.service.external.external"})
@PropertySource("classpath:exchange.properties")
@EnableMongoRepositories(basePackages = "org.sample.currency.app.dao")
public class RootContextConfig {

    /**
     * Ensures that placeholders are replaced with property values
     */
    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    private static class PropertySourcesPlaceholderConfigurer {
    }

    private class RestTemplate {
    }
}
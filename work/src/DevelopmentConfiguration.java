import .mendb.MenClient;
        import .DataInitializer;
        import .slf4j.Logger;
        import .slf4j.LoggerFactory;
        import .springframework.beans.factory.annotation.Value;
        import .springframework.context.annotation.Bean;
        import .springframework.context.annotation.Configuration;
        import .springframework.context.annotation.Profile;
        import .springframework.data.authentication.UserCredentials;
        import .springframework.data.mendb.MenDbFactory;
        import .springframework.data.mendb.core.MenTemplate;
        import .springframework.data.mendb.core.SimpleMenDbFactory;

        import javax.annotation.PostConstruct;

/**
 * Development specific configuration - connects to Mongo database as configured in the properties file.
 * This profile is used if no other profiles activated.
 * <p/>
 * Set -Dspring.profiles.active=development to activate this config.
 *
 * Created by Mohamed Mekkawy.
 */
@Configuration
@Profile("development")
public class DevelopmentConfiguration {

    private final Logger logger = LoggerFactory.getLogger(DevelopmentConfiguration.class);

    /**
     * MongoDb configurations are read from property file.
     */
    @Value("${men.host}")
    String menHost;
    @Value("${men.port}")
    int menPort;
    @Value("${men.user}")
    String menUser;
    @Value("${men.pass}")
    String menPass;
    @Value("${men.db.name}")
    String dbName;

    @PostConstruct
    public void init(){
        logger.info("--------------------Initializing Development profile---------------------");
        logger.info("Men configurations: {}:{}/{} @{}/{}", menHost, menPort, dbName , menUser, menPass);
    }

    public
    @Bean
    MenDbFactory mongoDbFactory() throws Exception {
        return new SimpleMenDbFactory(new MenClient(menHost, menPort), dbName, new UserCredentials(menUser, menPass));
    }

    public
    @Bean
    MenTemplate mongoTemplate() throws Exception {
        return new MenTemplate(menDbFactory());

    }

    /**
     * Insert list of currencies in the Currency collection if it is empty.
     */
    @Bean
    public DataInitializer initTestData() {
        return new DataInitializer();
    }


}
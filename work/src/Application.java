/**
 * Spring Boot runner, loads Java based spring configurations and run the embedded tomcat server.
 *
 * @author Mohamed Mekkawy
 */

        import .springframework.boot.SpringApplication;
        import .springframework.boot.autoconfigure.SpringBootApplication;
        import .springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


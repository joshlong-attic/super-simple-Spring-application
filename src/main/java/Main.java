import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

public class Main {

    @Configuration
    public static class HelloWorldConfiguration {

        @Bean
        public HelloWorldGreeter greeter() {
            Map<String, String> salutations = new HashMap<String, String>();
            salutations.put("en", "Hello, world!");
            salutations.put("it", "Buongiorno a tutto il mondo!");
            salutations.put("fr", "bonjour a tout le monde!");
            salutations.put("es", "buenas dias a todo el mundo!");
            return new HelloWorldGreeter(salutations);
        }
    }

    public static void main(String[] args) throws Exception {
        new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
    }
}

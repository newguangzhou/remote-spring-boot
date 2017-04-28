import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by long on 2017/4/21.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
}

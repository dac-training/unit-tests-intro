package pl.infoshare.junit5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.infoshare.junit5._1_exercise.MeasureUnitProperties;

@SpringBootApplication
@EnableConfigurationProperties(MeasureUnitProperties.class)
public class SpringMvcExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcExerciseApplication.class, args);
    }
}

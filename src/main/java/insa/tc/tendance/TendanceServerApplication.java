package insa.tc.tendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.el.LambdaExpression;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;

@EnableAutoConfiguration
@SpringBootApplication
@Configuration
@ComponentScan
public class TendanceServerApplication {
    public static final String ROOT = "images";

	public static void main(String[] args) {
		SpringApplication.run(TendanceServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   OutfitRepository outfitRepository,
						   StyleRepository styleRepository,
						   TypeRepository typeRepository,
						   ClotheRepository clotheRepository){
        new File(ROOT).mkdir(); //root pour les images


        Consumer styles = (e) -> Arrays.asList(
            "worker,casual,sport,gala,sapekomjamais".split(","))
                .forEach(
                        a ->  {
                            Style style = styleRepository.save(new Style(a));
                        });

        Consumer users = (e) -> Arrays.asList(
                "pfortier,cemonet,mbakkali".split(","))
                .forEach(
                        a -> {
                            User user = userRepository.save(new User(a + "@insa-lyon.fr", a, "password"));
                        });

        styles.accept(0);
        users.accept(0);

        return null;
	}
}





@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
}
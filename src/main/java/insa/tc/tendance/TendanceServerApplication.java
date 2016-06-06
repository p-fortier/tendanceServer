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

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication
@Configuration
@ComponentScan
public class TendanceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TendanceServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,
						   OutfitRepository outfitRepository,
						   StyleRepository styleRepository,
						   TypeRepository typeRepository,
						   ClotheRepository clotheRepository){
        return (evt) -> Arrays.asList(
        "pfortier,cemonet,mbakkali".split(","))
                .forEach(
                        a -> {
                                User user = userRepository.save(new User(a+"@insa-lyon.fr",a,"password"));
                        });

	}
}

@RestController
@RequestMapping("/")
class UserRestController {

    private final UserRepository userRepository;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<User> readAllUser(){
        return this.userRepository.findAll();
    }


    @RequestMapping(value = "/myprofil" ,method = RequestMethod.GET)
    Collection<User> readUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        //this.validateUser(username, password);
        return this.userRepository.findByUsername(username);
    }

    @RequestMapping(value = "/myfriends", method = RequestMethod.GET)
    Collection<User> readFriends(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password){
        //get userid
        User userid = this.userRepository.findByUsernameAndPassword(username,password);
        return userid.getFriends();

    }

    @RequestMapping(value = "/friend/{id}", method = RequestMethod.POST)
    String add(@PathVariable Long id, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password){

        User user = this.userRepository.findByUsernameAndPassword(username,password);
        user.getFriends().add(this.userRepository.findOne(id));
        this.userRepository.save(user);
        return "ok";
    }

    @Autowired
    public UserRestController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    private void validateUser(String username, String password) {
        this.userRepository.findByUsernameAndPassword(username, password);
    }

}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String userId) {
        super("could not find user '" + userId + "'.");
    }
}
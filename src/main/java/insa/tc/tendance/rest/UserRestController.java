package insa.tc.tendance.rest;

import insa.tc.tendance.User;
import insa.tc.tendance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by Patrik on 06/06/2016.
 */

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
    String addFriend(@PathVariable Long id, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password){

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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user){

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

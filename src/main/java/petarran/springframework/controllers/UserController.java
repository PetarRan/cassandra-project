package petarran.springframework.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petarran.springframework.domain_model.Product;
import petarran.springframework.domain_model.User;
import petarran.springframework.services.UserService;

import java.util.Collection;

/**
 *
 */
@RestController
@RequestMapping("/admin-api/user-api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(
            value = "/getAll"
            )
    public Collection<User> getAll(){
        return null; //TODO
    }

    @GetMapping(
            value = "/getUser/{username}"
    )
    public User getUserByUsername(@PathVariable("username")String username){
        return userService.findByUsername(username);
    }

    @PostMapping(
            value = "/addUser",
            produces = {"application/json"}
    )
    public HttpStatus addProduct(@RequestBody(required = true) User user) {
        try {
            userService.save(user);
        } catch (RuntimeException e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.ACCEPTED;
    }


}

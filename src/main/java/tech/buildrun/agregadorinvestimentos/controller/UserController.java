package tech.buildrun.agregadorinvestimentos.controller;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.agregadorinvestimentos.service.UserService;

import java.net.URI;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private  UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userId = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + userId.toString())).build();
    }

    @GetMapping("/{usarId}")
    public ResponseEntity<User> getUsaerById(@PathVariable("usarId") String userId) {
        //
        return null;
    }
}
package apiRest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import apiRest.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import apiRest.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<Users> findAll() {
       List<Users> userList = repository.findAll();
       return userList;
    }

    @GetMapping(value = "/{id}")
    public Users findOneUser(@PathVariable Long id) {
        Users userById = repository.findById(id).get();
        return userById;
    }

    @PostMapping
    public Users insertUser(@RequestBody Users user){
        Users result = repository.save(user);
        return result;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Users> editUsers(@PathVariable Long id, @RequestBody Users user) {
        Optional<Users> userByID = repository.findById(id);

        if(!userByID.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Users finalUser = userByID.get();

        finalUser.setDepartment(user.getDepartment());
        finalUser.setEmail(user.getEmail());
        finalUser.setName(user.getName());

        Users updateUser = repository.save(finalUser);

        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        Optional<Users> userByID = repository.findById(id);

        if(userByID.isPresent()){
            repository.delete(userByID.get());
            Map<String, String> responseJson = new HashMap<>();
            responseJson.put("message", "User Deleted");
            return ResponseEntity.ok(responseJson);
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "User not fount");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}

package com.GrupoDos.producto4.controller;

import com.GrupoDos.producto4.model.User;
import com.GrupoDos.producto4.repository.UserRepository;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);

    public UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // CRUD

    // Buscar todos los users
    @GetMapping("/api/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }


    // buscar una user por ID
    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> findOneById (@PathVariable Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent())
            return ResponseEntity.ok(userOpt.get());
        else
            return ResponseEntity.notFound().build();

        // Lo mismo que arriba pero escrito en programacion funcional
        // return userOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build();
    }

    /**
     * Crear un user en la bd
     *
     * @param user
     * @param headers
     * @return
     */
    @PostMapping("/api/user")
    public ResponseEntity<User> create(@RequestBody User user, @RequestHeader HttpHeaders headers) {
        System.out.println(headers.get("User-Agent"));

        if(user.getId() != null) {
            log.warn("Trying to create a laptop with id");
            return ResponseEntity.badRequest().build();
        }
        User result = userRepository.save(user);
        return ResponseEntity.ok(result);
    }


    // Modificar una laptop existente en la base de datos
    @PutMapping("/api/user")
    public ResponseEntity<User> update(@RequestBody User user) {

        if (user.getId() == null) {
            log.warn("Trying to create a non existent user");
            return ResponseEntity.badRequest().build();
        }
        if (!userRepository.existsById(user.getId())) {
            log.warn("Trying to create a non existent user");
            return ResponseEntity.notFound().build();
        }
        User result = userRepository.save(user);
        return ResponseEntity.ok(result);
    }

    /**
     * Borrar un user por id
     * @param id
     * @return
     */
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {

        if (!userRepository.existsById(id)) {
            log.warn("Trying to delete a non existent user");
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/user/")
    public ResponseEntity<User> deleteAll() {
        log.info("REST Request for deleting all users"); // Log de info
        userRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}

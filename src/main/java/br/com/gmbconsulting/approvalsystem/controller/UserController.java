package br.com.gmbconsulting.approvalsystem.controller;

import br.com.gmbconsulting.approvalsystem.domain.user.UserResponse;
import br.com.gmbconsulting.approvalsystem.domain.user.UserResquest;
import br.com.gmbconsulting.approvalsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity saveUser(@Valid @RequestBody UserResquest user, UriComponentsBuilder uriComponentsBuilder){
        var response = service.create(user);
        URI uri = uriComponentsBuilder.buildAndExpand("/users/{email}", response.getEmail()).toUri();
        response.add(linkTo(methodOn(UserController.class).getByEmail(response.getEmail())).withSelfRel());
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping(params = "email")
    public ResponseEntity getByEmail(@RequestParam String email){
        var user = service.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(params = "email")
    public ResponseEntity deleteByEmail(@RequestParam String email){
        service.deleteByEmail(email);
        return ResponseEntity.accepted().build();
    }
}

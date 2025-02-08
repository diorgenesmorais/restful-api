package com.dms.restful.api.v1.controller;

import com.dms.restful.core.domain.model.Greeting;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/users")
public class UserController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/{cpf}")
    public ResponseEntity<Greeting> fetchUserGroup(@Valid @PathVariable @CPF String cpf) {
        var content = String.format("O cpf %s é válido!", cpf);
        return ResponseEntity.ok(new Greeting(counter.incrementAndGet(), content));
    }
}

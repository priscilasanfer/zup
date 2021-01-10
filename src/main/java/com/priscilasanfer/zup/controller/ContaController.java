package com.priscilasanfer.zup.controller;

import com.priscilasanfer.zup.model.Conta;
import com.priscilasanfer.zup.service.ContaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1/contas")
@AllArgsConstructor
public class ContaController {

    private ContaService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Conta findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta createAccount(@RequestBody @Valid Conta conta) {
        return service.insert(conta);
    }
}

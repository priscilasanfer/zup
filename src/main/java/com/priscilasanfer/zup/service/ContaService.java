package com.priscilasanfer.zup.service;

import com.priscilasanfer.zup.exception.CpfAlreadyExistsException;
import com.priscilasanfer.zup.exception.EmailAlreadyExistsException;
import com.priscilasanfer.zup.exception.ResourceNotFoundException;
import com.priscilasanfer.zup.model.Conta;
import com.priscilasanfer.zup.repository.ContaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ContaService {

    private ContaRepository repository;

    public Conta insert(Conta conta) {
        isNewUser(conta);
        return repository.save(conta);
    }

    private boolean isNewUser(Conta conta) {
        if (cpfExists(conta)){
            throw new CpfAlreadyExistsException(conta.getCpf());
        }

        if (emailExists(conta)){
            throw new EmailAlreadyExistsException(conta.getEmail());
        }

        return true;
    }

    private boolean cpfExists(Conta conta){
        return repository.existsContaByCpf(conta.getCpf());
    }

    private boolean emailExists(Conta conta){
        return repository.existsContaByEmail(conta.getEmail());
    }

    public Conta findById(Long id) {
        Optional<Conta> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

}

package com.priscilasanfer.zup.repository;

import com.priscilasanfer.zup.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    boolean existsContaByCpf(String cpf);
    boolean existsContaByEmail(String email);
}

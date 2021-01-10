package com.priscilasanfer.zup.service;

import com.priscilasanfer.zup.exception.CpfAlreadyExistsException;
import com.priscilasanfer.zup.exception.EmailAlreadyExistsException;
import com.priscilasanfer.zup.model.Conta;
import com.priscilasanfer.zup.repository.ContaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class ContaServiceTest {

    @InjectMocks
    private ContaService service;

    @Mock
    private ContaRepository repository;

    @Test
    public void deveRetonarExcecaoPoisCpfJaExiste() {
        Conta conta = this.conta();
        Mockito.when(repository.existsContaByCpf(Mockito.any())).thenReturn(true);
        Assertions.assertThrows(CpfAlreadyExistsException.class, () -> {
            service.insert(conta);
        });
    }

    @Test
    public void deveRetonarExcecaoPoisEmailJaExiste() {
        Conta conta = this.conta();
        Mockito.when(repository.existsContaByEmail(Mockito.any())).thenReturn(true);
        Assertions.assertThrows(EmailAlreadyExistsException.class, () -> {
            service.insert(conta);
        });
    }

    @Test
    public void deveSalvarContaPoqueEhNovoUsuario() {
        Conta conta = this.conta();
        service.insert(conta);
        Mockito.verify(repository, Mockito.times(1)).save(conta);
    }

    @Test
    public void deveRetornarUmaContaSalvaNoBanco() {
        Conta conta = this.conta();
        Mockito.when(repository.findById(conta.getId())).thenReturn(java.util.Optional.of(conta));
        Conta resultado = service.findById(conta.getId());
        Assertions.assertEquals(resultado.getId(), conta.getId());
    }

    private Conta conta() {
        Conta conta = new Conta();
        conta.setId(1L);
        conta.setNome("Priscila");
        conta.setEmail("teste@gmail.com");
        conta.setCpf("325.027.250-70");
        conta.setDataDeNascimento("10/12/2020");
        return conta;
    }
}

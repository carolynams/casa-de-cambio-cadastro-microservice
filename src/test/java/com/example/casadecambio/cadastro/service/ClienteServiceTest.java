package com.example.casadecambio.cadastro.service;

import com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.builder.ClienteBuilder;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException.CPF_JA_CADASTRADO;
import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.of;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Before
    public void executeThis() {
        openMocks(this);
    }

    @Test
    public void shouldSaveACliente() {
        Cliente cliente = createCliente();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

        Cliente saveCLient = clienteService.save(cliente);
        assertEquals(cliente.getCpf(), saveCLient.getCpf());
        assertEquals(cliente.getNome(), saveCLient.getNome());
    }

    @Test
    public void shouldNotSaveClientWithTheSameCPf() {
        Cliente cliente = createCliente();

        when(clienteRepository.findByCpf(anyString())).thenReturn(cliente);

        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class,
                () -> clienteService.save(cliente));
        assertEquals(exception.getMessage(), CPF_JA_CADASTRADO);
    }

    private Cliente createCliente() {
        return new ClienteBuilder()
                .setNome("Carolyna Mantovani de Souza")
                .setCpf("102.663.619-19")
                .createCliente();
    }
}

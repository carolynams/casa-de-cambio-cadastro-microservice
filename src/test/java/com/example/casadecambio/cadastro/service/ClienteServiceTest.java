package com.example.casadecambio.cadastro.service;

import com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.builder.ClienteBuilder;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException.CLIENTE_NAO_ECONTRADO;
import static com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException.CPF_JA_CADASTRADO;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService service;

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

        Cliente saveCLient = service.save(cliente);
        assertEquals(cliente.getCpf(), saveCLient.getCpf());
        assertEquals(cliente.getNome(), saveCLient.getNome());
    }

    @Test
    public void shouldNotSaveClientWithTheSameCPf() {
        Cliente cliente = createCliente();

        when(clienteRepository.findByCpf(anyString())).thenReturn(cliente);

        DataIntegrityViolationException exception = assertThrows(DataIntegrityViolationException.class,
                () -> service.save(cliente));
        assertEquals(exception.getMessage(), CPF_JA_CADASTRADO);
    }

    @Test
    public void shoudlFindByCpf() {
        when(clienteRepository.findByCpf(any())).thenReturn(createCliente());

        Cliente cliente = service.findByCpf("102.663.619-19");
        assertNotNull(CLIENTE_NAO_ECONTRADO, cliente);
        verify(clienteRepository).findByCpf("102.663.619-19");
    }

    private static Cliente createCliente() {
        return new ClienteBuilder()
                .setNome("Carolyna Mantovani de Souza")
                .setCpf("102.663.619-19")
                .createCliente();
    }
}

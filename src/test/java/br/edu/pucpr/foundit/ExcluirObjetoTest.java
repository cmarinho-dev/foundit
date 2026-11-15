package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.model.Status;
import br.edu.pucpr.foundit.service.AchadosService;

// Gherkin: src/main/resources/gherkin/f51-excluir-objeto.feature
class ExcluirObjetoTest {
    private AchadosService service;

    @BeforeEach
    void iniciarServico() {
        service = new AchadosService();
    }

    @Test
    void deveExcluirObjeto_quandoIdExistir() {
        // Dado
        var fone = new Objeto();
        fone.setId(1000L);
        fone.setNome("Fone");
        service.cadastrar(fone);
        var carteira = new Objeto();
        carteira.setId(1001L);
        carteira.setNome("Carteira");
        service.cadastrar(carteira);

        // Quando: outra instância de Long com o mesmo valor do ID.
        boolean excluido = service.excluir(Long.valueOf("1000"));

        // Então
        assertTrue(excluido);
        assertTrue(service.pesquisarPorNome("Fone").isEmpty());
        assertEquals(List.of(carteira), service.filtrarPorStatus(Status.DISPONIVEL));
    }

    @Test
    void naoDeveExcluirObjeto_quandoIdNaoExistir() {
        // Dado
        var carteira = new Objeto();
        carteira.setId(1000L);
        carteira.setNome("Carteira");
        service.cadastrar(carteira);

        // Quando
        boolean excluido = service.excluir(9999L);

        // Então
        assertFalse(excluido);
        assertEquals(List.of(carteira), service.filtrarPorStatus(Status.DISPONIVEL));
    }
}

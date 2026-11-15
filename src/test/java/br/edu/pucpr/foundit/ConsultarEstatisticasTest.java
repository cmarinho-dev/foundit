package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.model.Status;
import br.edu.pucpr.foundit.service.AchadosService;

// Gherkin: src/main/resources/gherkin/f52-consultar-estatisticas.feature
class ConsultarEstatisticasTest {
    private AchadosService service;

    @BeforeEach
    void iniciarServico() {
        service = new AchadosService();
    }

    @Test
    void deveContarObjetos_quandoExistiremRegistros() {
        // Dado
        service.cadastrar(new Objeto(Status.DISPONIVEL));
        service.cadastrar(new Objeto(Status.DISPONIVEL));
        service.cadastrar(new Objeto(Status.DEVOLVIDO));

        // Quando
        var estatisticas = service.consultarEstatisticas();

        // Então
        assertEquals(Map.of(Status.DISPONIVEL, 2L, Status.DEVOLVIDO, 1L), estatisticas);
    }

    @Test
    void deveRetornarContagensZeradas_quandoNaoExistiremRegistros() {
        // Dado: serviço iniciado sem objetos cadastrados.

        // Quando
        var estatisticas = service.consultarEstatisticas();

        // Então
        assertEquals(Map.of(Status.DISPONIVEL, 0L, Status.DEVOLVIDO, 0L), estatisticas);
    }
}

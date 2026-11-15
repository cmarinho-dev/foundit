package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.model.Status;
import br.edu.pucpr.foundit.service.AchadosService;

// Gherkin: src/main/resources/gherkin/f32-filtrar-objetos.feature
class FiltrarObjetosTest {

    private AchadosService service;

    @BeforeEach
    void iniciarServico() {
        service = new AchadosService();
    }

    @Test
    void deveFiltrarObjetos_quandoStatusInformado() {
        cadastrar("Carteira", Status.DISPONIVEL);
        cadastrar("Fone", Status.DEVOLVIDO);
        cadastrar("Chave", Status.DISPONIVEL);

        var nomes = service.filtrarPorStatus(Status.DISPONIVEL).stream()
                .map(Objeto::getNome)
                .toList();

        assertEquals(List.of("Carteira", "Chave"), nomes);
    }

    @Test
    void deveRetornarListaVazia_quandoStatusNaoTiverObjetos() {
        cadastrar("Carteira", Status.DISPONIVEL);

        assertTrue(service.filtrarPorStatus(Status.DEVOLVIDO).isEmpty());
    }

    private void cadastrar(String nome, Status status) {
        var objeto = new Objeto(status);
        objeto.setNome(nome);
        service.cadastrar(objeto);
    }
}

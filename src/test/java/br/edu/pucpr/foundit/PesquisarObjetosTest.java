package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.service.AchadosService;

// Gherkin: src/main/resources/gherkin/f31-pesquisar-objetos.feature
class PesquisarObjetosTest {

    private AchadosService service;

    @BeforeEach
    void cadastrarObjetos() {
        service = new AchadosService();
        for (String nome : List.of("Fone Bluetooth", "Porta-fone", "Carteira")) {
            var objeto = new Objeto();
            objeto.setNome(nome);
            service.cadastrar(objeto);
        }
    }

    @Test
    void deveEncontrarObjetos_quandoNomeCorresponder() {
        var nomes = service.pesquisarPorNome("FONE").stream()
                .map(Objeto::getNome)
                .toList();

        assertEquals(List.of("Fone Bluetooth", "Porta-fone"), nomes);
    }

    @Test
    void deveRetornarListaVazia_quandoNomeNaoCorresponder() {
        assertTrue(service.pesquisarPorNome("Guarda-chuva").isEmpty());
    }
}

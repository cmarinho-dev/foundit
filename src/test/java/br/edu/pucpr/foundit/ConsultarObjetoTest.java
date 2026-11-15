package br.edu.pucpr.foundit;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.service.AchadosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static br.edu.pucpr.foundit.utils.TerminalOutput.recuperarSaidaTerminal;
import static org.junit.jupiter.api.Assertions.*;


// Gherkin: src/main/resources/gherkin/f22-consultar-objeto.feature
class ConsultarObjetoTest {
    @Test
    void deveRetornarObjeto_quandoIdExistir() {
        // Dado
        Objeto objeto = new Objeto();
            objeto.setNome("Fone");
            objeto.setDescricao("Fone JBL 2");
            objeto.setLocal("Bloco 5, Sala 101");

        AchadosService service = AchadosService.getInstance();
        var id = service.cadastrar(objeto);

        // Quando
        var saida = recuperarSaidaTerminal(() -> {
            service.consultar(id);
        });

        // Então
        assertEquals(
                "ID: " + objeto.getId() + "\n" +
                        "Nome: " + objeto.getNome() + "\n" +
                        "Descrição: " + objeto.getDescricao() + "\n" +
                        "Local: " + objeto.getLocal() + "\n" +
                        "Status: " + objeto.getStatus().name() + "\n",
                saida
        );
    }

    @Test
    void naoDeveRetornarNada_quandoIdNaoExistir() {
        // Dado
        var serviceSemCadastro999 = AchadosService.getInstance();

        // Quando
        var saida = recuperarSaidaTerminal(() -> {
            serviceSemCadastro999.consultar(999L);
        });

        // Então
        assertEquals("", saida);
    }
}

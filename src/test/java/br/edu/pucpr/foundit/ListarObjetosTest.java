package br.edu.pucpr.foundit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import br.edu.pucpr.foundit.model.Objeto;
import br.edu.pucpr.foundit.service.AchadosService;

// Gherkin: src/main/resources/gherkin/f21-listar-objetos.feature
class ListarObjetosTest {
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;

    @Test
    void deveListarObjetos_quandoExistiremRegistros() {
        // Dado
        var service = AchadosService.getInstance();

        var objeto = new Objeto();
            objeto.setNome("Fone");
            objeto.setDescricao("Fone JBL 2");
            objeto.setLocal("Bloco 5, Sala 101");
        service.cadastrar(objeto);

        var objeto2 = new Objeto();
            objeto2.setNome("Carregador");
            objeto2.setDescricao("Usb C - Preto");
            objeto2.setLocal("Bloco 3");
        service.cadastrar(objeto2);

        String impressaoEsperada = """
                1 - Fone
                2 - Carregador
                """;

        // Quando
        String saida = recuperarSaidaTerminal(service::listar);

        // Então
        assertEquals(impressaoEsperada, saida);
    }

    private String recuperarSaidaTerminal(Runnable acao) {
        output.reset();

        try (PrintStream captura = new PrintStream(output)) {
            System.setOut(captura);
            acao.run();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString().replace("\r\n", "\n");
    }
}
package br.edu.pucpr.foundit.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TerminalOutput {

    private static ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static PrintStream originalOut = System.out;

    public static String recuperarSaidaTerminal(Runnable acao) {
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

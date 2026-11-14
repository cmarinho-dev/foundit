package br.edu.pucpr.foundit;

import java.util.ArrayList;
import java.util.List;

import br.edu.pucpr.foundit.model.Objeto;

public class Foundit {
    private final List<Objeto> repositorio = new ArrayList<>();

    public static void main(String[] args) {
        Foundit app = new Foundit();
        Objeto objeto = new Objeto();
        objeto.setNome("Livro");
		app.cadastrar(objeto);
        System.out.println("Objetos cadastrados: " + app.repositorio.size());
    }

    public void cadastrar(Objeto objeto) {
        repositorio.add(objeto);
    }
}

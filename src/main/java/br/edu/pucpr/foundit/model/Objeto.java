package br.edu.pucpr.foundit.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Objeto {
    private Long id;
    private String nome;
    private String descricao;
    private String local;
    private Status status;

    public Objeto(Status status) { this.status = status; }
    public Objeto() { this.status = Status.DISPONIVEL; }
}

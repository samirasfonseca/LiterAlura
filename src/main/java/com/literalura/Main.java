package com.literalura.model;

import jakarta.persistence.*;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer anoNascimento;

    private Integer anoFalecimento; // pode ser null

    public Autor() {}

    public Autor(String nome, Integer anoNascimento, Integer anoFalecimento) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoFalecimento = anoFalecimento;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    @Override
    public String toString() {
        return """
               ✍ Autor: %s
               🎂 Nascimento: %d
               ⚰ Falecimento: %s
               ---------------------
               """.formatted(
                nome,
                anoNascimento,
                anoFalecimento == null ? "Vivo" : anoFalecimento
        );
    }
}

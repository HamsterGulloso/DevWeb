package com.t2.trabalho2.turma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    Integer ano;
    Periodo periodo;

    public Turma(Integer ano, Periodo periodo){
        this.ano = ano;
        this.periodo = periodo;
    }
}

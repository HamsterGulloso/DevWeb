package com.t2.trabalho2.turma;

import com.t2.trabalho2.professor.Professor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    Professor professor;

    public Turma(Integer ano, Periodo periodo, Professor professor){
        this.ano = ano;
        this.periodo = periodo;
        this.professor = professor;
    }
}

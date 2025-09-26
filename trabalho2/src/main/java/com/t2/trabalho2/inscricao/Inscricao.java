package com.t2.trabalho2.inscricao;

import java.util.Date;

import com.t2.trabalho2.aluno.Aluno;
import com.t2.trabalho2.turma.Turma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Inscricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    Date dataHora;

    @ManyToOne
    Turma turma;

    @ManyToOne
    Aluno aluno;

    public Inscricao(Date dataHora, Turma turma, Aluno aluno){
        this.dataHora = dataHora;
        this.turma = turma;
        this.aluno = aluno;
    }
}

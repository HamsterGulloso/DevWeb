package com.t2.trabalho2.inscricao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2.trabalho2.turma.Turma;
import com.t2.trabalho2.aluno.Aluno;

public interface InscricaoRepository extends JpaRepository<Inscricao, String> {
    Inscricao findById(long Id);
    Inscricao findByAluno(Aluno aluno);
    Inscricao findByTurma(Turma turma);
}

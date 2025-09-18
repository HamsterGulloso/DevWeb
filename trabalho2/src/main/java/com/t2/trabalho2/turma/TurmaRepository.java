package com.t2.trabalho2.turma;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, String> {
    Turma findById(long Id);
    Turma findByAno(Integer ano);
    Turma findByPeriodo(Periodo periodo);
}

package com.t2.trabalho2.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {
    Aluno findById(long Id);
    Aluno findByNome(String nome);
    Aluno findByEmail(String email);
}

package com.t2.trabalho2.professor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Professor findById(long Id);
    Professor findByNome(String nome);
    Professor findByEmail(String email);
}

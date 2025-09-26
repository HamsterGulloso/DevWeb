package com.t2.trabalho2;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.t2.trabalho2.aluno.*;
import com.t2.trabalho2.inscricao.Inscricao;
import com.t2.trabalho2.inscricao.InscricaoRepository;
import com.t2.trabalho2.turma.*;
import com.t2.trabalho2.professor.*;

@SpringBootConfiguration
@SpringBootApplication
@RestController
@AllArgsConstructor
public class Trabalho2Application {
    AlunoRepository alunoRepository;
    TurmaRepository turmaRepository;
    ProfessorRepository professorRepository;
    InscricaoRepository inscricaoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Trabalho2Application.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "Falae!";
    }

    @GetMapping("/aluno/novo")
    public String novoAluno(
        @RequestParam(name = "nome") String nome,
        @RequestParam(name = "email") String email
    ){
        Aluno novoAluno = alunoRepository.save(new Aluno(nome, email));
        return novoAluno.toString();
    }
    @GetMapping("/aluno/altera")
    public String alteraAluno(
        @RequestParam(name = "id") Integer id,
        @RequestParam(name = "nome") String nome,
        @RequestParam(name = "email") String email
    ){
        Aluno aluno = alunoRepository.findById(id);
        if (aluno == null) {
            return "Aluno não existe.";
        }
        aluno.setNome(nome);
        aluno.setEmail(email);
        alunoRepository.save(aluno);
        return aluno.toString();
    }
    @GetMapping("/aluno/remove")
    public String removeAluno(
        @RequestParam(name = "id") Integer id
    ){
        Aluno aluno = alunoRepository.findById(id);
        if (aluno == null) {
            return "Aluno não existe.";
        }
        alunoRepository.delete(aluno);
        return aluno.toString();
    }

    @GetMapping("/professor/novo")
    public String professorNovo(
        @RequestParam(name = "nome") String nome,
        @RequestParam(name = "email") String email
    ) {
        Professor novoProfessor = professorRepository.save(new Professor(nome, email));
        return novoProfessor.toString();
    }
    @GetMapping("/professor/altera")
    public String alteraProfessor(
        @RequestParam(name = "id") Integer id,
        @RequestParam(name = "nome") String nome,
        @RequestParam(name = "email") String email
    ){
        Professor professor = professorRepository.findById(id);
        if (professor == null) {
            return "Professor não existe.";
        }
        professor.setNome(nome);
        professor.setEmail(email);
        professorRepository.save(professor);
        return professor.toString();
    }
    @GetMapping("/professor/remove")
    public String removeProfessor(
        @RequestParam(name = "id") Integer id
    ){
        Professor professor = professorRepository.findById(id);
        if (professor == null) {
            return "Professor não existe.";
        }
        professorRepository.delete(professor);
        return professor.toString();
    }

    @GetMapping("/turma/novo")
    public String turmaNovo(
        @RequestParam(name = "ano") Integer ano,
        @RequestParam(name = "periodo") Integer periodo,
        @RequestParam(name = "professorId") Integer professorId
    ){
        Professor professor = professorRepository.findById(professorId);
        if (professor == null) {
            return "Professor inválido";
        }
        Turma t = turmaRepository.save(new Turma(
            ano,
            periodo == 1 ? Periodo.Periodo1 : Periodo.Periodo2,
            professor
        ));
        return t.toString();
    }
    @GetMapping("/turma/remove")
    public String removeTurma(
        @RequestParam(name = "id") Integer id
    ){
        Turma turma = turmaRepository.findById(id);
        if (turma == null) {
            return "Turma não existe.";
        }
        turmaRepository.delete(turma);
        return turma.toString();
    }

    @GetMapping("/inscricao/novo")
    public String inscricaoNovo(
        @RequestParam(name = "alunoId") Integer alunoId,
        @RequestParam(name = "turmaId") Integer turmaId
    ){
        Aluno aluno = alunoRepository.findById(alunoId);
        if (aluno == null) {
            return "Aluno inválido";
        }

        Turma turma = turmaRepository.findById(turmaId);
        if (turma == null) {
            return "Turma inválida";
        }

        Inscricao inscricao = inscricaoRepository.save(
            new Inscricao(
                new Date(),
                turma,
                aluno
            )
        );
        return inscricao.toString();
    }
    @GetMapping("/inscricao/remove")
    public String removeInscricao(
        @RequestParam(name = "id") Integer id
    ){
        Inscricao inscricao = inscricaoRepository.findById(id);
        if (inscricao == null) {
            return "Inscricao não existe.";
        }
        inscricaoRepository.delete(inscricao);
        return inscricao.toString();
    }
}

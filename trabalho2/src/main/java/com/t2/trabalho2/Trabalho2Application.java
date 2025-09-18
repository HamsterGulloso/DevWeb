package com.t2.trabalho2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

import com.t2.trabalho2.aluno.*;
import com.t2.trabalho2.turma.*;

@SpringBootConfiguration
@SpringBootApplication
@RestController
@AllArgsConstructor
public class Trabalho2Application {
    AlunoRepository alunoRepository;
    TurmaRepository turmaRepository;

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

    @GetMapping("/turma/novo")
    public String turmaNovo(
        @RequestParam(name = "ano") Integer ano,
        @RequestParam(name = "periodo") Integer periodo
    ){
        Turma t = turmaRepository.save(new Turma(
            ano,
            periodo == 1 ? Periodo.Periodo1 : Periodo.Periodo2
        ));
        return t.toString();
    }
}

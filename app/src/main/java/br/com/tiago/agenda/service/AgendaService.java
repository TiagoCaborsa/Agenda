package br.com.tiago.agenda.service;

import java.util.List;

import br.com.tiago.agenda.model.Aluno;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public interface AgendaService {
    rx.Observable<Void> inserirAluno(Aluno aluno);
    rx.Observable<List<Aluno>> listarAluno();
}

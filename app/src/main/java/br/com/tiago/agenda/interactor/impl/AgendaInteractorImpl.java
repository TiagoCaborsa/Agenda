package br.com.tiago.agenda.interactor.impl;

import java.util.List;

import br.com.tiago.agenda.interactor.AgendaInteractor;
import br.com.tiago.agenda.model.Aluno;
import br.com.tiago.agenda.service.AgendaService;
import br.com.tiago.agenda.service.impl.AgendaServiceImpl;
import rx.Observable;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class AgendaInteractorImpl implements AgendaInteractor {

    private AgendaService service;

    public AgendaInteractorImpl() {
        this.service = new AgendaServiceImpl();
    }

    @Override
    public Observable<Void> inserirAluno(Aluno aluno) {
        return service.inserirAluno(aluno);
    }

    @Override
    public Observable<List<Aluno>> listarAluno() {
        return service.listarAluno();
    }
}

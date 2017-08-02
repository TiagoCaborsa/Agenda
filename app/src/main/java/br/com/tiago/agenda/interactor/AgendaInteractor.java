package br.com.tiago.agenda.interactor;

import java.util.List;

import br.com.tiago.agenda.model.Aluno;
import rx.Observable;


/**
 * Created by TiagoCabral on 8/1/2017.
 */

public interface AgendaInteractor {
    Observable<Void> inserirAluno(Aluno aluno);
    Observable<List<Aluno>> listarAluno();
}

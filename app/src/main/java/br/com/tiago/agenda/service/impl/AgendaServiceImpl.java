package br.com.tiago.agenda.service.impl;

import java.util.List;

import br.com.tiago.agenda.model.Aluno;
import br.com.tiago.agenda.service.AgendaService;
import br.com.tiago.agenda.service.RetrofitConnection;
import br.com.tiago.agenda.service.endpoint.AgendaEndPoint;
import retrofit2.http.Body;
import rx.Observable;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class AgendaServiceImpl implements AgendaService {

    @Override
    public Observable<Void> inserirAluno(@Body Aluno aluno) {
        return RetrofitConnection.connect(AgendaEndPoint.class).inserirAluno(aluno);
    }

    @Override
    public Observable<List<Aluno>> listarAluno() {
        return RetrofitConnection.connect(AgendaEndPoint.class).listarAluno();
    }
}

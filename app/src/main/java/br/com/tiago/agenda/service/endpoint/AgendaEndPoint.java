package br.com.tiago.agenda.service.endpoint;

import java.util.List;

import br.com.tiago.agenda.model.Aluno;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public interface AgendaEndPoint {

    @POST("aluno")
    rx.Observable<Void> inserirAluno(@Body Aluno aluno);

    @GET("aluno")
    rx.Observable<List<Aluno>> listarAluno();


}

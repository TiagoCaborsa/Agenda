package br.com.tiago.agenda.presentation.presenter.impl;

import android.util.Log;

import java.util.List;

import br.com.tiago.agenda.interactor.AgendaInteractor;
import br.com.tiago.agenda.model.Aluno;
import br.com.tiago.agenda.presentation.presenter.ListaAgendaPresenter;
import br.com.tiago.agenda.ui.activity.ListaAgendaActivity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class ListaAgendaPresenterImpl implements ListaAgendaPresenter {

    private ListaAgendaActivity mView;
    private AgendaInteractor interactor;

    public ListaAgendaPresenterImpl(ListaAgendaActivity mView, AgendaInteractor interactor) {
        this.mView = mView;
        this.interactor = interactor;
    }

    @Override
    public void carregarLista() {

        Observable<List<Aluno>> observable = interactor.listarAluno();

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Aluno>>() {

                    @Override
                    public void onStart() {
                        super.onStart();
                        mView.showToastShortTime("Carregando...");
                    }

                    @Override
                    public void onCompleted() {
                        mView.showToastLongTime("Carregado com sucesso!");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERRO", "Método ListaAgendaPresenterImpl.carregarLista onError ", e);
                        mView.showToastLongTime("Espere um pouco e tente novamente...");
                        mView.showToastLongTime("Espere um pouco e tente novamente...");
                    }

                    @Override
                    public void onNext(List<Aluno> alunos) {
                        if (alunos != null) {
                            mView.addAll(alunos);
                        }
                    }
                });

    }
}

package br.com.tiago.agenda.presentation.presenter.impl;

import android.util.Log;

import java.util.List;

import br.com.tiago.agenda.interactor.AgendaInteractor;
import br.com.tiago.agenda.model.Aluno;
import br.com.tiago.agenda.presentation.presenter.InsereAgendaPresenter;
import br.com.tiago.agenda.ui.activity.AgendaFormularioActivity;
import br.com.tiago.agenda.ui.activity.ListaAgendaActivity;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by TiagoCabral on 8/2/2017.
 */

public class InsereAgendaPresenterImpl implements InsereAgendaPresenter {

    private AgendaFormularioActivity mView;
    private AgendaInteractor interactor;

    public InsereAgendaPresenterImpl(AgendaFormularioActivity mView, AgendaInteractor interactor) {
        this.mView = mView;
        this.interactor = interactor;
    }

    @Override
    public void inserirAgenda(Aluno aluno) {
        Observable<Void> observable = interactor.inserirAluno(aluno);

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Void>() {

                    @Override
                    public void onStart() {
                        mView.showToastShortTime("Salvando...");
                        super.onStart();
                    }

                    @Override
                    public void onCompleted() {
                        mView.showToastShortTime("Salvo com sucesso!");
                        mView.finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("ERRO", "Método ListaAgendaPresenterImpl.carregarLista onError ", e);
                        mView.showToastLongTime("Não foi possível salvar o aluno!");
                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }

                });
    }


}

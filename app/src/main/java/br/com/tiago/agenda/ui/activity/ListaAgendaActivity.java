package br.com.tiago.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.com.tiago.agenda.R;
import br.com.tiago.agenda.interactor.impl.AgendaInteractorImpl;
import br.com.tiago.agenda.model.Aluno;
import br.com.tiago.agenda.presentation.adapter.AlunoArrayAdapter;
import br.com.tiago.agenda.presentation.presenter.ListaAgendaPresenter;
import br.com.tiago.agenda.presentation.presenter.impl.ListaAgendaPresenterImpl;
import br.com.tiago.agenda.presentation.view.AgendaView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class ListaAgendaActivity extends BaseActivity implements AgendaView.Lista {

    @BindView(R.id.lista_alunos)
    ListView listaAlunosView;

    @BindView(R.id.novo_aluno)
    Button btnNovoAluno;

    private AlunoArrayAdapter alunoArrayAdapter;
    private ListaAgendaPresenter listaAgendaPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        ButterKnife.bind(this);

        //ListView listaAlunosView = (ListView) findViewById(R.id.lista_alunos);

        alunoArrayAdapter = new AlunoArrayAdapter(getBaseContext(), R.layout.list_item);
        listaAlunosView.setAdapter(alunoArrayAdapter);
        listaAgendaPresenter = new ListaAgendaPresenterImpl(this, new AgendaInteractorImpl());

        listaAlunosView.setOnItemClickListener((parent, view, position, id) -> {
            Aluno aluno = alunoArrayAdapter.getItem(position);
            Intent intent = new Intent(getBaseContext(), AgendaFormularioActivity.class);
            intent.putExtra("aluno", aluno);
            startActivity(intent);
        });

        btnNovoAluno.setOnClickListener( v -> {
            Intent intentVaiProFormulario = new Intent(ListaAgendaActivity.this, AgendaFormularioActivity.class);
            startActivity(intentVaiProFormulario);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    void carregarLista() {
        listaAgendaPresenter.carregarLista();
    }

    public void addAll(List<Aluno> alunos) {
        if (alunoArrayAdapter == null) {
            return;
        }
        alunoArrayAdapter.addAll(alunos);
    }


}

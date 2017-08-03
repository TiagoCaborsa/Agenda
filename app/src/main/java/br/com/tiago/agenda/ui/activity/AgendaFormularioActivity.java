package br.com.tiago.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.tiago.agenda.R;
import br.com.tiago.agenda.interactor.impl.AgendaInteractorImpl;
import br.com.tiago.agenda.model.Aluno;
import br.com.tiago.agenda.presentation.presenter.InsereAgendaPresenter;
import br.com.tiago.agenda.presentation.presenter.impl.InsereAgendaPresenterImpl;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TiagoCabral on 8/2/2017.
 */

public class AgendaFormularioActivity extends BaseActivity {

    @BindView(R.id.formulario_nome)
    EditText campoNome;

    @BindView(R.id.formulario_endereco)
    EditText campoEndereco;

    @BindView(R.id.formulario_telefone)
    EditText campoTelefone;

    @BindView(R.id.cadastrar_aluno)
    Button botaoSalvar;

    InsereAgendaPresenter insereAgendaPresenter;
    Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        if (intent.getSerializableExtra("aluno") != null) {
            aluno = (Aluno) intent.getSerializableExtra("aluno");
            campoNome.setText(aluno.getNome());
            campoEndereco.setText(aluno.getEndereco());
            campoTelefone.setText(aluno.getTelefone());

        } else {
            aluno = new Aluno();
        }

        insereAgendaPresenter = new InsereAgendaPresenterImpl(this, new AgendaInteractorImpl());

        botaoSalvar.setOnClickListener(v -> {
            aluno.setNome(campoNome.getText().toString());
            aluno.setEndereco(campoEndereco.getText().toString());
            aluno.setTelefone(campoTelefone.getText().toString());
            salvarAluno(aluno);
        });
    }

    private void salvarAluno(Aluno aluno) {
        insereAgendaPresenter.inserirAgenda(aluno);
    }

}

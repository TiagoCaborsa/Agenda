package br.com.tiago.agenda.presentation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.tiago.agenda.R;
import br.com.tiago.agenda.model.Aluno;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class AlunoArrayAdapter extends ArrayAdapter<Aluno> {

    private List<Aluno> alunos = new ArrayList<>();
    private Context context;

    public AlunoArrayAdapter(Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Nullable
    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public int getPosition(Aluno item) {
        return alunos.indexOf(item);
    }

    @Override
    public void clear() {
        alunos.clear();
    }

    @Override
    public void addAll(Collection<? extends Aluno> collection) {
        alunos.addAll(collection);
        notifyDataSetChanged();
    }

    @Override
    public void add(Aluno object) {
        alunos.add(object);
        notifyDataSetChanged();
    }

    @Override
    public void remove(Aluno object) {
        alunos.remove(object);
        notifyDataSetChanged();
    }


    public List<Aluno> getPacotes() {
        return alunos;
    }

    public void setPacotes(List<Aluno> alunos) {
        this.alunos = alunos;
        notifyDataSetChanged();
    }

//    @BindView(R.id.item_nome_novo)
//    TextView campoNome;
//
//    @BindView(R.id.item_telefone)
//    TextView campoTelefone;
//
//    @BindView(R.id.item_endereco)
//    TextView campoEndereco;

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno aluno = alunos.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }

        //ButterKnife.bind(this, convertView);

        TextView campoNome = (TextView) convertView.findViewById(R.id.item_nome);
        TextView campoTelefone = (TextView) convertView.findViewById(R.id.item_telefone);
        TextView campoEndereco = (TextView) convertView.findViewById(R.id.item_endereco);

        campoNome.setText(aluno.getNome());
        campoTelefone.setText(aluno.getTelefone());
        campoEndereco.setText(aluno.getEndereco());

        return convertView;
    }

}

package br.com.tiago.agenda.presentation.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import br.com.tiago.agenda.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TiagoCabral on 8/7/2017.
 */

public class AlunoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.item_nome)
    TextView nome;

    @BindView(R.id.item_endereco)
    TextView endereco;

    @BindView(R.id.item_telefone)
    TextView telefone;

    public AlunoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
        Log.i("ERRO", "AlunoViewHolder: "
                .concat("Nome: ").concat(nome.toString())
                .concat("Endereco: ").concat(endereco.toString())
                .concat("Telefone: ").concat(telefone.toString()));
    }
}

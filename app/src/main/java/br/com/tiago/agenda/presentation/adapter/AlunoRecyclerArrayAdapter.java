package br.com.tiago.agenda.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import br.com.tiago.agenda.R;
import br.com.tiago.agenda.model.Aluno;

/**
 * Created by TiagoCabral on 8/7/2017.
 */

public class AlunoRecyclerArrayAdapter extends RecyclerView.Adapter {

    private List<Aluno> alunoList;
    private Context context;

    public AlunoRecyclerArrayAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AlunoViewHolder(LayoutInflater
                .from(context)
                .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return alunoList == null ? 0 : alunoList.size();
    }

    public void addAll(List<Aluno> alunoList) {
        this.alunoList = alunoList;
    }
}

package br.com.tiago.agenda.presentation.view;

import java.util.List;

import br.com.tiago.agenda.model.Aluno;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public interface AgendaView extends BaseView {

    interface Lista {
        interface Activity extends AgendaView {
            void addAll(List<Aluno> alunos);
        }
    }

}

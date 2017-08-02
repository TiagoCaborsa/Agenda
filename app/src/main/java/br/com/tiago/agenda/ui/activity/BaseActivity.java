package br.com.tiago.agenda.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import br.com.tiago.agenda.presentation.view.BaseView;

/**
 * Created by TiagoCabral on 8/1/2017.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    @Override
    public void showToastLongTime(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToastShortTime(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
    }
}

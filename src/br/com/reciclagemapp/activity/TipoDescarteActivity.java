package br.com.reciclagemapp.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TipoDescarteActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_descarte);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tipo_descarte, menu);
        return true;
    }
}

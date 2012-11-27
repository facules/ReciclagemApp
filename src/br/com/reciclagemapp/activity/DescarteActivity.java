package br.com.reciclagemapp.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.reciclagemapp.remote.Remote;

public class DescarteActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descarte);
        
        final EditText eTextQuantidade = (EditText) findViewById(R.id.quantidade);
        final EditText eTextMotivo = (EditText) findViewById(R.id.descricaomotivo);
		Button descartar = (Button) findViewById(R.id.descarte);
		final Context context = this;
        
		descartar.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				
				Integer idUsuario = 0;
		        Integer idProduto = 0;
		        Integer idTipoDescarte = 0;
		        String quantidade = eTextQuantidade.getText().toString();
		        String motivo = eTextMotivo.getText().toString();
		        
		        Intent intentParametro = getIntent();
		        
		        Bundle bundleParametro = intentParametro.getExtras();
		        
		        if(bundleParametro != null){
		        	idProduto = bundleParametro.getInt("idProduto");
		        	idUsuario = bundleParametro.getInt("idUsuario");
		        	idTipoDescarte = bundleParametro.getInt("idTipoDescarte");
		        }
		        
		        Remote remote = new Remote();
		        remote.descartar(idUsuario, idProduto, idTipoDescarte, quantidade, motivo);
		        startActivity(new Intent(context, ListaDescarteActivity.class));
		        
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_descarte, menu);
        return true;
    }
}

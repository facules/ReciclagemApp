package br.com.reciclagemapp.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends Activity {
	
    final Context context = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

		Button listarDescartes = (Button) findViewById(R.id.listar_descarte);
		Button realizarDescarte = (Button) findViewById(R.id.realizar_descarte);
		
		listarDescartes.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				
				iniciarActivity(ListaDescarteActivity.class);
				
			}
		});
		
		realizarDescarte.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				
				iniciarActivity(ListaItensActivity.class);
				
			}
		});
        
    }
    
    private void iniciarActivity(Class activity) {
		int idUsuario = 0;
        
        Intent intentParametro = getIntent();
        
        Bundle bundleParametro = intentParametro.getExtras();
        
        if(bundleParametro != null){
        	idUsuario = bundleParametro.getInt("idUsuario");
        }
		
		Intent intent = new Intent(context, activity);
		
		Bundle parametro = new Bundle();
		
		parametro.putInt("idUsuario", idUsuario);
		
		intent.putExtras(parametro);
		
		startActivity(intent);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }
}

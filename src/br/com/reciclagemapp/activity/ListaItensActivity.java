package br.com.reciclagemapp.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.reciclagemapp.model.Produto;
import br.com.reciclagemapp.remote.Remote;

public class ListaItensActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_itens);
        
        final ListView listViewItens = (ListView) findViewById(R.id.lista_de_itens);
        
        Remote remote = new Remote();
        final List<Produto> itens = remote.listaDeItens();

		Log.i("Quantidade de itens:", String.valueOf(itens.size()));
        
        List<String> lista = new ArrayList<String>();
        for(Produto item: itens){
        	Log.i("Nome Item:", item.getProduto());
        	lista.add(item.getProduto());
        }
        
        final Context context = this;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		  android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        listViewItens.setAdapter(adapter);
        listViewItens.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				int idUsuario = 0;
		        
		        Intent intentParametro = getIntent();
		        
		        Bundle bundleParametro = intentParametro.getExtras();
		        
		        if(bundleParametro != null){
		        	idUsuario = bundleParametro.getInt("idUsuario");
		        }
				
				Intent intent = new Intent(context, TipoDescarteActivity.class);
				
				Bundle parametro = new Bundle();
				
				parametro.putInt("idUsuario", idUsuario);
				
				parametro.putInt("idProduto", itens.get(arg2).getId());
				
				intent.putExtras(parametro);
				
				startActivity(intent);
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_lista_itens, menu);
        return true;
    }
}
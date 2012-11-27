package br.com.reciclagemapp.activity;

import java.util.ArrayList;
import java.util.List;

import br.com.reciclagemapp.model.Produto;
import br.com.reciclagemapp.model.TipoDescarte;
import br.com.reciclagemapp.remote.Remote;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TipoDescarteActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_descarte);
        
        final ListView listViewTiposDescarte = (ListView) findViewById(R.id.list_tipos_descarte);
        
        Remote remote = new Remote();
        final List<TipoDescarte> tiposDescarte = remote.listaDeTipoDescarte();
        
        Log.i("Quantidade de itens:", String.valueOf(tiposDescarte.size()));
        
        List<String> lista = new ArrayList<String>();
        for(TipoDescarte tipoDescarte: tiposDescarte){
        	lista.add(tipoDescarte.getNome()+" - "+tipoDescarte.getDescricao());
        }
        
        final Context context = this;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		  android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        listViewTiposDescarte.setAdapter(adapter);
        listViewTiposDescarte.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

				/*AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage("Codigo: "+itens.get(arg2).getCodigo()
						+"\nProduto: "+itens.get(arg2).getProduto()
						+"\nDescrição: "+itens.get(arg2).getDescricao());
				AlertDialog dialogo = builder.create();
				dialogo.show();*/
		        
				int idUsuario = 0;
		        int idProduto = 0;
		        
		        Intent intentParametro = getIntent();
		        
		        Bundle bundleParametro = intentParametro.getExtras();
		        
		        if(bundleParametro != null){
		        	idProduto = bundleParametro.getInt("idProduto");
		        	idUsuario = bundleParametro.getInt("idUsuario");
		        }
				
				Intent intent = new Intent(context, DescarteActivity.class);
				
				Bundle parametro = new Bundle();
				
				parametro.putInt("idUsuario", idUsuario);
				
				parametro.putInt("idProduto", idProduto);
				
				parametro.putInt("idTipoDescarte", tiposDescarte.get(arg2).getId());
				
				intent.putExtras(parametro);
				
				startActivity(intent);
			}
		});                
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_tipo_descarte, menu);
        return true;
    }
}

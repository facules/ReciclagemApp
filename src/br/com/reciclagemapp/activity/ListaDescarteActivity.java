package br.com.reciclagemapp.activity;

import java.util.ArrayList;
import java.util.List;

import br.com.reciclagemapp.model.Produto;
import br.com.reciclagemapp.model.ProdutoDescarte;
import br.com.reciclagemapp.model.dto.DescarteDTO;
import br.com.reciclagemapp.remote.Remote;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListaDescarteActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_descarte);
        
        final ListView listViewItens = (ListView) findViewById(R.id.lista_de_descarte);
        
        Remote remote = new Remote();
        final List<DescarteDTO> descartes = remote.listaDeDescarte();

		Log.i("Quantidade de Descartes:", String.valueOf(descartes.size()));
        
        List<String> lista = new ArrayList<String>();
        for(DescarteDTO descarte: descartes){
        	Log.i("Motivo de Descarte:", descarte.getMotivo());
        	lista.add(descarte.getDescricaoProduto()+" - "
        	+descarte.getDescricaoTipoDescarte()+" - "
        			+descarte.getQuantidade());
        }
        
        final Context context = this;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        		  android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        listViewItens.setAdapter(adapter);
        listViewItens.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				builder.setMessage("Detalhes de Descarte\n\nProduto: "+descartes.get(arg2).getDescricaoProduto()
						+"\nQuantidade: "+descartes.get(arg2).getQuantidade().toString()
						+"\nTipo: "+descartes.get(arg2).getDescricaoTipoDescarte()
						+"\nMotivo: "+descartes.get(arg2).getMotivo());
				AlertDialog dialogo = builder.create();
				dialogo.show();
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_lista_descarte, menu);
        return true;
    }
}

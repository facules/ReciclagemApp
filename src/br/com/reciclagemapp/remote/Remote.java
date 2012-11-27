package br.com.reciclagemapp.remote;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;
import br.com.reciclagemapp.model.Produto;
import br.com.reciclagemapp.model.ProdutoDescarte;
import br.com.reciclagemapp.model.TipoDescarte;
import br.com.reciclagemapp.model.Usuario;
import br.com.reciclagemapp.model.dto.DescarteDTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Remote {
	
	private final String serverUri;

	public Remote() {
		this.serverUri = "http://reciclenet.servehttp.com:8181/ReciclagemWeb/android/";
	}
	
	private String webGet(String uri, Map<String, String> params) throws ClientProtocolException, IOException{
		
		if(params != null){
		int i = 0;
        for (Map.Entry<String, String> param : params.entrySet())
        {
            if(i == 0){
            	uri += "?";
            }
            else{
            	uri += "&";
            }
            try {
            	uri += param.getKey() + "=" + URLEncoder.encode(param.getValue(),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i++;
        }
		}
		
		DefaultHttpClient client = new DefaultHttpClient();
		Log.i("URI: ", uri);
		HttpGet get = new HttpGet(uri);
		HttpResponse response = client.execute(get);
		String json = EntityUtils.toString(response.getEntity());
		
		Log.i("JSON retornado pelo SERVER", "JSON:"+json);
		
		if(json.endsWith("NULL") && json.equals("")){
			return null;
		}
		
		return json;
	}

	public Usuario usuarioPorLogin(String login) {
		try {
			
			String uri = serverUri+"usuarioPorLogin";
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("login", login);

			String json = webGet(uri, params);
			
			if(json == null){
				return null;
			}
			
			Gson gson = new GsonBuilder().create();
			
			Usuario usuario = gson.fromJson(json, Usuario.class);

			return usuario;
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Produto> listaDeItens(){
		try {
		
		String uri = serverUri+"listaDeItens";
		
		String json = webGet(uri, null);
		
		if(json == null){
			return null;
		}
		
		Gson gson = new GsonBuilder().create();
		
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(json).getAsJsonArray();

		List<Produto> itens = new ArrayList<Produto>();

		for(JsonElement obj : Jarray )
	    {
	        Produto item = gson.fromJson( obj , Produto.class);
	        itens.add(item);
	    }
		
		return itens;
		
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<DescarteDTO> listaDeDescarte(){
		try {
		
		String uri = serverUri+"listaDeDescartes";
		
		String json = webGet(uri, null);
		
		if(json == null){
			return null;
		}
		
		Gson gson = new GsonBuilder().create();
		
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(json).getAsJsonArray();

		List<DescarteDTO> descartes = new ArrayList<DescarteDTO>();

		for(JsonElement obj : Jarray )
	    {
			DescarteDTO descarte = gson.fromJson( obj , DescarteDTO.class);
			Log.i("testado loop", String.valueOf(descartes.size()));
	        descartes.add(descarte);
	    }
		
		return descartes;
		
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<TipoDescarte> listaDeTipoDescarte(){
		try {
		
		String uri = serverUri+"listaTiposDescarte";
		
		String json = webGet(uri, null);
		
		if(json == null){
			return null;
		}
		
		Gson gson = new GsonBuilder().create();
		
		JsonParser parser = new JsonParser();
		JsonArray Jarray = parser.parse(json).getAsJsonArray();

		List<TipoDescarte> tiposDescartes = new ArrayList<TipoDescarte>();

		for(JsonElement obj : Jarray )
	    {
			TipoDescarte tipoDescarte = gson.fromJson( obj , TipoDescarte.class);
	        tiposDescartes.add(tipoDescarte);
	    }
		
		return tiposDescartes;
		
		} catch (Exception e) {
			return null;
		}
	}
	
	public Boolean descartar(Integer idUsuario, Integer idProduto, Integer idTipoDescarte, String quantidade, String motivo) {
		try {
			
			String uri = serverUri+"descarte";
			
			Map<String, String> params = new HashMap<String, String>();
			params.put("descarteDto.idUsuario", idUsuario.toString());
			params.put("descarteDto.idProduto", idProduto.toString());
			params.put("descarteDto.idTipoDescarte", idTipoDescarte.toString());
			params.put("descarteDto.quantidade", quantidade);
			params.put("descarteDto.motivo", motivo);

			String json = webGet(uri, params);
			
			if(json == null){
				return true;
			}

			return true;
		} catch (Exception e) {
			return null;
		}
	}
}
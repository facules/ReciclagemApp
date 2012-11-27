package br.com.reciclagemapp.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.reciclagemapp.model.Usuario;
import br.com.reciclagemapp.remote.Remote;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final EditText textUsuario = (EditText) findViewById(R.id.usuario);
		final EditText textSenha = (EditText) findViewById(R.id.senha);
		Button ok = (Button) findViewById(R.id.ok);
		final Context context = this;


		ok.setOnClickListener(new Button.OnClickListener() {

			public void onClick(View v) {
				String senha;
				senha = textSenha.getText().toString();

				if(!textUsuario.getText().toString().equals("") && !textSenha.getText().toString().equals("")){
					Remote remote = new Remote();				
					Usuario usuario = remote.usuarioPorLogin(textUsuario.getText().toString());

					if(usuario != null && usuario.getSenha().endsWith(senha)){
						
						Intent intent = new Intent(context, MenuActivity.class);
						
						Bundle parametro = new Bundle();
						
						parametro.putInt("idUsuario", usuario.getId());
						
						intent.putExtras(parametro);
						
						startActivity(intent);
					}
					else{
						AlertDialog.Builder builder = new AlertDialog.Builder(context);
						builder.setMessage("Usuario não encontrado!");
						AlertDialog dialogo = builder.create();
						dialogo.show();
					}
				}else
				{
					AlertDialog.Builder builder = new AlertDialog.Builder(context);
					builder.setMessage("preencha todos os campos!");
					AlertDialog dialogo = builder.create();
					dialogo.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
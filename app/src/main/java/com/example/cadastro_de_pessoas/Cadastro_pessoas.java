package com.example.cadastro_de_pessoas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro_pessoas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoas);

        Button botao = (Button) findViewById(R.id.buttonCadastrar);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController crud = new BancoController(getBaseContext());

                EditText editTextNome = (EditText) findViewById(R.id.editTextNome);
                EditText editTextCpf = (EditText) findViewById(R.id.editTextCpf);
                EditText editTextIdade = (EditText) findViewById(R.id.editTextIdade);
                EditText editTextSexo = (EditText) findViewById(R.id.editTextSexo);
                EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
                EditText editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);

                String nomeString = editTextNome.getText().toString();
                String cpfString = editTextCpf.getText().toString();
                String idadeString = editTextIdade.getText().toString();
                String sexoString = editTextSexo.getText().toString();
                String emailString = editTextEmail.getText().toString();
                String telefoneString = editTextTelefone.getText().toString();

                String resultado = crud.insereDados(nomeString, cpfString, sexoString, idadeString, emailString, telefoneString);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();


            }
        });
    }
}
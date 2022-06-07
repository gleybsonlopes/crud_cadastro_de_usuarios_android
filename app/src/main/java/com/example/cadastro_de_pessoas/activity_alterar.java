package com.example.cadastro_de_pessoas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_alterar extends AppCompatActivity {

    EditText nome;
    EditText cpf;
    EditText email;
    EditText idade;
    EditText sexo;
    EditText telefone;
    private Button alterar;
    private Button excluir;
    private Cursor cursor;
    private BancoController crud;
    private String codigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        nome = (EditText) findViewById(R.id.editTextAlterarNome);
        cpf = (EditText) findViewById(R.id.editTextAlterarCpf);
        email = (EditText) findViewById(R.id.editTextAlterarEmail);
        idade = (EditText) findViewById(R.id.editTextAlterarIdade);
        sexo = (EditText) findViewById(R.id.editTextAlterarSexo);
        telefone = (EditText) findViewById(R.id.editTextAlterarTelefone);

        alterar = (Button) findViewById(R.id.buttonAlterar);
        excluir = (Button) findViewById(R.id.buttonExcluir);

        cursor = crud.carregarDadosById(Integer.parseInt(codigo));

        nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.NOME)));
        cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.CPF)));
        email.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.EMAIL)));
        idade.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.IDADE)));
        sexo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.SEXO)));
        telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.TELEFONE)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.alterarDados(Integer.parseInt(codigo), nome.getText().toString(), cpf.getText().toString(),
                        email.getText().toString(), idade.getText().toString(), sexo.getText().toString(),
                        telefone.getText().toString());
                Intent intent = new Intent(activity_alterar.this, ListarDados.class);
                startActivity(intent);
                finish();

                Toast.makeText(getApplicationContext(), "Alteração realizada com Sucesso!", Toast.LENGTH_LONG).show();

            }
        });

        excluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crud.deletarDado(Integer.parseInt(codigo));
                Intent intent = new Intent(activity_alterar.this, ListarDados.class);
                startActivity(intent);
                finish();
                Toast.makeText(getApplicationContext(), "Exclusão realizada com Sucesso!", Toast.LENGTH_LONG).show();


            }
        });



    }




}
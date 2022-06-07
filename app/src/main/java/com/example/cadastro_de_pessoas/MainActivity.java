package com.example.cadastro_de_pessoas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoCadastrar;
    private Button botaoListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botaoCadastrar = (Button) findViewById(R.id.buttonCadastro);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, Cadastro_pessoas.class);
                startActivity(it);
            }
        });


        botaoListar = (Button) findViewById(R.id.buttonExibir);
        botaoListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, ListarDados.class);
                startActivity(it);
            }
        });





    }
}
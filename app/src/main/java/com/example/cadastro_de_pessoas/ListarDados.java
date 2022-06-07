package com.example.cadastro_de_pessoas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListarDados extends AppCompatActivity {

    private ListView lista;
    private RecyclerView recyclerViewPessoas;
    public static final String _ID = "ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_dados);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregarDados();

        String[] nomeCampos = new String[] {CriarBD.NOME, CriarBD.CPF};
        int[] idViews = new int[] {R.id.itemNome, R.id.itemCPF};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.layout_item, cursor, nomeCampos, idViews, 0);
        lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String codigo;
                cursor.moveToPosition(i);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriarBD.ID));

                Intent it = new Intent(ListarDados.this, activity_alterar.class);
                it.putExtra("codigo", codigo);
                startActivity(it);
                finish();
            }
        });

    }
}
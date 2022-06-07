package com.example.cadastro_de_pessoas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriarBD extends SQLiteOpenHelper {
    public static final int VERSAO = 1;
    public static final String NOME_BANCO = "banco_pessoa.db";
    public static final String TABELA = "pessoas";
    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String CPF = "cpf";
    public static final String IDADE = "idade";
    public static final String SEXO = "sexo";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";


    public CriarBD (Context context) {super(context, NOME_BANCO, null, VERSAO); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sql = "CREATE TABLE "+TABELA+" ("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + CPF +  " text,"
                + IDADE + " text,"
                + SEXO + " text,"
                + EMAIL + " text,"
                + TELEFONE + " text"
                + ") ";

        sqLiteDatabase.execSQL(sql);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

       // sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(sqLiteDatabase);

    }
}

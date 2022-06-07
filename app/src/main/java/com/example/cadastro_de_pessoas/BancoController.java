package com.example.cadastro_de_pessoas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriarBD banco;

    public BancoController(Context context){
        banco = new CriarBD(context);

    }

    public String insereDados( String nome, String cpf, String sexoPessoa, String idade, String email, String telefone){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();

        valores.put(CriarBD.NOME, nome);
        valores.put(CriarBD.CPF, cpf);
        valores.put(CriarBD.SEXO, sexoPessoa);
        valores.put(CriarBD.IDADE, idade);
        valores.put(CriarBD.EMAIL, email);
        valores.put(CriarBD.TELEFONE, telefone);

        resultado = db.insert(CriarBD.TABELA, null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao cadastrar os dados!";
        else
            return "Cadastro realizado com Sucesso!";

    }

    public Cursor carregarDados(){
        Cursor cursor;
        String[] campos = {CriarBD.ID, CriarBD.NOME};
        db = banco.getReadableDatabase();

        cursor = db.query(banco.TABELA, null,null,null, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
}

    public Cursor carregarDadosById(int id){
        Cursor cursor;
        String[] campos = {CriarBD.ID, CriarBD.NOME, CriarBD.CPF, CriarBD.EMAIL,
                CriarBD.SEXO,
                CriarBD.IDADE, CriarBD.TELEFONE};
        String where = CriarBD.ID + " = " + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriarBD.TABELA, campos, where, null, null, null, null, null);
        if(cursor!=null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;

    }

    public void alterarDados(int id, String nome, String cpf, String email, String idade, String sexo, String telefone){
        ContentValues valores;
        String where;

        db=banco.getWritableDatabase();

        where = CriarBD.ID + "=" + id;

        valores = new ContentValues();
        valores.put(CriarBD.NOME, nome);
        valores.put(CriarBD.CPF, cpf);
        valores.put(CriarBD.EMAIL, email);
        valores.put(CriarBD.IDADE, idade);
        valores.put(CriarBD.SEXO, sexo);
        valores.put(CriarBD.TELEFONE, telefone);

        db.update(CriarBD.TABELA, valores, where, null);
        db.close();

    }

    public void deletarDado(int id){
        String where = CriarBD.ID + " = "+id;
        db = banco.getReadableDatabase();
        db.delete(CriarBD.TABELA, where, null);
        db.close();
    }

    }

package com.example.trabpaulinho.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.trabpaulinho.Model.Aluno;
import com.example.trabpaulinho.R;
import com.example.trabpaulinho.adapters.notaAdapter;
import com.example.trabpaulinho.globais.Globais;

import java.util.ArrayList;


public class RelacaonotasActivity extends AppCompatActivity {

    private ListView lvNotas;
    private Spinner spAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacaonotas);

        lvNotas = findViewById(R.id.lvAlunos);
        spAluno = findViewById(R.id.spALUNO);

        ArrayList<String> arrayAlunos = new ArrayList<>();

        for (int i = 0; i < Globais.listaNotas.size(); i++) {
            String nome = Globais.listaNotas.get(i).getNome();
            if (!arrayAlunos.contains(nome)) {
                arrayAlunos.add(nome);
            }
        }

        ArrayAdapter adapterAlunos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayAlunos);

        spAluno.setAdapter(adapterAlunos);

        spAluno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                atualizaLista(Globais.listaNotas, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void atualizaLista(ArrayList<Aluno> lista, int alunoSelecionadoPosicao) {

        ArrayList<Aluno> listaFiltrada = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            String nomeAlunoSelecionado = spAluno.getItemAtPosition(alunoSelecionadoPosicao).toString();
            if (lista.get(i).getNome().equals(nomeAlunoSelecionado)) {
                listaFiltrada.add(lista.get(i));
            }
        }

        notaAdapter adapter = new notaAdapter(this, listaFiltrada);
        lvNotas.setAdapter(adapter);
    }
}
package com.example.trabpaulinho.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.trabpaulinho.Model.Aluno;
import com.example.trabpaulinho.Model.Disciplina;
import com.example.trabpaulinho.R;
import com.example.trabpaulinho.adapters.mediaAdapter;
import com.example.trabpaulinho.globais.Globais;

import java.util.ArrayList;

public class RelacaomediaActivity extends AppCompatActivity {

    private Spinner spDp;
    private ListView lvMedias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacaomedia);
        spDp = findViewById(R.id.spDisciplina);
        lvMedias = findViewById(R.id.lvDisciplina);

        Disciplina dp1 = new Disciplina();
        dp1.setId(1);
        dp1.setNome("Desenvolvimento Web");
        dp1.setPrimBim(0.0);
        dp1.setSegBim(0.0);
        dp1.setTercBim(0.0);
        dp1.setQuarBim(0.0);

        Disciplina dp2 = new Disciplina();
        dp1.setId(2);
        dp1.setNome("Projeto");
        dp1.setPrimBim(0.0);
        dp1.setSegBim(0.0);
        dp1.setTercBim(0.0);
        dp1.setQuarBim(0.0);

        Disciplina dp3 = new Disciplina();
        dp1.setId(3);
        dp1.setNome("Qualidade de software");
        dp1.setPrimBim(0.0);
        dp1.setSegBim(0.0);
        dp1.setTercBim(0.0);
        dp1.setQuarBim(0.0);

        Disciplina dp4 = new Disciplina();
        dp1.setId(4);
        dp1.setNome("Frameworks");
        dp1.setPrimBim(0.0);
        dp1.setSegBim(0.0);
        dp1.setTercBim(0.0);
        dp1.setQuarBim(0.0);

        Disciplina dp5 = new Disciplina();
        dp1.setId(5);
        dp1.setNome("Desenvolvimento Mobile");
        dp1.setPrimBim(0.0);
        dp1.setSegBim(0.0);
        dp1.setTercBim(0.0);
        dp1.setQuarBim(0.0);

        String[] vetorDisciplina = new String[]{dp1.getNome(), dp2.getNome(), dp3.getNome(), dp4.getNome(), dp5.getNome()};

        ArrayAdapter adapterDisciplina = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorDisciplina);

        spDp.setAdapter(adapterDisciplina);

        spDp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                atualizaLista(Globais.listaNotas, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void atualizaLista(ArrayList<Aluno> lista, int disciplinaSelecionadaPosicao) {

        ArrayList<Aluno> listaFiltrada = new ArrayList<>();

        for (int i = 0; i < lista.size(); i++) {
            String nomeDiscuplinaSelecionada = spDp.getItemAtPosition(disciplinaSelecionadaPosicao).toString();
            if (lista.get(i).getDisciplina().equals(nomeDiscuplinaSelecionada)) {
                listaFiltrada.add(lista.get(i));
            }

        }
        mediaAdapter adapter = new mediaAdapter(this, listaFiltrada);
        lvMedias.setAdapter(adapter);
    }

}
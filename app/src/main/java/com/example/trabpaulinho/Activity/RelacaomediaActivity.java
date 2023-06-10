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
        dp1.setPrimBim(0);
        dp1.setSegBim(0);
        dp1.setTercBim(0);
        dp1.setQuarBim(0);

        Disciplina dp2 = new Disciplina();
        dp2.setId(2);
        dp2.setNome("Projeto");
        dp2.setPrimBim(0);
        dp2.setSegBim(0);
        dp2.setTercBim(0);
        dp2.setQuarBim(0);

        Disciplina dp3 = new Disciplina();
        dp3.setId(3);
        dp3.setNome("Qualidade de software");
        dp3.setPrimBim(0);
        dp3.setSegBim(0);
        dp3.setTercBim(0);
        dp3.setQuarBim(0);

        Disciplina dp4 = new Disciplina();
        dp4.setId(4);
        dp4.setNome("Frameworks");
        dp4.setPrimBim(0);
        dp4.setSegBim(0);
        dp4.setTercBim(0);
        dp4.setQuarBim(0);

        Disciplina dp5 = new Disciplina();
        dp5.setId(5);
        dp5.setNome("Desenvolvimento Mobile");
        dp5.setPrimBim(0);
        dp5.setSegBim(0);
        dp5.setTercBim(0);
        dp5.setQuarBim(0);

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
            String nomeDisciplinaSelecionada = spDp.getItemAtPosition(disciplinaSelecionadaPosicao).toString();
            if (lista.get(i).getDisciplina().getNome().equals(nomeDisciplinaSelecionada)) {
                listaFiltrada.add(lista.get(i));
            }

        }
        mediaAdapter adapter = new mediaAdapter(this, listaFiltrada);
        adapter.notifyDataSetChanged();
        lvMedias.setAdapter(adapter);
    }

}
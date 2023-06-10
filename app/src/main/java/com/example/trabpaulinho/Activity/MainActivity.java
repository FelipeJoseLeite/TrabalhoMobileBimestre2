package com.example.trabpaulinho.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.trabpaulinho.Model.Aluno;
import com.example.trabpaulinho.Model.Disciplina;
import com.example.trabpaulinho.R;
import com.example.trabpaulinho.globais.Globais;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvRa;
    private EditText edRa;
    private TextView tvNome;
    private EditText edNome;
    private TextView tvDisciplina;
    private Spinner spDisciplina;
    private TextView tvNota;
    private TextView tvBimestre;
    private EditText edNota;
    private Spinner spBimestre;
    private Button btAdicionar;
    private Button btVernotas;
    private Button btVermedias;
    private Disciplina dpSel;
    private String bimSel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRa = findViewById(R.id.tvRa);
        edRa = findViewById(R.id.edRa);
        tvNome = findViewById(R.id.tvNome);
        edNome = findViewById(R.id.edNome);
        tvDisciplina = findViewById(R.id.tvDisciplina);
        spDisciplina = findViewById(R.id.spDisciplina);
        tvNota = findViewById(R.id.tvNota);
        tvBimestre = findViewById(R.id.tvBimestre);
        edNota = findViewById(R.id.edNota);
        spBimestre = findViewById(R.id.spBimestre);
        btAdicionar = findViewById(R.id.btAdicionar);
        btVernotas = findViewById(R.id.btVernotas);
        btVermedias = findViewById(R.id.btVermedias);

        String[] vetorBimestres = new String[]{"", "1 Bi", "2 Bi", "3 Bi", "4 Bi"};
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

        Disciplina[] vetorDisciplina = new Disciplina[]{dp1, dp2, dp3, dp4, dp5};

        ArrayAdapter adapterBimestre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestres);

        List<String> listaNomesDisciplinas = new ArrayList<>();
        for (Disciplina disciplina : vetorDisciplina) {
            listaNomesDisciplinas.add(disciplina.getNome());
        }


        ArrayAdapter<String> adapterDisciplina = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNomesDisciplinas);

        spDisciplina.setAdapter(adapterDisciplina);
        spBimestre.setAdapter(adapterBimestre);

        spDisciplina.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String nomeDisciplina = (String) spDisciplina.getItemAtPosition(position);

                Disciplina disciplinaSelecionada = null;
                for (Disciplina disciplina : vetorDisciplina) {
                    if (disciplina.getNome().equals(nomeDisciplina)) {
                        disciplinaSelecionada = disciplina;
                        dpSel = disciplinaSelecionada;
                        break;
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spBimestre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bimSel = (String) spBimestre.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btVermedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                abrirRelacaoMedias();
            }
        });

        btVernotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirRelacaoNotas();
            }
        });

        btAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        if(Globais.listaNotas == null){
            Globais.listaNotas = new ArrayList<>();
        }

    }

    private void abrirRelacaoNotas() {
        try {
            Intent intent = new Intent(this, RelacaonotasActivity.class);
            startActivity(intent);
        } catch (Exception ex) {
            ex.printStackTrace();
            Toast.makeText(this, "Ocorreu um erro: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void abrirRelacaoMedias() {
        try {
            Intent intent = new Intent(this, RelacaomediaActivity.class);
            startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(this, "Não existe alunos no sistema, favor adicionar Aluno para visualização", Toast.LENGTH_SHORT).show();
        }

    }

    private void salvar() {
        int nota = 0;
        if (!edNota.getText().toString().isEmpty()) {
            nota = Integer.parseInt(edNota.getText().toString());
        }
        if (edNome.getText().toString().isEmpty()) {
            edNome.setError("Informe o Nome do Aluno");
        }
        if (edNota.getText().toString().isEmpty()) {
            edNota.setError("Informe a nota");
        }
        if (edRa.getText().toString().isEmpty()) {
            edRa.setError("Informe o RA do Aluno");
        }
        if (nota < 0 || nota > 10) {
            edNota.setError("Informe uma nota entre 0 e 10");
        } else if (!edNome.getText().toString().isEmpty()) {
        }
        try {

            Aluno aluno = new Aluno();

            int posicaoAluno = -1;

            for (int i = 0; i < Globais.listaNotas.size(); i++) {
                if (String.valueOf(Globais.listaNotas.get(i).getRa()).equals(edRa.getText().toString())
                        && Globais.listaNotas.get(i).getNome().equals(edNome.getText().toString())
                        && Globais.listaNotas.get(i).getDisciplina().getNome().equals(dpSel.getNome())) {
                    posicaoAluno = i;
                }
            }

            if (posicaoAluno == -1) {
                aluno.setNome(edNome.getText().toString());
                aluno.setRa(Integer.parseInt(edRa.getText().toString()));
                aluno.setDisciplina(dpSel);


                switch (bimSel) {
                    case "1 Bi":
                        aluno.getDisciplina().setPrimBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                    case "2 Bi":
                        aluno.getDisciplina().setSegBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                    case "3 Bi":
                        aluno.getDisciplina().setTercBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                    case "4 Bi":
                        aluno.getDisciplina().setQuarBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                }
                    Globais.listaNotas.add(aluno);
                posicaoAluno = -1;
            }


            if (posicaoAluno != -1) {

                Globais.listaNotas.get(posicaoAluno).setNome(edNome.getText().toString());
                Globais.listaNotas.get(posicaoAluno).setRa(Integer.parseInt(edRa.getText().toString()));
                Globais.listaNotas.get(posicaoAluno).setDisciplina(dpSel);

                switch (bimSel) {
                    case "1 Bi":
                        Globais.listaNotas.get(posicaoAluno).getDisciplina().setPrimBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                    case "2 Bi":
                        Globais.listaNotas.get(posicaoAluno).getDisciplina().setSegBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                    case "3 Bi":
                        Globais.listaNotas.get(posicaoAluno).getDisciplina().setTercBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                    case "4 Bi":
                        Globais.listaNotas.get(posicaoAluno).getDisciplina().setQuarBim(Integer.parseInt(edNota.getText().toString()));
                        break;
                }
                posicaoAluno = -1;
            }

            Toast.makeText(this, "Aluno Salvo com Sucesso!", Toast.LENGTH_LONG).show();
            clear();

        } catch (Exception ex) {
            Log.e("ERRO SALVAR ALUNO: ", ex.getMessage());
        }
    }


    private void clear() {

        try {
            edNota.setText("0");
            spDisciplina.setSelection(0);
            spBimestre.setSelection(0);

        } catch (Exception ex) {
            Log.e("Erro clear", ex.getMessage());
        }
    }
}
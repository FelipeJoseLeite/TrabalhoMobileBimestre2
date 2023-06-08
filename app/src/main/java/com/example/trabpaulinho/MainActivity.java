package com.example.trabpaulinho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvRa;
    private EditText edRa;
    private TextView tvNome;
    private EditText edNome;
    private TextView tvDisciplina;
    private Spinner edDisciplina;
    private TextView tvNota;
    private TextView tvBimestre;
    private EditText edNota;
    private Spinner edBimestre;
    private Button btAdicionar;
    private Button btVernotas;
    private Button btVermedias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvRa = findViewById(R.id.tvRa);
        edRa = findViewById(R.id.edRa);
        tvNome = findViewById(R.id.tvNome);
        edNome = findViewById(R.id.edNome);
        tvDisciplina = findViewById(R.id.tvDisciplina);
        edDisciplina = findViewById(R.id.edDisciplina);
        tvNota = findViewById(R.id.tvNota);
        tvBimestre = findViewById(R.id.tvBimestre);
        edNota = findViewById(R.id.edNota);
        edBimestre = findViewById(R.id.edBimestre);
        btAdicionar = findViewById(R.id.btAdicionar);
        btVernotas = findViewById(R.id.btVernotas);
        btVermedias = findViewById(R.id.btVermedias);

        String[] vetorBimestres = new String[]{"", "1 Bim", "2 Bim", "3 Bim", "4 Bim"};
        String[] vetorDisciplina = new String[]{"", "Interpessoais", "WEB", "Qualidade", "Frameworks", "Projetos", "Mobile"};

        ArrayAdapter adapterBimestre = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorBimestres);
        ArrayAdapter adapterDisciplina = new ArrayAdapter(this, android.R.layout.simple_list_item_1, vetorDisciplina);

        edDisciplina.setAdapter(adapterDisciplina);
        edBimestre.setAdapter(adapterBimestre);

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

    }

    private void abrirRelacaoNotas() {
        Intent intent = new Intent(this, RelacaonotasActivity.class);
        startActivity(intent);
    }

    private void abrirRelacaoMedias() {
        Intent intent = new Intent(this, RelacaomediaActivity.class);
        startActivity(intent);
    }
}
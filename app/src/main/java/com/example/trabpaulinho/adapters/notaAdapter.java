package com.example.trabpaulinho.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trabpaulinho.Model.Aluno;
import com.example.trabpaulinho.R;
import com.example.trabpaulinho.globais.Globais;

import java.util.ArrayList;

public class notaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Aluno> lista;

    public notaAdapter(Context context, ArrayList<Aluno> lista) {
        this.context = context;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_lista_notas, parent, false);
        }

        Aluno aluno = lista.get(position);
        TextView tvMateria = convertView.findViewById(R.id.tvMateria);
        TextView tvMedia = convertView.findViewById(R.id.tvMedia);
        TextView tvPriBim = convertView.findViewById(R.id.Bim1);
        TextView tvSegBim = convertView.findViewById(R.id.Bim2);
        TextView tvTerBim = convertView.findViewById(R.id.Bim3);
        TextView tvQuaBim = convertView.findViewById(R.id.Bim4);

        int primBim = aluno.getDisciplina().getPrimBim();
        int segBim = aluno.getDisciplina().getSegBim();
        int terBim = aluno.getDisciplina().getTercBim();
        int quarBim = aluno.getDisciplina().getQuarBim();
        int media = (primBim + segBim + terBim + quarBim) / 4;

        tvMateria.setText(aluno.getDisciplina().getNome());
        tvPriBim.setText("1° Bim: " + primBim);
        tvSegBim.setText("2° Bim: " + segBim);
        tvTerBim.setText("3° Bim: " + terBim);
        tvQuaBim.setText("4° Bim: " + quarBim);
        tvMedia.setText("Média: " + media);

        return convertView;
    }



}

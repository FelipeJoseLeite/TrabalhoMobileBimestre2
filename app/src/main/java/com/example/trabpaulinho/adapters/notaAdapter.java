package com.example.trabpaulinho.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.trabpaulinho.Model.Aluno;
import com.example.trabpaulinho.R;

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
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.item_lista_notas,
                            parent, false);
        }

        double media = 0.0;


            media =(lista.get(position).getDisciplina().getPrimBim() + lista.get(position).getDisciplina().getSegBim()
                    + lista.get(position).getDisciplina().getTercBim()+ lista.get(position).getDisciplina().getQuarBim()) / 4;

        Aluno aluno = lista.get(position);
        TextView tvMateria = convertView.findViewById(R.id.tvMateria);
        TextView tvMedia = convertView.findViewById(R.id.tvMedia);
        TextView tvPriBim = convertView.findViewById(R.id.Bim1);
        TextView tvSegBim = convertView.findViewById(R.id.Bim2);
        TextView tvTerBim = convertView.findViewById(R.id.Bim3);
        TextView tvQuaBim = convertView.findViewById(R.id.Bim4);


        tvMateria.setText(aluno.getDisciplina().getNome());
        tvPriBim.setText(tvPriBim.getText().toString() + aluno.getDisciplina().getPrimBim());
        tvSegBim.setText(tvSegBim.getText().toString() + aluno.getDisciplina().getSegBim());
        tvTerBim.setText(tvTerBim.getText().toString() + aluno.getDisciplina().getTercBim());
        tvQuaBim.setText(tvQuaBim.getText().toString() + aluno.getDisciplina().getQuarBim());
        tvMedia.setText(tvMedia.getText().toString() + media);



        return convertView;

    }


}

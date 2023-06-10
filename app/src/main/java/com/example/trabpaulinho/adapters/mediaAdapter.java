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

public class mediaAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Aluno> lista;

    public mediaAdapter(Context context, ArrayList<Aluno> lista) {
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
                    inflate(R.layout.item_lista_media,
                            parent, false);
        }

        String resultado = "";

        int media = 0;

        Aluno aluno = lista.get(position);

        media =(lista.get(position).getDisciplina().getPrimBim() + lista.get(position).getDisciplina().getSegBim()
                + lista.get(position).getDisciplina().getTercBim()+ lista.get(position).getDisciplina().getQuarBim()) / 4;

        if(media >= 60){
            resultado = "APROVADO";
        }else{
            resultado = "REPROVADO";
        }

        TextView tvAlunoMedia = convertView.findViewById(R.id.exNome);
        TextView tvRa = convertView.findViewById(R.id.exRa);
        TextView tvResultado = convertView.findViewById(R.id.exAprovacao);
        TextView tvMediaTotal = convertView.findViewById(R.id.exMedia);
        TextView tvMateria = convertView.findViewById(R.id.tvMateria);


        tvAlunoMedia.setText(aluno.getNome());
        tvRa.setText(tvRa.getText().toString() + aluno.getRa());
        tvResultado.setText(resultado);
        tvMediaTotal.setText(String.valueOf(media));
        tvMateria.setText(aluno.getDisciplina().getNome());

        return convertView;
    }

}

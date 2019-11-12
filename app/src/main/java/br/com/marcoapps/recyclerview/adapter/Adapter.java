package br.com.marcoapps.recyclerview.adapter;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import br.com.marcoapps.recyclerview.R;
import br.com.marcoapps.recyclerview.model.Filme;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Filme> listaDeFilmes;

    public Adapter(List<Filme> listaDeFilmes) {
        this.listaDeFilmes = listaDeFilmes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,
                parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Filme filme = listaDeFilmes.get(position);
        holder.tvTitulo.setText(filme.getTitulo());
        holder.tvAno.setText(filme.getAno());
        holder.tvGenero.setText(filme.getGenero());

    }

    @Override
    public int getItemCount() {
        return listaDeFilmes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitulo;
        TextView tvAno;
        TextView tvGenero;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvAno = itemView.findViewById(R.id.tvAno);
            tvGenero = itemView.findViewById(R.id.tvGenero);
        }
    }
}

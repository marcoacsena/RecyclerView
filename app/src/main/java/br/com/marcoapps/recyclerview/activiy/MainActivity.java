package br.com.marcoapps.recyclerview.activiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.marcoapps.recyclerview.R;
import br.com.marcoapps.recyclerview.RecyclerItemClickListener;
import br.com.marcoapps.recyclerview.adapter.Adapter;
import br.com.marcoapps.recyclerview.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Filme> listaDeFilmes = new ArrayList<>();
    Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //Criar lista de filmes
        criarListaDeFilmes();

        //Configurar adapter
        Adapter adapter = new Adapter(listaDeFilmes);

        //Configurar recyclerview

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        //Configurar evento de Click

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(), recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                Filme filme = listaDeFilmes.get(position);

                                Toast.makeText(MainActivity.this,
                                        "O filme selecionado foi: " +filme.getTitulo(),
                                        Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                Toast.makeText(MainActivity.this,
                                        "O recurso clique LONGO........ foi utilizado!!!",
                                        Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            }
                        }
                )


        );

    }

    private void criarListaDeFilmes() {

        filme = new Filme("Central do Brasil", "2001", "Drama");
        listaDeFilmes.add(filme);
        filme = new Filme("Sai de Baixo", "2005", "Comédia");
        listaDeFilmes.add(filme);
        filme = new Filme("Entre Tapas e Beijos", "2010", "Comédia");
        listaDeFilmes.add(filme);
        filme = new Filme("Globo Repórter", "1970", "Documentário");
        listaDeFilmes.add(filme);
        filme = new Filme("Cidades e Soluções", "2014", "Jornalismo");
        listaDeFilmes.add(filme);
        filme = new Filme("J10", "2000", "Telejornal");
        listaDeFilmes.add(filme);
        filme = new Filme("Painel", "2015", "Política");
        listaDeFilmes.add(filme);
        filme = new Filme("Entre Aspas", "2014", "Generalidades");
        listaDeFilmes.add(filme);
        filme = new Filme("Sem Fronteiras", "2017", "Temas Internacionais");
        listaDeFilmes.add(filme);
    }
}

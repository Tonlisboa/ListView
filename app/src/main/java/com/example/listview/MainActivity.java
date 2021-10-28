package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView listLocais;
    private String[] itens = {
            "Angra dos Reis", "Caldas Novas",
            "Campos do Jordão", "Costa do Sauípe",
            "Ilhéus", "Porto Segura", "Tiradentes",
            "Praga", "Santiago", "Zurique","Caribe",
            "Buenos Aires", "Budapeste", "Cancún","Aruba",
            "Salvador", "Orlando", "Cidade do Cabo", "Rio de Janeiro"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listLocais = findViewById(R.id.listLocais);
        //Criar um adaptador para a lista
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(), //o Contexto
                android.R.layout.simple_list_item_1, //Layout
                android.R.id.text1, //Id
                itens // a ListView
        );

        //Adiciona a lista no adapter
        listLocais.setAdapter(adaptador);
        //Cria Listener para o Adapter
        listLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Pega o texto da posicão da lista (Adapter)
                String valorSelecionado = listLocais.getItemAtPosition(position).toString();
                //Exibe o texto da lista ao clicar
                Toast.makeText(getApplicationContext(),valorSelecionado,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
package com.example.a2fasejuncao;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_tarefas extends AppCompatActivity {

    boolean estadoBotao;
    TextView CaixadeTexto;
    Button botao;
    private DadosApp dadosApp;
    private int positionTarefa;
    ListView listView;


    public activity_tarefas(){
        setContentView(R.layout.activity_listview);
        listviewTarefas();
    }


    public boolean listviewTarefas(){

        listView = findViewById(R.id.listview);

        String[] values = new String[] {
                "1. Receita de bolo " , "2. Plantação de trigo", "3. Voltar para a Main"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,values);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    positionTarefa = 0;
                    dadosApp = new DadosApp();
                    Intent Tarefa1 = new Intent(view.getContext(),
                            Plano.class);
                    startActivity(Tarefa1);
                }

                if (position == 1) {
                    positionTarefa = 1;


                }

                if(position == 2){
                    positionTarefa = 2;
                    Intent inicio = new Intent(view.getContext(),MainActivity.class);
                    startActivity(inicio);
                }
            }
        });
        return true;
    }


    public void Anterior( View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}

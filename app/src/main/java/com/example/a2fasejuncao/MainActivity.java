package com.example.a2fasejuncao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean estadoBotao;
    TextView CaixadeTexto;
    Button botao;
    private DadosApp dadosApp;
    private int positionTarefa;



    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview();

    }



    public boolean listview(){

        listView = findViewById(R.id.listview);

        String[] values = new String[] {
                "1. Qr CODE", "2. Microfone", "3. Tarefas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent passo1 = new Intent(view.getContext(),Q_R_CODE.class);
                    startActivity(passo1);

                }
                if(position == 1){
                    Intent passo2 = new Intent(view.getContext(),AtivaRechonecimentoVoz.class);
                    startActivity(passo2);
                }
                if(position == 2){
                    listviewTarefas();
                }
            }
        });
        return true;
    }

    public boolean listviewTarefas(){



        setContentView(R.layout.activity_listview);


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
                            activity_tarefas.class);
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

    ///mudar
    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_DOWN) {

                    listview();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO

                    Intent anterior = new Intent(this, MainActivity.class);
                    startActivity(anterior);

                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }

    private void siguiente( Intent siguiente ) {

        startActivity( siguiente );

    }
    private void anterior( Intent anterior ) {

        startActivity( anterior );
    }

    public int getPositionTarefa(){
        return  positionTarefa;

    }

}
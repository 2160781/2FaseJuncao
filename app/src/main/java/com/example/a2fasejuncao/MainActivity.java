package com.example.a2fasejuncao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DadosApp dadosApp;
    private int positionTarefa;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();

        switch (keyCode) {

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (action == KeyEvent.ACTION_DOWN) {
                    //TODO
                    Intent LeituraQRCode = new Intent(MainActivity.this,
                            Q_R_CODE.class);
                    startActivity(LeituraQRCode);

                }
                return true;
            case KeyEvent.KEYCODE_ENTER:
                if (action == KeyEvent.ACTION_DOWN) {
                    setContentView(R.layout.activity_listview);
                    listviewTarefas();

                }
                return true;

            default:
                return super.dispatchKeyEvent(event);
        }
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
                            activity_tarefas.class);
                    startActivity(Tarefa1);
                }

                if (position == 1) {
                    positionTarefa = 1;
                    dadosApp = new DadosApp();
                  Intent Tarefa2 = new Intent(view.getContext(),
                            activity_tarefas.class);
                    startActivity(Tarefa2);

                }

                if(position == 2){
                    positionTarefa = 2;
                /*    Intent inicio = new Intent(view.getContext(),MainActivity.class);
                    startActivity(inicio);*/
                }
            }
        });
        return true;
    }

}
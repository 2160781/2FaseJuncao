package com.example.a2fasejuncao;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class Q_R_CODE extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView nScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q__r__c_o_d_e);
    }


    @Override
    public boolean dispatchKeyEvent( KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                if (action == KeyEvent.ACTION_DOWN) {

                    Intent siguiente = new Intent(this,
                            MainActivity.class);
                    startActivity(siguiente);

                }
                return true;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                if (action == KeyEvent.ACTION_DOWN) {

                        nScannerView= new ZXingScannerView( this );
                        setContentView( nScannerView );
                        nScannerView.setResultHandler( this );
                        nScannerView.startCamera();


                }
                return true;

            default:
                return super.dispatchKeyEvent(event);
        }
    }

    @Override
    public void handleResult(Result result) {

        Log.v("ResultHandler",result.getText());
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle( "Resultado do scan" );
        builder.setMessage( result.getText() );
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
        nScannerView.resumeCameraPreview( this );

    }

}
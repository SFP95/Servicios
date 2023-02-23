package com.example.servicios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver _br;


    @Override
    protected void onCreate(Bundle savedInstanceState) { //ej 3
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                procesarTeclaPulsada(intent);
            }
        };

        //filtro de intents

        IntentFilter filtro = new IntentFilter(getClass().getName());
        LocalBroadcastManager.getInstance(this).registerReceiver(_br, filtro);
    }

    private void procesarTeclaPulsada(Intent intent) {
        String tecla = intent.getStringExtra("tecla");
        TextView tvPantalla = findViewById(R.id.tvPantalla);
        tvPantalla.append(intent.getStringExtra("tecla"));
    }

    //ADD
    public static void addKey(Context c, String key) {
        Intent i = new Intent(MainActivity.class.getName());
        i.putExtra("tecla", key);
        LocalBroadcastManager.getInstance(c).sendBroadcast(i);
    }

    public void onPulsar(View v) {
        Intent i = new Intent(this,MyService.class);
        Button b= (Button) v;
        i.putExtra("etiqueta", b.getText().toString());
        startService(i);
    }




/* // ejs 1 y 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLanzar(View view) {
        Intent i = new Intent(this, MyService.class);
        startService(i);
    }

    public void onDetener(View view) {
        Intent i = new Intent(this, MyService.class);
        stopService(i);
    }
    public void onPulsar(View v) {
        Intent i = new Intent(this,MyService.class);
        Button b= (Button) v;
        i.putExtra("etiqueta", b.getText().toString());
        startService(i);
    }*/
}
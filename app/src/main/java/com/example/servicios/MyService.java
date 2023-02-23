package com.example.servicios;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.media.ToneGenerator;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;


public class MyService extends IntentService {
    private  static  final String TAG = "PDMD";
    private ToneGenerator _tg;
    protected final static int DURACION = 500;
    public MyService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
    }
    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");

        super.onDestroy();
    }
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG,"onHandleIntent"+ intent);
        String etiqueta = intent.getStringExtra("etiqueta");
        play(etiqueta);
    }

    private void play(String etiqueta) {
        int tono = 0;
        switch (etiqueta.charAt(0)){
            case '#': tono = ToneGenerator.TONE_DTMF_P; break;
            case '*': tono = ToneGenerator.TONE_DTMF_S; break;
            default: tono = ToneGenerator.TONE_DTMF_0 + (etiqueta.charAt(0) - '0'); break;
        }
        _tg.startTone(tono,DURACION);

        try {
            Thread.sleep(DURACION);
        }catch (InterruptedException e){
            throw  new RuntimeException();
        }
    }
}



/*

public class MyService extends Service {
    private  static  final String TAG = "PDMD";

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG,"onStartCommand (intente, flags, starId): ("+ intent+"-"+flags+"-"+startId+")");
        int i =0;
        while (i==0){
            //bucle infinito, si aplicamos un true, el return se queja y de esta forma lo engañamos
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"onDestroy");

        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG,"onBind");
        throw new UnsupportedOperationException("Not yet implemented");
    }
}*/

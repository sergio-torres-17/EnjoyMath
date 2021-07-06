package com.example.enjoymath.Negocio;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.enjoymath.R;

public class AuxiliarSonido {
    private MediaPlayer mediaplayer;
    private Context context;

    public AuxiliarSonido(Context context) {
        this.context = context;
    }
    public void reproducirSonido(int recurso){
        mediaplayer = MediaPlayer.create(context, recurso);
        mediaplayer.start();
    }

}

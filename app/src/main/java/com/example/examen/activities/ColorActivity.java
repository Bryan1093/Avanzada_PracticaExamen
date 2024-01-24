package com.example.examen.activities;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.examen.renderes.RenderEscena;
import com.example.examen.renderes.RenderEscenaExamen;
import com.example.examen.renderes.RenderPF;

public class ColorActivity extends Activity{

    private GLSurfaceView view;
    private GLSurfaceView.Renderer renderer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        view = new GLSurfaceView(this);
        view.setEGLContextClientVersion(1);

        //renderer = new RenderPF();
        renderer = new RenderEscena();
        view.setRenderer(renderer);
        setContentView(view);

        //en clase
        Toast.makeText(this, "onCreate", Toast.LENGTH_LONG).show();

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
        super.onPause();

    }

    @Override
    protected void onResume() {

        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
        super.onResume();
    }
}
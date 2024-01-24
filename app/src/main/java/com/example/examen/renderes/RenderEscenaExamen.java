package com.example.examen.renderes;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import com.example.examen.modelos.Cilindro;
import com.example.examen.modelos.Circulo;
import com.example.examen.modelos.Cono;
import com.example.examen.modelos.CuboPushPop;
import com.example.examen.modelos.Esfera;
import com.example.examen.modelos.Rectangulo;
import com.example.examen.modelos.Rio;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class RenderEscenaExamen implements GLSurfaceView.Renderer {
    private Circulo luna;
    private Esfera sol,copaArb1,copaArb2,copaArb3,copaArb4,copaArb5,copaArb6,copaArb7,
            nube1,nube1_1,nube1_2,nube1_3,nube1_4,nube1_5,nube1_6,
            nube2,nube2_1,nube2_2,nube2_3,nube2_4,nube2_5,nube2_6,
            nube3,nube3_1,nube3_2,nube3_3,nube3_4,nube3_5,nube3_6;
    private Rectangulo piso,paredAtras,paredFren,paredDer,techo;
    private Cilindro tronco,tronco2,tronco3,tronco4,tronco5,tronco6,tronco7;
    private Cono montana,montana2,picoPeq,picoGr;
    private Rio rio;
    private float rotacion = 0;
    private float anguloRotacion1 = 0;
    private float translacion = 0;
    private float translacionDelta = 0.3f;


    //------------------------------------------------------------------------------------
    double[][] coloresCilindros = {
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco2
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco3
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco4
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco5
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco6
            {0.4863, 0.3216, 0.3216, 1.0}, //Tronco7
    };
    double[][] coloresConos = {
            {0.4078, 0.3961, 0.3961, 1.0}, // montana
            {0.4078, 0.3961, 0.3961, 1.0}, // montana2
            {1, 1, 1, 1.0}, // picoPeq
            {1, 1, 1, 1.0}, // picoGr

    };

    double[][] coloresCirculo = {
            {1, 1, 1, 1.0}, // Luna
    };

    @Override
    public void onSurfaceCreated(GL10 gl10, EGLConfig config) {
        gl10.glClearColor(0.251f, 0.251f, 0.251f, 1.0f);
        gl10.glEnable(GL10.GL_DEPTH_TEST);
        gl10.glEnable(GL10.GL_BLEND);
        gl10.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);

        rio = new Rio();
        piso = new Rectangulo();
        paredAtras = new Rectangulo();
        paredFren = new Rectangulo();
        paredDer = new Rectangulo();
        techo = new Rectangulo();
        sol = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 0, 0, 1, 1, 1, 0, 1});
        copaArb1 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});
        copaArb2 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});
        copaArb3 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});
        copaArb4 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});
        copaArb5 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});
        copaArb6 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});
        copaArb7 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{0.2235f, 0.6039f, 0.0863f, 1, 0, 1, 0, 1});

        nube1 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube1_1 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube1_2 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube1_3 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube1_4 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube1_5 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube1_6 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});

        nube2 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube2_1 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube2_2 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube2_3 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube2_4 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube2_5 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube2_6 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});

        nube3 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube3_1 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube3_2 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube3_3 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube3_4 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube3_5 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});
        nube3_6 = new Esfera(30, 30, 0.5f, 1.0f, new float[]{1, 1, 1, 1, 1, 1, 1, 1});

        // Inicializar objeto Cilindro
        float cilindroRadius = 1.0f;
        float cilindroHeight = 2.0f;
        int cilindroNumSlices = 30;

        tronco = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[0]);
        tronco2 = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[1]);
        tronco3 = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[2]);
        tronco4 = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[3]);
        tronco5 = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[4]);
        tronco6 = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[5]);
        tronco7 = new Cilindro(cilindroRadius, cilindroHeight, cilindroNumSlices, coloresCilindros[6]);


        // Inicializar objetos Cono
        float conoRadius = 1.0f;
        float conoHeight = 2.0f;
        int conoSegmentos = 30;

        montana = new Cono(conoRadius, conoHeight, conoSegmentos, coloresConos[0]);
        montana2 = new Cono(conoRadius, conoHeight, conoSegmentos, coloresConos[1]);
        picoPeq = new Cono(conoRadius, conoHeight, conoSegmentos, coloresConos[2]);
        picoGr = new Cono(conoRadius, conoHeight, conoSegmentos, coloresConos[3]);

        // Inicializar objetos Circulos
        float circuloRadius = 1.0f;
        int circuloSegmentos = 30;

        luna = new Circulo(circuloRadius,circuloSegmentos,coloresCirculo[0]);
    }

    @Override
    public void onSurfaceChanged(GL10 gl10, int ancho, int alto) {
        // Configuración cuando cambia el tamaño de la superficie de renderizado
        float relacionAspecto = (float) ancho / (float) alto;

        gl10.glViewport(0, 0, ancho, alto);

        gl10.glMatrixMode(GL10.GL_PROJECTION);
        gl10.glLoadIdentity();
        GLU.gluPerspective(gl10, 60.0f, relacionAspecto, 1, 150);

        gl10.glMatrixMode(GL10.GL_MODELVIEW);
        gl10.glLoadIdentity();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();

        // Configuración de la cámara utilizando gluLookAt
        GLU.gluLookAt(gl,
                0.0f, 20.0f, -80.0f,   // Posición de la cámara
                8.0f, 0.0f, 0.0f,     // Punto de mira
                0 , 15, 0);              // Orientación de la cámara (eje Y arriba)

        // Aplicar rotación a todas las figuras alrededor del eje Y
        gl.glRotatef(rotacion, 0.0f, 1.0f, 0.0f);

        //PAREDES

        gl.glPushMatrix();{
            gl.glTranslatef(-1, 0, -2);
            gl.glScalef(8.0f, 0.04f, 15.0f);
            piso.dibujar(gl);
        }gl.glPopMatrix();

        gl.glPushMatrix();{
            gl.glTranslatef(-1, 10, 13);
            gl.glScalef(8.0f, 10.0f, 0.04f);
            paredAtras.dibujar(gl);
        }gl.glPopMatrix();

        gl.glPushMatrix();{
            gl.glTranslatef(-9, 10, -2);
            gl.glScalef(0.04f, 10.0f, 15.0f);
            paredDer.dibujar(gl);
        }gl.glPopMatrix();

        gl.glPushMatrix();{
            gl.glTranslatef(23, 10, -2);
            gl.glScalef(0.04f, 10.0f, 15.0f);
            paredFren.dibujar(gl);
        }gl.glPopMatrix();

        gl.glPushMatrix();{
            gl.glTranslatef(-1, 20, -2);
            gl.glScalef(8.0f, 0.04f, 15.0f);
            techo.dibujar(gl);
        }gl.glPopMatrix();

        // y---altura
        // z--adelnte o atras
        // x--laterales

        // FIGURAS ------------------------------------------------------------------------------------

        gl.glPushMatrix();
        {
            gl.glTranslatef(14, 0, 4.0f);
            gl.glScalef(9.0f, 4.0f, 9.0f);
            montana.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(0, 0, 4.0f);
            gl.glScalef(9.0f, 4.0f, 9.0f);
            montana2.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(14, 5.5f, 4.0f);
            gl.glScalef(3.5f, 2.0f, 3.5f);
            picoPeq.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(0, 5.5f, 4.0f);
            gl.glScalef(3.5f, 2.0f, 3.5f);
            picoGr.dibujar(gl);
        }
        gl.glPopMatrix();

        //----------------------------------------------------------------------------------------------------------------

        gl.glPushMatrix();
        {
            gl.glTranslatef(8, 8, 6.0f);
            gl.glScalef(5.5f, 5.5f, 5.5f);
            sol.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(-4, 14, 5.0f);
            gl.glScalef(1.5f, 1.5f, 1.5f);
            luna.dibujar(gl);
        }
        gl.glPopMatrix();

        //----------------------------------------------------------------------------------------------------------------


        gl.glPushMatrix();
        {
            gl.glPushMatrix();
            {
            gl.glTranslatef(-2, 12, 3.0f);
            gl.glScalef(4.5f, 2.5f, 2.5f);
            nube1.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(-2, 12.6f, 3.0f);
                gl.glScalef(2f, 2f, 2f);
                nube1_1.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(-1f, 12.3f, 3.0f);
                gl.glScalef(1.9f, 1.9f, 1.9f);
                nube1_2.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(-3f, 12.3f, 3.0f);
                gl.glScalef(1.9f, 1.9f, 1.9f);
                nube1_3.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(-2, 11.5f, 3.0f);
                gl.glScalef(2f, 2f, 2f);
                nube1_4.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(-3f, 11.6f, 3.0f);
                gl.glScalef(1.9f, 1.9f, 1.9f);
                nube1_5.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(-1f, 11.6f, 3.0f);
                gl.glScalef(1.9f, 1.9f, 1.9f);
                nube1_6.dibujar(gl);
            }
            gl.glPopMatrix();

        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {

            gl.glPushMatrix();
             {
            gl.glTranslatef(4, 11, -6.0f);
            gl.glScalef(5.8f, 3.5f, 3.5f);
            nube2.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(4f, 11.7f, -6.0f);
                gl.glScalef(3.0f, 3.0f, 3.0f);
                nube2_1.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(5f, 11.4f, -6.0f);
                gl.glScalef(3.0f, 3.0f, 3.0f);
                nube2_2.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(3f, 11.4f, -6.0f);
                gl.glScalef(3.0f, 3.0f, 3.0f);
                nube2_3.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(4f, 10.5f, -6.0f);
                gl.glScalef(3.0f, 3.0f, 3.0f);
                nube2_4.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(5f, 10.7f, -6.0f);
                gl.glScalef(3.0f, 3.0f, 3.0f);
                nube2_5.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(3f, 10.7f, -6.0f);
                gl.glScalef(3.0f, 3.0f, 3.0f);
                nube2_6.dibujar(gl);
            }
            gl.glPopMatrix();

        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glPushMatrix();
        {
            gl.glTranslatef(15, 12, -8.0f);
            gl.glScalef(7f, 4.5f, 4.5f);
            nube3.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
        gl.glTranslatef(15, 13.5f, -8.0f);
        gl.glScalef(2.5f, 2.5f, 2.5f);
            nube3_1.dibujar(gl);
        }
        gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(16.5f, 13.0f, -8.0f);
                gl.glScalef(2.5f, 2.5f, 3.5f);
                nube3_2.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(13.5f, 13.0f, -8.0f);
                gl.glScalef(2.5f, 2.5f, 3.5f);
                nube3_3.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(15, 10.5f, -8.0f);
                gl.glScalef(2.5f, 2.5f, 3.5f);
                nube3_4.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(16.5f, 11.0f, -8.0f);
                gl.glScalef(2.5f, 2.5f, 3.5f);
                nube3_5.dibujar(gl);
            }
            gl.glPopMatrix();

            gl.glPushMatrix();
            {
                gl.glTranslatef(13.5f, 11.0f, -8.0f);
                gl.glScalef(2.5f, 2.5f, 3.5f);
                nube3_6.dibujar(gl);
            }
            gl.glPopMatrix();

        }
        gl.glPopMatrix();

        //----------------------------------------------------------------------------------------------------------------

        gl.glPushMatrix();{
            gl.glTranslatef(5, 0.1f, -2);
            gl.glScalef(3.0f, 0.04f, 15.0f);
            rio.dibujar(gl);
        }gl.glPopMatrix();

        //----------------------------------------------------------------------------------------------------------------

        gl.glPushMatrix();
        {
            gl.glTranslatef(-1, 2, -16);
            gl.glScalef(0.5f, 1.8f, 0.5f);
            tronco.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(-1, 5, -16);
            gl.glScalef(3.5f, 4.5f, 3.5f);
            copaArb1.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(20, 2, -13);
            gl.glScalef(0.3f, 1.8f, 0.3f);
            tronco2.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(20, 5, -13);
            gl.glScalef(2.5f, 4f, 2.5f);
            copaArb2.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(16, 2, -11);
            gl.glScalef(0.3f, 1.8f, 0.3f);
            tronco3.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(16, 5, -11);
            gl.glScalef(2.5f, 4f, 2.5f);
            copaArb3.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(20, 2, -8);
            gl.glScalef(0.3f, 1.8f, 0.3f);
            tronco4.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(20, 5, -8);
            gl.glScalef(2.5f, 4f, 2.5f);
            copaArb4.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(15, 2, -8);
            gl.glScalef(0.3f, 1.8f, 0.3f);
            tronco5.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(15, 5, -8);
            gl.glScalef(2.5f, 4f, 2.5f);
            copaArb5.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(16, 2, -16);
            gl.glScalef(0.5f, 1.8f, 0.5f);
            tronco6.dibujar(gl);
        }
        gl.glPopMatrix();

        gl.glPushMatrix();
        {
            gl.glTranslatef(16, 5, -16);
            gl.glScalef(3.5f, 4.5f, 3.5f);
            copaArb6.dibujar(gl);
        }
        gl.glPopMatrix();


        // Actualizar el valor de rotación para el próximo fotograma
        rotacion += 1.0f;
        translacion += translacionDelta;
        anguloRotacion1 -= 0.02f;
    }
}
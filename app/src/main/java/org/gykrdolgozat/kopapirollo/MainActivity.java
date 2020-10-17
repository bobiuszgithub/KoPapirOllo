package org.gykrdolgozat.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView jatekosValasz, computerValasz, chp1, chp2, chp3, jhp1, jhp2, jhp3;
    private Button buttonKo, buttonOllo, buttonPapir;
    private TextView textDontetlen;
    private Random rng;
    private Toast toastComputer, toastEmber, toastDontetlen;
    private int jatekosSzam, randomSzam, eElet, cElet, dPont;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosSzam = 1;
                jatekosValasz.setImageResource(R.drawable.rock);
                computerValasztas();
                kpr();


            }
        });
        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosSzam = 2;
                jatekosValasz.setImageResource(R.drawable.paper);
                computerValasztas();
                kpr();
            }
        });

        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jatekosSzam = 3;
                jatekosValasz.setImageResource(R.drawable.scissors);
                computerValasztas();
                kpr();
            }
        });


    }

    private void computerValasztas() {
        randomSzam = rng.nextInt(3) + 1;
        if (randomSzam == 1) {
            computerValasz.setImageResource(R.drawable.rock);
        } else if (randomSzam == 2) {
            computerValasz.setImageResource(R.drawable.paper);
        } else if (randomSzam == 3) {
            computerValasz.setImageResource(R.drawable.scissors);
        }
    }

    private void kpr() {
        if (jatekosSzam == 1 && randomSzam == 3) {
            cEletCsokkentes();
        } else if (jatekosSzam == 1 && randomSzam == 2) {
            jEletCsokkentes();
        } else if (jatekosSzam == 2 && randomSzam == 1) {
            cEletCsokkentes();
        } else if (jatekosSzam == 2 && randomSzam == 3) {
            jEletCsokkentes();
        } else if (jatekosSzam == 3 && randomSzam == 1) {
            jEletCsokkentes();
        } else if (jatekosSzam == 3 && randomSzam == 2) {
            cEletCsokkentes();
        } else if (jatekosSzam == 1 && randomSzam == 1) {
            dPont++;
            textDontetlen.setText("Döntetlenek száma: " + dPont);
            toastDontetlen.show();
        } else if (jatekosSzam == 2 && randomSzam == 2) {
            dPont++;
            textDontetlen.setText("Döntetlenek száma: " + dPont);
            toastDontetlen.show();
        } else if (jatekosSzam == 3 && randomSzam == 3) {
            dPont++;
            textDontetlen.setText("Döntetlenek száma: " + dPont);
            toastDontetlen.show();
        }
    }

    private void jEletCsokkentes() {
        switch (eElet)
        {
            case 3:
                jhp3.setImageResource(R.drawable.heart1);
                eElet--;//kep modositasa
                toastComputer.show();
                break;
            case 2:
                jhp2.setImageResource(R.drawable.heart1);
                eElet--;//kep modositasa
                toastComputer.show();
                break;
            case 1:
                jhp1.setImageResource(R.drawable.heart1);
                eElet--;//kep modositasa
                builder.setTitle("Vesztettél!");
                alertDialog = builder.create();
                alertDialog.show();
                toastComputer.show();
                break;
            //vesztett szeretne uj jatekot?

            default:
                break;
        }
    } private void cEletCsokkentes() {
        switch (cElet)
        {
            case 3:
                chp3.setImageResource(R.drawable.heart1);
                cElet--;//kep modositasa
                toastEmber.show();
                break;
            case 2:
                chp2.setImageResource(R.drawable.heart1);
                cElet--;//kep modositasa
                toastEmber.show();
                break;
            case 1:
                chp1.setImageResource(R.drawable.heart1);
                cElet--;//kep modositasa
                builder.setTitle("Nyertél!");
                alertDialog = builder.create();
                alertDialog.show();
                toastEmber.show();
                break;
            //vesztett szeretne uj jatekot?

            default:
                break;
        }
    }

    private void init() {
        jatekosValasz = findViewById(R.id.iv_Evalasz);
        computerValasz = findViewById(R.id.iv_Cvalasz);
        buttonKo = findViewById(R.id.btn_ko);
        buttonOllo = findViewById(R.id.btn_ollo);
        buttonPapir = findViewById(R.id.btn_papir);
        textDontetlen = findViewById(R.id.text_dontetlen);
        jatekosSzam = 0;
        rng = new Random();
        dPont = 0;
        cElet = 3;
        eElet = 3;
        jhp1 = findViewById(R.id.j_hp1);
        jhp2 = findViewById(R.id.j_hp2);
        jhp3 = findViewById(R.id.j_hp3);

        chp1 = findViewById(R.id.c_hp1);
        chp2 = findViewById(R.id.c_hp2);
        chp3 = findViewById(R.id.c_hp3);

        toastEmber = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
        toastEmber.setGravity(Gravity.CENTER, 0, 0);
        View view = getLayoutInflater().inflate(R.layout.player_toast, (ViewGroup) findViewById(R.id.customToast));
        toastEmber.setView(view);


        toastComputer = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
        toastComputer.setGravity(Gravity.CENTER, 0, 0);
        View view1 = getLayoutInflater().inflate(R.layout.computer_toast, (ViewGroup) findViewById(R.id.customToast));
        toastComputer.setView(view1);

        toastDontetlen = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
        toastDontetlen.setGravity(Gravity.CENTER, 0, 0);
        View view2 = getLayoutInflater().inflate(R.layout.dontetlen_toast, (ViewGroup) findViewById(R.id.customToast));
        toastDontetlen.setView(view2);


        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnél e uj jatekot?");
        builder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dPont = 0;
                cElet = 3;
                eElet = 3;
                jatekosSzam = 0;
                chp3.setImageResource(R.drawable.heart2);
                chp2.setImageResource(R.drawable.heart2);
                chp1.setImageResource(R.drawable.heart2);
                jhp3.setImageResource(R.drawable.heart2);
                jhp2.setImageResource(R.drawable.heart2);
                jhp1.setImageResource(R.drawable.heart2);
                textDontetlen.setText("Döntetlenek száma: " + dPont);

            }
        });
        builder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

                dialog.cancel();
            }
        });
        builder.setTitle("Jatek vege");
        builder.setCancelable(false);

        alertDialog = builder.create();


    }


}
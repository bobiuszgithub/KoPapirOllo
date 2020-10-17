package org.gykrdolgozat.kopapirollo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

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
    private ImageView jatekosValasz, computerValasz;
    private Button buttonKo, buttonOllo, buttonPapir;
    private TextView textEmberPont, textComputerPont;
    private Random rng;
    private Toast toastComputer, toastEmber;
    private int jatekosSzam, randomSzam, elet, cPont, ePont;

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
            toastEmber.show();
            ePont++;
            textEmberPont.setText(" Ember: " + ePont);
        } else if (jatekosSzam == 1 && randomSzam == 2) {
            toastComputer.show();
            cPont++;
            textComputerPont.setText(" Computer: " + cPont);
        } else if (jatekosSzam == 2 && randomSzam == 1) {
            toastEmber.show();
            ePont++;
            textEmberPont.setText(" Ember: " + ePont);
        } else if (jatekosSzam == 2 && randomSzam == 3) {
            toastComputer.show();
            cPont++;
            textComputerPont.setText(" Computer: " + cPont);
        } else if (jatekosSzam == 3 && randomSzam == 1) {
            toastComputer.show();
            cPont++;
            textComputerPont.setText(" Computer: " + cPont);
        } else if (jatekosSzam == 3 && randomSzam == 2) {
            toastEmber.show();
            ePont++;
            textEmberPont.setText(" Ember: " + ePont);
        }

    }


    private void init() {
        jatekosValasz = findViewById(R.id.iv_Evalasz);
        computerValasz = findViewById(R.id.iv_Cvalasz);
        buttonKo = findViewById(R.id.btn_ko);
        buttonOllo = findViewById(R.id.btn_ollo);
        buttonPapir = findViewById(R.id.btn_papir);
        textEmberPont = findViewById(R.id.text_emberpont);
        textComputerPont = findViewById(R.id.text_computerpont);
        jatekosSzam = 0;
        rng = new Random();
        cPont = 0;
        ePont = 0;


        toastEmber = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
        toastEmber.setGravity(Gravity.CENTER, 0, 0);
        View view = getLayoutInflater().inflate(R.layout.player_toast, (ViewGroup) findViewById(R.id.customToast));
        toastEmber.setView(view);


        toastComputer = Toast.makeText(MainActivity.this, "", Toast.LENGTH_LONG);
        toastComputer.setGravity(Gravity.CENTER, 0, 0);
        View view1 = getLayoutInflater().inflate(R.layout.computer_toast, (ViewGroup) findViewById(R.id.customToast));
        toastComputer.setView(view1);
    }


}
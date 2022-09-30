package com.xs.perfectrolldice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ImageView imageview;
    public Button btn;
    public int r;
    public String Pn;
    public TextView roll;
    public EditText Name;
    final Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pn = "ZENSH1";
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                logo();
            }
        }, 500);

    }

    public void logo(){

        LayoutInflater inflater = getLayoutInflater();
        View log= inflater.inflate(R.layout.activity_main, null);
        log.startAnimation(AnimationUtils.loadAnimation(this, R.anim.go_up));
        setContentView(log);
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                startmain();
            }
        }, 100);

    }
    public void startmain(){
        LayoutInflater inflater = getLayoutInflater();
        View prime= inflater.inflate(R.layout.main, null);
        prime.startAnimation(AnimationUtils.loadAnimation(this, R.anim.comes_from_down));
        setContentView(prime);
        btn = findViewById(R.id.button);
        roll = findViewById(R.id.Dicetxt);
        imageview = findViewById(R.id.imageView);
        imageview.setImageResource(R.drawable.num6);

    }
    public void exitmain(){
        LayoutInflater inflater = getLayoutInflater();
        View prime= inflater.inflate(R.layout.main, null);
        prime.startAnimation(AnimationUtils.loadAnimation(this, R.anim.go_left));
        setContentView(prime);
    }
    public void exitname(){
        LayoutInflater inflater = getLayoutInflater();
        View prime= inflater.inflate(R.layout.naming, null);
        prime.startAnimation(AnimationUtils.loadAnimation(this, R.anim.go_up));
        setContentView(prime);
}
    public void startname(){
        LayoutInflater inflater = getLayoutInflater();
        View prime= inflater.inflate(R.layout.naming, null);
        prime.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide));
        setContentView(prime);
    }

    public void Setname(View view) {
        Name = findViewById(R.id.getname);
        Pn = Name.getEditableText().toString();

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                exitname();
            }
        }, 100);
        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                startmain();
            }
        }, 200);
    }
    public void Rename(View view){

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                exitmain();
            }
        }, 100);

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                startname();
            }
        }, 200);
    }
    public void roll(View view) {

        Random dice = new Random();
        do {
            r = dice.nextInt(7);
        }while(r == 0);
        roll.setText("Rolling.");

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                imageview.setImageResource(R.drawable.num2);
                imageview.animate().rotationBy(90);
                roll.setText("Rolling. .");
            }
        }, 250);

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                imageview.setImageResource(R.drawable.num3);
            }
        }, 500);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                imageview.setImageResource(R.drawable.num4);
                roll.setText("Rolling. . .");
                imageview.animate().rotationBy(90);
            }
        }, 740);

        handler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                imageview.setImageResource(R.drawable.num5);
            }
        }, 950);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (r){
                    case 1:
                        imageview.setImageResource(R.drawable.num1);
                        break;
                    case 2:
                        imageview.setImageResource(R.drawable.num2);
                        break;
                    case 3:
                        imageview.setImageResource(R.drawable.num3);
                        break;
                    case 4:
                        imageview.setImageResource(R.drawable.num4);
                        break;
                    case 5:
                        imageview.setImageResource(R.drawable.num5);
                        break;
                    case 6:
                        imageview.setImageResource(R.drawable.num6);
                        break;
                    default:
                        break;
                }

                imageview.animate().rotationBy(180);
                roll.setText(Pn + " Rolled: "+ r);

            }
        }, 1200);
    }
}

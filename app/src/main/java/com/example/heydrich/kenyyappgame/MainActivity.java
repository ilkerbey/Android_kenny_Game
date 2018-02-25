package com.example.heydrich.kenyyappgame;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView timeText ;
    TextView scoreText;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    int score;

    ImageView [] imageArrays;
    Handler handler;
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;

        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        imageArrays = new ImageView[]{imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9};


        hideImages();



        new CountDownTimer(30000,1000){


            @Override
            public void onTick(long l) {
                timeText = findViewById(R.id.time);
                timeText.setText("Time: " + l/1000);
            }

            @Override
            public void onFinish() {
                timeText = findViewById(R.id.time);
                timeText.setText("Time's off");

                handler.removeCallbacks(runnable);
            }
        }.start();

    }

    public void increaseScore(View view){
        scoreText=findViewById(R.id.score);

        score++;
        scoreText.setText("Score: "+score);
    }

    public void hideImages(){

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imageArrays){
                    image.setVisibility(View.INVISIBLE);
                }
                Random r = new Random();
                int i = r.nextInt(8-0);
                imageArrays[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);
            }
        };

        handler.post(runnable );



    }


}

package com.example.climatechange;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button news;
    private Button game;
    private Button profile;
    private Button data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news = findViewById(R.id.buttonNews);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityNews();
            }
        });

        game = findViewById(R.id.buttonGame);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityGame();
            }
        });

        profile = findViewById(R.id.buttonProfile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityProfile();
            }
        });

        data = findViewById(R.id.buttonData);
        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityData();
            }
        });
    }
    public void openActivityNews(){
        Intent intent = new Intent(this, NewsActivity.class);
        startActivity(intent);
    }
    public void openActivityGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
    public void openActivityProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    public void openActivityData(){
        Intent intent = new Intent(this, DataActivity.class);
        startActivity(intent);
    }
}

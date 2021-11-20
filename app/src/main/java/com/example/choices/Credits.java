package com.example.choices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }









    public void quitToMainMenu(View view){
        Intent quit = new Intent(this, StorySelect.class);
        startActivity(quit);
        finish();
    }
}